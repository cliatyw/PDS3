package com.test.pds.article.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	public List<Article> getArticleList() {
		return articleDao.selectArticle();
	}
	
	public void addArticle(ArticleRequest articleRequest, String path) {
		MultipartFile multipartFile = articleRequest.getMultipartFile();
		
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
		
		ArticleFile articleFile = new ArticleFile();
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString();
		fileName = fileName.replace("-", "");
		
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		
		String fileType = multipartFile.getContentType();
		
		long fileSize = multipartFile.getSize();
		
		File file = new File(path+"\\"+fileName+"."+fileExt);
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
