package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {
	
	public void addBoard(BoardRequest boardRequest) {
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		
		Board board = new Board();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
				
		//UUID를 이용한 파일 이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename.replace("-", "");
				
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		// board.id = 0 
		//boardDao.insertBoard(board); 
		// board.id = 1
		//boardFile.setBoardFile(boardFile);
	}
}
