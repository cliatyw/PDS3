/*[김기성]*/
package com.test.pds.article.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/*입력할 때 필요한 요소들만 만든 class*/
public class ArticleRequest {
	
	private String articleTitle;
	private String articleContent;
	private List<MultipartFile> multipartFile;
	
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	@Override
	public String toString() {
		return "ArticleRequest [articleTitle=" + articleTitle + ", articleContent=" + articleContent
				+ ", multipartFile=" + multipartFile + "]";
	}
}
