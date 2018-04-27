/*[김도희]*/
package com.test.pds;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
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
		logger.debug("=====BoardController.insertBoard 실행=====");
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
		
		logger.debug("=========BoardController.selectBoardList 실행==========");
		/*list에 Board의 id,title,content와 BoardFile의 filename이 담겨있다*/
		List<Board> list = boardService.selectBoardList();
		logger.debug("BoardList : "+list);
		model.addAttribute("list", list);
		return "/board/selectBoardList";
	}
	
	/*게시판 상세보기(내용,파일)*/
	@RequestMapping(value = "/selectBoardDetail", method = RequestMethod.GET)
	public String selectBoardDetail() {
		return "/board/selectBoardDetail";
	}
}
