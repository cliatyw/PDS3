package com.test.pds.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sun.media.jfxmedia.logging.Logger;
import com.test.pds.GalleryController;
import com.test.pds.SystemPath;

@Service
@Transactional
public class GalleryService {
	@Autowired 
	private GalleryDao galleryDao;
	@Autowired 
	private GalleryFileDao galleryFileDao;
	
	public void insertGallery(GalleryRequest galleryRequest, String path) throws IOException {
		MultipartFile multipartFile = galleryRequest.getMultipartFile();
		
		Gallery gallery = new Gallery();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());
		
		GalleryFile galleryFile = new GalleryFile();
		galleryDao.insertGallery(gallery);
		//파일 이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename = filename.replace("-", "");
		
		gallery.setGalleryFile(galleryFile);
		
		//파일 확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		//파일 컨텐트 타입
		String fileType = multipartFile.getContentType();
		
		//파일 사이즈
		long fileSize = multipartFile.getSize();
		
		//파일 저장
		File file = new File(SystemPath.UPLOAD_PATH+filename+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tika tika = new Tika();
		String mimeType = tika.detect(file);
		System.out.println(mimeType);
        if (mimeType.startsWith("image")) {
    		galleryFile.setGalleryFileExt(fileExt);
    		galleryFile.setGalleryId(galleryDao.insertGallery(gallery));
    		galleryFile.setGalleryFileName(filename);
    		galleryFile.setGalleryFileType(fileType);
    		galleryFile.setGalleryFileSize((int) fileSize);
    		galleryFileDao.insertGalleryFile(galleryFile);
            return ;
        } else {
            return ;
        }
	}
	 
	public List<Gallery> selectGalleryList() { 
		List<Gallery> list = new ArrayList<Gallery>(); 
		list = galleryDao.selectGalleryList(); 
		return list; 
	} 

}
