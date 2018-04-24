package com.test.pds;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
	public String getArticleList(Model model, HttpSession session) {
		String path = session.getServletContext().getRealPath("/resources/upload");
		System.out.println(articleService.getArticleList());
		model.addAttribute("list", articleService.getArticleList());
		model.addAttribute("path", path);
		return "article/getArticleList";
	}
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String addArticle() {
		return "article/addArticle";
	}
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(ArticleRequest articleRequest, HttpSession session) {
		String path = session.getServletContext().getRealPath("/resources/upload");
		System.out.println(articleRequest);
		System.out.println(path);
		articleService.addArticle(articleRequest, path);
		return "redirect:/";
	}
}
