/*[최상욱]*/
package com.test.pds.notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NoticeRequest {
	private String noticeTitle;
	private String noticeContent;
	private List<MultipartFile> multipartFile;
	
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
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
}
