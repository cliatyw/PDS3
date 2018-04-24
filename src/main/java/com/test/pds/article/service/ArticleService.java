package com.test.pds.article.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	public List<Article> getArticleList() {
		return articleDao.selectArticle();
	}
	
	public void addArticle(ArticleRequest articleRequest, String path) {
		MultipartFile multipartFile = articleRequest.getMultipartFile();
		
		/*
		 * article title, content 셋팅
		 */
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
		
		/*
		 * uuid활용하여 랜덤이름 생성 후 fileName에 대입
		 */
		ArticleFile articleFile = new ArticleFile();
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString();
		fileName = fileName.replace("-", "");
		
		/*
		 * ext, type, size 대입
		 */
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		
		String fileType = multipartFile.getContentType();
		
		long fileSize = multipartFile.getSize();
		
		File file = new File("C:\\Users\\Administrator\\git\\PDS\\PDS\\src\\main\\resources\\upload"+"\\"+fileName+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		articleFile.setArticleId(articleDao.insertArticle(article));
		articleFile.setArticleFileName(fileName);
		articleFile.setArticleFileExt(fileExt);
		articleFile.setArticleFileType(fileType);
		articleFile.setArticleFileSize((int) fileSize);
		
		articleDao.insertArticleFile(articleFile);
	}
}
