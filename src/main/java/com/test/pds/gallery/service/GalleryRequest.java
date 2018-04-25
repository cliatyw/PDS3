/*[최상욱]*/
package com.test.pds.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GalleryRequest {
	private String galleryTitle;
	private String galleryContent;
	private List<MultipartFile> multipartFile;
	
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
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
}
