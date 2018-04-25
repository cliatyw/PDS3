/*[최상욱]*/
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

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;
import com.test.pds.notice.service.Notice;
import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;


@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@RequestMapping(value = "/insertNotice", method = RequestMethod.GET)
	public String inseryNotice() {
		return "notice/insertNotice";
	}
	
	@RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
	public String insertNotice(NoticeRequest noticeRequest, HttpSession session) {
		System.out.println(noticeRequest);
		String path = session.getServletContext().getRealPath("/resources/upload");
		//service : GalleryRequest -> Gallery + 파일 폴더 저장
		//dao : insert
		System.out.println(path);
		noticeService.addNotice(noticeRequest, path);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/selectNoticeList", method = RequestMethod.POST)
	public String selectNoticeList(Model model, HttpSession session) {
		List<Notice> list = noticeService.selectNoticeList();
		model.addAttribute("list", list);
		return "notice/selectNoticeList";
	}
}
