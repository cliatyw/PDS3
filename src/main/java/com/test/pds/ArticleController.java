/*[김기성]*/
package com.test.pds;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	/*id를 매개변수로 받아 그 id에 해당하는 file의 정보를 가져오기 위하여
	service에서 selectArticleDetail매서드를 불러오고 model에 셋팅한다.
	그리고 selectArticleDetail.jsp로 포워드시킨다.*/
	@RequestMapping(value = "/selectArticleDetail", method = RequestMethod.GET)
	public String selectArticleDetail(Model model
			, @RequestParam(value="articleId") int articleId) {
		model.addAttribute("article", articleService.selectArticleDetail(articleId));
		return "article/selectArticleDetail";
	}
	/*페이징작업을 위해 currentPage, pagePerRow를 매개변수로 받고
	service에서 selectArticleList를 불러오는 매서드를 실행하여 map에 저장한후
	model에 셋팅한다. 그리고 selectArticleList jsp로 포워드 시킨다.*/
	@RequestMapping(value = "/selectArticleList", method = RequestMethod.GET)
	public String selectArticleList(Model model
			, @RequestParam(value="currentPage", defaultValue="1") int currentPage
			, @RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		Map<String, Object> map = articleService.selectArticleList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("blockStart", map.get("blockStart"));
		model.addAttribute("blockEnd", map.get("blockEnd"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "article/selectArticleList";
	}
	/*insertArticle 매핑
	get방식으로 입력창을 foward하고
	post방식으로 articleRequest로 입력값을 받아 service에 insert를 호출한 후 redirect한다.*/
	@RequestMapping(value = "/insertArticle", method = RequestMethod.GET)
	public String insertArticle() {
		return "article/insertArticle";
	}
	
	@RequestMapping(value = "/insertArticle", method = RequestMethod.POST)
	public String insertArticle(ArticleRequest articleRequest) {
		articleService.insertArticle(articleRequest);
		return "redirect:/";
	}
}
