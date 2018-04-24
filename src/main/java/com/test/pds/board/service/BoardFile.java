package com.test.pds.board.service;

public class BoardFile {
	private int boardFileId;
	private String boardFileName;
	private String boardFileExt;
	private String boardFileType;
	private int boardFileSize;
	private int board_id; //외래키
	
	public int getBoardFileId() {
		return boardFileId;
	}
	public void setBoardFileId(int boardFileId) {
		this.boardFileId = boardFileId;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFileExt() {
		return boardFileExt;
	}
	public void setBoardFileExt(String boardFileExt) {
		this.boardFileExt = boardFileExt;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}
	public int getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(int boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	@Override
	public String toString() {
		return "BoardFile [boardFileId=" + boardFileId + ", boardFileName=" + boardFileName + ", boardFileExt="
				+ boardFileExt + ", boardFileType=" + boardFileType + ", boardFileSize=" + boardFileSize + ", board_id="
				+ board_id + "]";
	}
}
