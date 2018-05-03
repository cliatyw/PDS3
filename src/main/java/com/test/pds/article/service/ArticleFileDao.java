/*[김기성]*/
package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFileDao.class);
	
	final String NS = "com.test.pds.article.service.ArticleFileMapper.";
	
	public ArticleFile selectArticleFileOne(int articleFileId) {
		return sqlSession.selectOne(NS+"selectArticleFileOne", articleFileId);
	}
	/*수정을 위해 articleFileId을 매개변수로 받아 해당하는 파일 한개만 삭제하고 갯수를 row로 리턴받는 매서드*/
	public int deleteArticleFileOne(int articleFileId) {
		int row = sqlSession.delete(NS+"deleteArticleFileOne", articleFileId);
		return row;
	}
	/*articleId를 매개변수로 받아 해당하는 articleFile을 삭제하고 갯수를 리턴받는 매서드*/
	public int deleteArticleFile(int articleId) {
		int row = sqlSession.delete(NS+"deleteArticleFile", articleId);
		return row;
	}
	/*articleFile을 매개변수로 받아 insert시킨후 row를 리턴*/
	public int insertArticleFile(ArticleFile articleFile) {
		int row = sqlSession.insert(NS+"insertArticleFile", articleFile);
		return row;
	}
}
