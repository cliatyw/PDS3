package com.test.pds.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleService {
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
		
		File file = new File("d:/upload/"+fileName+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
