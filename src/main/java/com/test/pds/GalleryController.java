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
import com.test.pds.gallery.service.Gallery;
import com.test.pds.gallery.service.GalleryRequest;
import com.test.pds.gallery.service.GalleryService;
import com.test.pds.notice.service.Notice;
import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;


@Controller
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@RequestMapping(value = "/insertGallery", method = RequestMethod.GET)
	public String insertGallery() {
		return "gallery/insertGallery";
	}
	
	@RequestMapping(value = "/insertGallery", method = RequestMethod.POST)
	public String insertGallery(GalleryRequest galleryRequest, HttpSession session) {
		System.out.println(galleryRequest);
		String path = session.getServletContext().getRealPath("/resources/upload");
		//service : GalleryRequest -> Gallery + 파일 폴더 저장
		//dao : insert
		System.out.println(path);
		galleryService.insertGallery(galleryRequest, path);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/selectGalleryList", method = RequestMethod.POST)
	public String selectGalleryList(Model model, HttpSession session) {
		List<Gallery> list = galleryService.selectGalleryList();
		model.addAttribute("list", list);
		return "gallery/selectGalleryList";
	}
}
