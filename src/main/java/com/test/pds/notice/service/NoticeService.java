package com.test.pds.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {
	public void addNotice(NoticeRequest noticeRequest, String path) {
		MultipartFile multipartFile = noticeRequest.getMultipartFile();
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticeTitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		
		NoticeFile noticeFile = new NoticeFile();
		
		//파일 이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename.replace("-", "");
		
		notice.setNoticeFile(noticeFile);
		
		//파일 확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		//파일 컨텐트 타입
		String fileType = multipartFile.getContentType();
		
		//파일 사이즈
		long fileSize = multipartFile.getSize();
		
		//파일 저장
		File file = new File("d:/upload/"+filename+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// board.id = 0 
		//boardDao.insertBoard(board); 
		// board.id = 1
		//boardFile.setBoardFile(boardFile);
	
	}
}
