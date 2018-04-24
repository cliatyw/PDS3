package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.notice.service.ResumeMapper.";
	
	/*Resume 입력*/
	public void insertResume(Resume resume) {
	
	}
}
