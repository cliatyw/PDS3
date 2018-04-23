package com.test.pds.notice.service;

public class Notice {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private NoticeFile noticeFile; // 1:n 바꾸기
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public NoticeFile getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(NoticeFile noticeFile) {
		this.noticeFile = noticeFile;
	}

	
	
	
}
