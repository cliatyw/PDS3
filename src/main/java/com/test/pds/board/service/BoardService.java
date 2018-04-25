/*[김도희]*/
package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
public class BoardService {
	@Autowired 
	private BoardDao boardDao;
	@Autowired
	private BoardFileDao boardFileDao;
	
	/*Board,BoardFile 입력*/
	public void insertBoard(BoardRequest boardRequest) {
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		
		Board board = new Board();
		System.out.println(boardRequest.getBoardTitle()+"<--제목");
		System.out.println(boardRequest.getBoardContent()+"<--내용");
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		/*Board 입력후 boardId를 리턴받는다*/
		int boardId= boardDao.insertBoard(board);
		
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
		
		//파일 저장(절대경로)
		File file = new File(SystemPath.UPLOAD_PATH+filename+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//boardId 
		boardFile.setBoardId(boardId);
		
		//DB BoardFile입력
		int row = boardFileDao.insertBoardFile(boardFile);  
	}
}
