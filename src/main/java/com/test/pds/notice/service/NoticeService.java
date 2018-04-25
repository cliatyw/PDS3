package com.test.pds.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sun.media.jfxmedia.logging.Logger;
import com.test.pds.SystemPath;

@Service
@Transactional
public class NoticeService {
	@Autowired 
	private NoticeDao noticeDao;
	@Autowired 
	private NoticeFileDao noticeFileDao;
	public void addNotice(NoticeRequest noticeRequest, String path) {
		MultipartFile multipartFile = noticeRequest.getMultipartFile();
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticeTitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		
		NoticeFile noticeFile = new NoticeFile();
		
		//파일 이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename = filename.replace("-", "");
		
		notice.setNoticeFile(noticeFile);
		
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
		
		noticeDao.insertNotice(notice);
		System.out.println(noticeDao.insertNotice(notice));
		noticeFile.setNoticeFileExt(fileExt);
		noticeFile.setNoticeId(noticeDao.insertNotice(notice));
		noticeFile.setNoticeFileName(filename);
		noticeFile.setNoticeFileType(fileType);
		noticeFile.setNoticeFileSize((int) fileSize);
		noticeFileDao.insertNoticeFile(noticeFile);
	}
	

	 
	public List<Notice> selectNoticeList() { 
		List<Notice> list = new ArrayList<Notice>(); 
		list = noticeDao.selectNoticeList(); 
		return list; 
	} 

}
