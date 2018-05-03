<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectArticleDetail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		/* 파일이 없을때 file table을 삭제한다. */
		if($('#table').find('td:eq(0)').text() == 0){
			$('#table').remove();
		}
	});
</script>
</head>
<body>
	<h1>selectArticleList</h1>
	<table class="table">
		<tr>
			<td>번호</td>
			<td>${article.articleId}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${article.articleTitle}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${article.articleContent}</td>
		</tr>
	</table>
	<table id="table" class="table">
		<thead>
			<tr>
				<th>articleFileId</th>
				<th>articleFileName</th>
				<th>articleFileExt</th>
				<th>articleFileType</th>
				<th>articleFileSize</th>
				<th>download</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="articleFile" items="${article.articleFile}">
				<tr>
					<td>${articleFile.articleFileId}</td>
					<td>${articleFile.articleFileName}</td>
					<td>${articleFile.articleFileExt}</td>
					<td>${articleFile.articleFileType}</td>
					<td>${articleFile.articleFileSize}</td>
					<td><a href="/pds/resources/upload/${articleFile.articleFileName}.${articleFile.articleFileExt}" download target="_blank">download</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="button" class="btn btn-defalt" onclick="location.href='${pageContext.request.contextPath}/updateArticle?articleId=${article.articleId}'">수정</button>
	<button type="button" class="btn btn-defalt" onclick="location.href='${pageContext.request.contextPath}/deleteArticle?articleId=${article.articleId}'">삭제</button>
	<button type="button" class="btn btn-defalt" onclick="location.href='${pageContext.request.contextPath}/selectArticleList'">리스트로</button>
</body>
</html>