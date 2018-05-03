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
		logger.debug("=========== BoardFileDao.insertBoardFile ===============");
		logger.debug("boardFile : "+boardFile);
		int row = sqlSession.insert(NS+"insertBoardFile", boardFile);	
		return row;
	}
	
	/*boardId를 매개변수로 받아 BoardFile(fileId,fileName,boardId,fileExt,fileType,fileSize) 삭제*/
	public int deleteBoardFile(int boardId) {
		logger.debug("=============== BoardFileDao.deleteBoardFile ================");
		logger.debug("boardId : "+boardId);
		int row = sqlSession.delete(NS+"deleteBoardFile", boardId);
		return row;
	}
}
