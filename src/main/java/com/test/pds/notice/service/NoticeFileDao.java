/*[최상욱]*/
package com.test.pds.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 

 
@Repository 
public class NoticeFileDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.notice.service.NoticeFileMapper.";

	public int insertNoticeFile(NoticeFile noticeFile) {
		int row = sqlSession.insert(NS+"insertNoticeFile", noticeFile);
		return row;
	}
	
	public Notice selectNoticeDetail(int noticeId){ 
		return sqlSession.selectOne(NS+"selectNoticeDetail", noticeId); 
	} 

}
