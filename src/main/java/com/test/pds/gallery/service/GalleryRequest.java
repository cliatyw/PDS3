package com.test.pds.gallery.service;

import org.springframework.web.multipart.MultipartFile;

public class GalleryRequest {
	private String galleryTitle;
	private String galleryContent;
	private MultipartFile multipartFile;
	public String getGalleryTitle() {
		
		return galleryTitle;
	}
	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}
	public String getGalleryContent() {
		return galleryContent;
	}
	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
}
