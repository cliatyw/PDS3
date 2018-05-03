/*[김도희]*/
package com.test.pds.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.test.pds.BoardController;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.board.service.BoardMapper.";
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*Board 입력*/
	public int insertBoard(Board board) {
		sqlSession.insert(NS+"insertBoard", board);
		return board.getBoardId();
	}
	
	/*BoardList 검색(Board의 Id,title)*/
	public List<Board> selectBoardList() {
		logger.debug("==========BoardDao.selectBoardList===========");
		return sqlSession.selectList(NS+"selectBoardList");
	}
	
	/*where절이 들어감으로써 하나의 id에 여러개의 파일이므로 List가 아닌 Board타입으로 받는다
	boardId를 매개변수로 받아 게시판 상세보기(Board의 content와 BoardFile의 boardFileName,boardFileExt) 검색*/
	public Board selectBoardDetail(int boardId){
		logger.debug("==========BoardDao.selectBoardDetail===========");	
		Board board = sqlSession.selectOne(NS+"selectBoardDetail", boardId);
		logger.debug("BoardDetail - board : "+board);
		return board;
	}
	
	/*boardId를 매개변수로 받아  Board(boardId,boardTitle,boardContent)삭제*/
	public int deleteBoard(int boardId) {
		logger.debug("============BoardDao.deleteBoard==============");
		int row = sqlSession.delete(NS+"deleteBoard", boardId);
		return row;
	}
	
}
