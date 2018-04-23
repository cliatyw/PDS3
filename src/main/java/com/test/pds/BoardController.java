package com.test.pds;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;


@Controller
public class BoardController {
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/addBoard", method = RequestMethod.GET)
	public String addBoard() {
		return "addBoard";
	}
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public String addBoard(BoardRequest boardRequest, HttpSession session) {
		System.out.println(boardRequest);
		String path = session.getServletContext().getRealPath("/resources/upload");
		//service : BoardRequest -> Board + 파일 폴더 저장
		//dao : insert
		System.out.println(path);
		boardService.addBoard(boardRequest, path);
		return "redirect:/";
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
