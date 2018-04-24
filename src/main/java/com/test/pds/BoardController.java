/*[김도희]*/
package com.test.pds;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String addBoard() {
		return "/board/insertBoard";
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String addBoard(BoardRequest boardRequest) {
		//service : BoardRequest -> Board + 파일 폴더 저장
		//dao : insert	
		boardService.addBoard(boardRequest);
		return "redirect:/insertBoard";
	}
	
}
