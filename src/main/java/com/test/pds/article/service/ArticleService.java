package com.test.pds.article.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;

@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ArticleFileDao articleFileDao;

	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	public List<Article> selectArticleList() {
		return articleDao.selectArticle();
	}
	/*
	 * articleRequest를 매개변수로 받아 article에 셋팅하고, multipartFile을 얻어 대입하여 속성들을 얻은 후 Dao를
	 * 호출한다.
	 */
	public void insertArticle(ArticleRequest articleRequest) {
		/*
		 * article title, content 셋팅
		 */
		logger.debug("ArticleService.insertArticle.articleRequest : "+articleRequest.toString());
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
		/*
		 * article을 insert하고 난후 id값을 리턴받아 fileId에 대입한다.
		 */
		int fileId = articleDao.insertArticle(article);

		List<MultipartFile> multipartFile = articleRequest.getMultipartFile();
		logger.debug("ArticleService.insertArticle.multipartFile : "+multipartFile);
		/*
		 * 파일이 없다면 반복문을 실행하지 않는다. 파일이 한개도 없을시 오류가 발생하는데 이것을 방지 하기 위한 if문
		 */
		if (multipartFile != null) {
			/*
			 * 여러개의 파일을 업로드 할 때 반복문을 활용하여 Dao를 반복해서 호출한다.
			 */
			for (MultipartFile list : multipartFile) {
				/*
				 * uuid활용하여 랜덤이름 생성 후 fileName에 대입
				 */
				ArticleFile articleFile = new ArticleFile();
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString();
				fileName = fileName.replace("-", "");
				/*
				 * ext, type, size 대입
				 */
				int dotIndex = list.getOriginalFilename().lastIndexOf(".");
				String fileExt = list.getOriginalFilename().substring(dotIndex + 1);

				String fileType = list.getContentType();
				logger.debug("ArticleService.insertArticle.multipartFile.fileType : "+fileType);
				long fileSize = list.getSize();
				/*
				 * 고정위치에 파일을 생성하여, 업로드 받은 파일을 그위치에 놓는다.
				 */
				File file = new File(SystemPath.UPLOAD_PATH + fileName + "." + fileExt);
				try {
					list.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				/*
				 * 지금까지 file정보를 articleFile에 셋팅하고 Dao에 insert를 실행시킨다.
				 */
				articleFile.setArticleId(fileId);
				articleFile.setArticleFileName(fileName);
				articleFile.setArticleFileExt(fileExt);
				articleFile.setArticleFileType(fileType);
				articleFile.setArticleFileSize((int) fileSize);
				/*
				 * 트랜잭션이 잘되나 확인용 if (true) { throw new RuntimeException(); }
				 */
				articleFileDao.insertArticleFile(articleFile);
			}
		}
	}
}
