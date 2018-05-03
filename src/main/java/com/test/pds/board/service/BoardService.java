/*[김도희]*/
package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*Board,BoardFile 입력*/
	public void insertBoard(BoardRequest boardRequest) {
		logger.debug("============ BoardService.insertBoard ==========");
		
		Board board = new Board();
		logger.debug("BoardTitle : "+boardRequest.getBoardTitle());
		logger.debug("BoardContent : "+boardRequest.getBoardContent());
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		/*Board 입력후 boardId를 리턴받는다(다중파일 업로드시 id자동증가 방지)*/
		int boardId= boardDao.insertBoard(board);
			
		/*boardImgs의 파일 이름, 확장자, 컨텐트 타입, 사이즈, 저장*/
		List<MultipartFile> boardImgs = boardRequest.getMultipartFile();
		if(boardImgs!=null) {
			/*다수파일(1:N) 입력*/
			for(MultipartFile file : boardImgs) {
				UUID uuid = UUID.randomUUID();
				String saveFileName = uuid.toString().replace("-","");
				int dotIndex = file.getOriginalFilename().lastIndexOf(".");
				String fileExt = file.getOriginalFilename().substring(dotIndex+1);
				String fileType = file.getContentType();
				long fileSize = file.getSize();
				int newfileSize= (int)fileSize;
				
				BoardFile boardFile = new BoardFile();
				boardFile.setBoardFileName(saveFileName);
				boardFile.setBoardFileExt(fileExt);
				boardFile.setBoardFileType(fileType);
				boardFile.setBoardFileSize(newfileSize);	
				/*boardId 세팅*/
				boardFile.setBoardId(boardId);
				logger.debug("boardFile : "+boardFile);
				
				/*빈파일을 넘겨받았을시 DB입력 불가*/
				if(!file.isEmpty()) {
					logger.debug("boardFile 저장공간 확인");
					File fileCourse = new File(SystemPath.UPLOAD_PATH+saveFileName+"."+fileExt);
					try {
						file.transferTo(fileCourse);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					/*DB BoardFile입력*/
					boardFileDao.insertBoardFile(boardFile); 
				}
			}
		}			 
	}
	
	/*BoardList 검색 (Board의 Id,title)*/
	public List<Board> selectBoardList() {
		logger.debug("============= BoardService.selectBoardList ===============");
		return boardDao.selectBoardList();
	}
	
	/*where절이 들어감으로써 하나의 id에 여러개의 파일이므로 List가 아닌 Board타입으로 받는다
	boardId를 매개변수로 받아 게시판 상세보기(Board의 content와 BoardFile의 boardFileName) 검색*/
	public Board selectBoardDetail(int boardId){
		logger.debug("=========== BoardService.selectBoardDetail ============");
		Board board = boardDao.selectBoardDetail(boardId);
		logger.debug("BoardService.selectBoardDetail >> BoardDetailboard : "+board);
		return board;
	}
	
	  /*boardId를매개변수로 받아  Board(boardId,boardTitle,boardContent)
	  BoardFile(fileId,fileName,boardId,fileExt,fileType,fileSize)삭제*/ 
	public void deleteBoard(int boardId) {
	
		Board board = boardDao.selectBoardDetail(boardId);
		logger.debug("BoardService.deleteBoard >>>> board : "+board);
		/*boardId가 외래키로 설정되어있으므로 boardFile을 삭제후 board삭제*/
		boardFileDao.deleteBoardFile(boardId);
		boardDao.deleteBoard(boardId);	
		/*파일이 저장된 경로*/
		String DeleteFilePath = SystemPath.UPLOAD_PATH;
		/*UPLOAD_PATH에 저장된 경로에서 파일삭제(파일이름, 확장자 이용)*/
			logger.debug("BoardService.deleteBoard >>>> boardFile :  "+board.getBoardFile());
			for(BoardFile file : board.getBoardFile()) {
				logger.debug("BoardService.deleteBoard >>>> boardName : "+file.getBoardFileName());
				logger.debug("BoardService.deleteBoard >>>> boardExt : "+file.getBoardFileExt());
				/*파일 이름*/
				String fileName = file.getBoardFileName();
				/*파일 확장자*/
				String fileExt =file.getBoardFileExt();
				/*파일 삭제*/
				File newFile = new File(DeleteFilePath+fileName+"."+fileExt);
				if(newFile.exists()) {
					newFile.delete();
			}			
		}
	}	
}		
		

