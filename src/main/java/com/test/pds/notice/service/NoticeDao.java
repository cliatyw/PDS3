/*[최상욱]*/
package com.test.pds.notice.service;

import java.util.List;

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
	public List<Notice> selectNoticeList(){ 
		return sqlSession.selectList(NS+"selectNoticeList"); 
	} 

}
