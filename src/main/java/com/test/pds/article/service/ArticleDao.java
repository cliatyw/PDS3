/*[김기성]*/
package com.test.pds.article.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);
	
	final String NS = "com.test.pds.article.service.ArticleMapper.";
	/*article을 매개변수로 받아 articleId에 해당하는 데이터를 업데이트하고 결과 갯수인 row를 리턴받는 매서드*/
	public int updateArticle(Article article) {
		int row = sqlSession.update(NS+"updateArticle", article);
		return row;
	}
	/*articleId를 매개변수로 받아 해당하는 article의 데이터를 삭제하고 갯수를 리턴받는 매서드*/
	public int deleteArticle(int articleId) {
		int row = sqlSession.delete(NS+"deleteArticle", articleId);
		return row;
	}
	/*articleId를 매개변수로 받아 해당하는 article의 정보를 가져오는 매서드*/
	public Article selectArticleDetail(int articleId) {
		return sqlSession.selectOne(NS+"selectArticleDetail", articleId);
	}
	/*article 전체 갯수를 세는 매서드*/
	public int totalCountArticle() {
		return sqlSession.selectOne(NS+"totalCountArticle");
	}
	/*map에 셋팅된 beginRow, pagePerRow를 가지고 article list를 가져와 리턴한다.*/
	public List<Article> selectArticleList(Map<String, Integer> map) {
		return sqlSession.selectList(NS+"selectArticleList", map);
	}
	/*article 매개변수로 받아 article 입력처리 후 id값을 리턴받는다.*/
	public int insertArticle(Article article) {
		sqlSession.insert(NS+"insertArticle", article);
		return article.getArticleId();
	}
}
