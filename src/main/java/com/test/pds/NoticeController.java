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
import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;


@Controller
public class NoticeController {
	private NoticeService noticeService;
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@RequestMapping(value = "/addNotice", method = RequestMethod.GET)
	public String addNotice() {
		return "notice/addNotice";
	}
	
	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	public String addNotice(NoticeRequest noticeRequest, HttpSession session) {
		System.out.println(noticeRequest);
		String path = session.getServletContext().getRealPath("/resources/upload");
		//service : NoticeRequest -> Notice + 파일 폴더 저장
		//dao : insert
		System.out.println(path);
		noticeService.addNotice(noticeRequest, path);
		return "redirect:/";
	}
}
