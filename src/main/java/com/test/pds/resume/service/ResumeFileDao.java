/*[김도희]*/
package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeFileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.notice.service.ResumeFileMapper.";
	
	/*ResumeFile 입력*/
	public int insertResumeFile(ResumeFile resumeFile) {
		int row = sqlSession.insert(NS+"insertResumeFile", resumeFile);
		return row;
	}
	
}
