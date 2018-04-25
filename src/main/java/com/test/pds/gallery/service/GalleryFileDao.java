/*[최상욱]*/
package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 

 
@Repository 
public class GalleryFileDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.gallery.service.GalleryFileMapper.";

	public int insertGalleryFile(GalleryFile galleryFile) {
		int row = sqlSession.insert(NS+"insertGalleryFile", galleryFile);
		return row;
	}

}
