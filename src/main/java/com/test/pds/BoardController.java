/*[김도희]*/
package com.test.pds;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;


@Controller
@Transactional
public class BoardController {
	@Autowired
	private BoardService boardService;
	private Board board;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/*게시판 등록화면*/
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard() {
		return "/board/insertBoard";
	}
	
	/*게시판 입력*/
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(Model model,BoardRequest boardRequest) {
		
		List<MultipartFile> boardImgs = boardRequest.getMultipartFile();
		logger.debug("====== BoardController.insertBoard ======");
		logger.debug("boardImgs : "+boardImgs);
		if(boardImgs != null) {
			for(MultipartFile file : boardImgs) {
				logger.debug("boardImgs : "+file);
			}
		}
		boardService.insertBoard(boardRequest);
		return "redirect:/selectBoardList";
	}

	/*게시판 목록(아이디,제목)*/
	@RequestMapping(value = "/selectBoardList", method = RequestMethod.GET)
	public String selectBoardList(Model model) {
		
		logger.debug("=========BoardController.selectBoardList==========");
		/*list에 Board의 id,title이 담겨있다*/
		List<Board> list = boardService.selectBoardList();
		logger.debug("BoardList : "+list);
		model.addAttribute("list", list);
		return "/board/selectBoardList";
	}
	
	/*게시판 상세보기(내용,파일)*/
	@RequestMapping(value = "/selectBoardDetail", method = RequestMethod.GET)
	public String selectBoardDetail(Model model,
									@RequestParam(value="boardId") int boardId) {
		
		logger.debug("=========BoardController.selectBoardDetail==========");
		logger.debug("boardId : "+boardId);
		Board board = boardService.selectBoardDetail(boardId);
		logger.debug("BoardController.selectBoardDetail >> BoardDetailboard : "+board);
		model.addAttribute("boardId",board.getBoardId());
		model.addAttribute("boardContent",board.getBoardContent());
		model.addAttribute("boardFile",board.getBoardFile());
		return "/board/selectBoardDetail";
	}
	
	 /*boardId를 매개변수로 받아  Board(boardId,boardTitle,boardContent),
	 BoardFile(fileId,fileName,boardId,fileExt,fileType,fileSize) 삭제*/
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(Model model,
							@RequestParam(value="boardId") int boardId) {
		logger.debug("=============BoardController.deleteBoard==============");
		logger.debug("boardId : "+boardId);
		boardService.deleteBoard(boardId);
		return "redirect:/selectBoardList";
	}	
}
