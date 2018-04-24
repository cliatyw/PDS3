package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 

 
@Repository 
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.notice.service.NoticeMapper.";
	
	public int insertNotice(Notice notice) {
		sqlSession.insert(NS+"insertNotice", notice);
		return notice.getNoticeId();
	}
	public int addNoticeFile(NoticeFile noticeFile) {
		return sqlSession.insert(NS+"addNoticeFile", noticeFile);
	}
}
