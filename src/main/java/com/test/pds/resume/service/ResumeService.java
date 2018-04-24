/*[김도희]*/
package com.test.pds.resume.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.BoardController;
import com.test.pds.SystemPath;

@Service
@Transactional
public class ResumeService {
	
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeFileDao resumeFileDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/*Resume,resumeFile입력*/
	public void insertResume(ResumeRequest resumeRequest) {

		logger.debug("===ResumeService.insertResume 실행===");
		Resume resume = new Resume();
		logger.debug("resumeTitle : "+resumeRequest.getResumeTitle());
		logger.info("resumeContent : "+resumeRequest.getResumeContent());
		resume.setResumeTitle(resumeRequest.getResumeTitle());
		resume.setResumeContent(resumeRequest.getResumeContent());
		
		 /*Resume(resumeTitle,resumeContent) 입력후 resumeId를 리턴받는다*/
		int resumeId = resumeDao.insertResume(resume);
	
		/*multipartFile 파일이름, 확장자, 컨텐트 타입, 사이즈, (절대경로를 이용한)파일저장*/		
		MultipartFile multipartFile = resumeRequest.getMultipartFile();
		logger.debug("multipartFile : "+resumeRequest.getMultipartFile());
		
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename.replace("-", "");
		
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		
		String fileType = multipartFile.getContentType();
		
		long fileSize = multipartFile.getSize();
		int newFileSize = (int)fileSize;
		
		File file = new File(SystemPath.UPLOAD_PATH+filename+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*multipartFile -> resumeFile*/
		ResumeFile resumeFile = new ResumeFile();
		resumeFile.setResumeFileName(filename.replace("-", ""));
		resumeFile.setResumeFileExt(fileExt);
		resumeFile.setResumeFileSize(newFileSize);
		resumeFile.setResumeFileType(fileType);
		resumeFile.setResumeId(resumeId);

		/*resumeFile 입력*/
		resumeFileDao.insertResumeFile(resumeFile);
	}		
}
