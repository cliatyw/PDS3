package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 

 
@Repository 
public class GalleryDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.gallery.service.GalleryMapper.";
	
	public int insertGallery(Gallery gallery) {
		sqlSession.insert(NS+"insertGallery", gallery);
		return gallery.getGalleryId();
	}
	public List<Gallery> selectGalleryList(){ 
		return sqlSession.selectList(NS+"selectGalleryList"); 
	} 

}
