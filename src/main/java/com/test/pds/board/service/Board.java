/*[김도희]*/
package com.test.pds.board.service;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	/*BoardFile의 값들을 List타입의 boardFile에 넣어줌으로써 1:N(List)*/
	private List<BoardFile> boardFile;
	
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
	public List<BoardFile> getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(List<BoardFile> boardFile) {
		this.boardFile = boardFile;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardFile=" + boardFile + "]";
	}
}
