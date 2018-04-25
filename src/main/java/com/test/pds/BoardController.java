/*[김도희]*/
package com.test.pds;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoard() {
		return "/board/insertBoard";
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardRequest boardRequest) {
		List<MultipartFile> boardImgs = boardRequest.getMultipartFile();
		logger.info("=====BoardController.insertBoard 실행=====");
		if(boardImgs != null) {
			for(MultipartFile file : boardImgs) {
				logger.info("boardImgs : "+file);
			}
		}
		//service : BoardRequest -> Board + 파일 폴더 저장
		//dao : insert	
		boardService.insertBoard(boardRequest);
		return "redirect:/insertBoard";
	}
	
}
