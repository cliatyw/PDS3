package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {
	@Autowired 
	private BoardDao boardDao;
	
	/*Board,BoardFile 입력*/
	public void addBoard(BoardRequest boardRequest,String path) {
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		
		Board board = new Board();
		System.out.println(boardRequest.getBoardTitle()+"<--제목");
		System.out.println(boardRequest.getBoardContent()+"<--내용");
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		/*DB Board입력*/
		boardDao.insertBoard(board);
		
		BoardFile boardFile = new BoardFile();
		
		//UUID를 이용한 파일 이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename.replace("-", "");
		boardFile.setBoardFileName(filename.replace("-", ""));
				
		//파일 확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		boardFile.setBoardFileExt(fileExt);
		
		//파일 컨텐트 타입
		String fileType = multipartFile.getContentType();
		boardFile.setBoardFileType(fileType);
		
		//파일 사이즈
		long fileSize = multipartFile.getSize();
		int newfileSize= (int)fileSize;
		boardFile.setBoardFileSize(newfileSize);
		
		//파일 저장
		File file = new File(path+"\\"+filename+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DB BoardFile입력
		boardDao.insertBoardFile(boardFile);
		
	}
}
