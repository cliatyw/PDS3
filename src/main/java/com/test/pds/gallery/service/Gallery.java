package com.test.pds.gallery.service;

public class Gallery {
	private int galleryId;
	private String galleryTitle;
	private String galleryContent;
	private GalleryFile galleryFile; // 1:n 바꾸기
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
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
	public GalleryFile getGalleryFile() {
		return galleryFile;
	}
	public void setGalleryFile(GalleryFile galleryFile) {
		this.galleryFile = galleryFile;
	}

	
}
