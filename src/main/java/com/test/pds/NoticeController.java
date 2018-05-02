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
import org.springframework.web.bind.annotation.RequestParam;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;
import com.test.pds.notice.service.Notice;
import com.test.pds.notice.service.NoticeFile;
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
		return "redirect:/selectNoticeList";
	}
	
	@RequestMapping(value = "/selectNoticeList", method = RequestMethod.GET)
	public String selectNoticeList(Model model) {
		List<Notice> list = noticeService.selectNoticeList();
		model.addAttribute("list", list);
		return "notice/selectNoticeList";
	}
	
	@RequestMapping(value = "/selectNoticeDetail", method = RequestMethod.GET)
	public String selectNoticeDetail(Model model
									,@RequestParam(value="noticeId") int noticeId) {
		Notice notice = noticeService.selectNoticeDetail(noticeId);
		model.addAttribute("notice", notice);
		return "notice/selectNoticeDetail";
	}
	
	
	/*notice삭제 (삭제시 그안의 file도 전부 삭제)*/
	@RequestMapping(value="/deleteNotice", method=RequestMethod.GET) 
		public String deleteNotice(@RequestParam(value="noticeId") int noticeId) { 
 		 	noticeService.deleteNotice(noticeId); 
			return "redirect:/selectNoticeList"; 
	} 
	
	/*notice의 file하나만 삭제*/
	@RequestMapping(value="/deleteNoticeFile", method=RequestMethod.GET) 
		public String deleteNoticeFile(Model model 
										,@RequestParam(value="noticeId") int noticeId 
										,@RequestParam(value="noticeFileId") int noticeFileId) { 
			noticeService.deleteNoticeFile(noticeFileId);
			
			Notice notice = noticeService.selectNoticeDetail(noticeId); 
			model.addAttribute("notice", notice); 
			return "notice/selectNoticeDetail"; 
		} 
}
