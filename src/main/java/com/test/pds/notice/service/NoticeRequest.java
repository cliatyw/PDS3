package com.test.pds.notice.service;

import org.springframework.web.multipart.MultipartFile;

public class NoticeRequest {
	private String noticeTitle;
	private String noticeContent;
	private MultipartFile MultipartFile;
	
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
	public MultipartFile getMultipartFile() {
		return MultipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		MultipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "NoticeRequest [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", MultipartFile="
				+ MultipartFile + "]";
	}

}
