/*[김도희]*/
package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.BoardController;

@Repository
public class BoardFileDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.board.service.BoardFileMapper.";
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*BoardFile 입력*/
	public int insertBoardFile(BoardFile boardFile) {
		logger.debug("====BoardFileDao.insertBoardFile 실행====");
		logger.debug("boardFile : "+boardFile);
		int row = sqlSession.insert(NS+"insertBoardFile", boardFile);	
		return row;
	}
}
