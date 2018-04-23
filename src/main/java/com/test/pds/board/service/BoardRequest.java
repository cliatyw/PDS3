package com.test.pds.board.service;

import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {
	private String boardTitle;
	private String boardContent;
	private MultipartFile MultipartFile;
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
	public MultipartFile getMultipartFile() {
		return MultipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		MultipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "BoardRequest [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", MultipartFile="
				+ MultipartFile + "]";
	}
	


}
