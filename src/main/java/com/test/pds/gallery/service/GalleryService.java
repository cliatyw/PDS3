/*[최상욱]*/
package com.test.pds.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.BoardController;
import com.test.pds.SystemPath;

@Service
@Transactional
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	@Autowired
	private GalleryFileDao galleryFileDao;
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	public void insertGallery(GalleryRequest galleryRequest, String path) throws IOException {
		List<MultipartFile> multipartFile = galleryRequest.getMultipartFile();
		
		Gallery gallery = new Gallery();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());
		int galleryId = galleryDao.insertGallery(gallery);

		
		if (multipartFile != null) {
			for (MultipartFile mf : multipartFile) {
				GalleryFile galleryFile = new GalleryFile();
				// 파일 이름
				UUID uuid = UUID.randomUUID();
				String filename = uuid.toString();
				filename = filename.replace("-", "");
				// 파일 확장자
				int dotIndex = mf.getOriginalFilename().lastIndexOf(".");
				String fileExt = mf.getOriginalFilename().substring(dotIndex + 1);
				// 파일 컨텐트 타입
				String fileType = mf.getContentType();
				// 파일 사이즈
				long fileSize = mf.getSize();
				// 파일 저장
				File file = new File(SystemPath.UPLOAD_PATH + filename + "." + fileExt);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// apatch tika 를 사용하여 file의 마임타입을 추출한다
				Tika tika = new Tika();
				String mimeType = tika.detect(file);
				System.out.println(mimeType);
				// 마임타입이 image로 시작하면 사진이 등록되게 해준다.
				if (mimeType.startsWith("image")) {
					galleryFile.setGalleryFileExt(fileExt);
					galleryFile.setGalleryId(galleryId);
					galleryFile.setGalleryFileName(filename);
					galleryFile.setGalleryFileType(fileType);
					galleryFile.setGalleryFileSize((int) fileSize);
					galleryFileDao.insertGalleryFile(galleryFile);
				} else {
					return;
				}
			}
		}
	}
	public List<Gallery> selectGalleryList() {
		List<Gallery> list = new ArrayList<Gallery>();
		list = galleryDao.selectGalleryList();
		return list;
	}
}
