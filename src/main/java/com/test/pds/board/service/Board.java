package com.test.pds.board.service;

import java.util.List;

public class Board {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private BoardFile boardFile; // 1:n 바꾸기
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public BoardFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(BoardFile boardFile) {
		this.boardFile = boardFile;
	}
	
}
