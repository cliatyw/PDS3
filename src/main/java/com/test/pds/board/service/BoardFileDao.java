package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.board.service.BoardFileMapper.";
	
	/*BoardFile 입력*/
	public int insertBoardFile(BoardFile boardFile) {
		int row = sqlSession.insert(NS+"insertBoardFile", boardFile);	
		return row;
	}
}
