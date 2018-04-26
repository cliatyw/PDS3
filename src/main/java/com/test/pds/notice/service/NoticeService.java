/*[최상욱]*/
package com.test.pds.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;
import com.test.pds.gallery.service.GalleryService;

@Service
/*Transactional service에서 오류가 발생시 전부 취소시킨다.*/
@Transactional
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private NoticeFileDao noticeFileDao;
	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	public void addNotice(NoticeRequest noticeRequest, String path) {
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticeTitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		/*noticeDao.insertNotice(notice);*/
		System.out.println(notice.getNoticeContent()+"<--notice");
		System.out.println(notice.getNoticeTitle()+"<--notice");
		List<MultipartFile> multipartFile = noticeRequest.getMultipartFile();
		/*notice를 insert 시킨후 리턴받은값을 noticeid에 넣는다*/
		int noticeID = noticeDao.insertNotice(notice);
		
		if (multipartFile != null) {
			NoticeFile noticeFile = new NoticeFile();
			for (MultipartFile mf : multipartFile) {
				
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
				noticeFile.setNoticeFileExt(fileExt);
				noticeFile.setNoticeId(noticeID);
				noticeFile.setNoticeFileName(filename);
				noticeFile.setNoticeFileType(fileType);
				noticeFile.setNoticeFileSize((int) fileSize);
				noticeFileDao.insertNoticeFile(noticeFile);
			}
		}
	}

	public List<Notice> selectNoticeList() {
		List<Notice> list = new ArrayList<Notice>();
		list = noticeDao.selectNoticeList();
		return list;
	}

}
