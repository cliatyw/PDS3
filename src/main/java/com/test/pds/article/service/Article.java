/*[김기성]*/
package com.test.pds.article.service;

import java.util.List;
/*article table*/
public class Article {
	private int articleId;
	private String articleTitle;
	private String articleContent;
	private List<ArticleFile> articleFile;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
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
	public List<ArticleFile> getArticleFile() {
		return articleFile;
	}
	public void setArticleFile(List<ArticleFile> articleFile) {
		this.articleFile = articleFile;
	}
	
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + ", articleFile=" + articleFile + "]";
	}
}
