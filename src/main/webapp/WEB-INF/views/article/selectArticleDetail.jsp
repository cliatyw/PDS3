<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectArticleOne</title>
</head>
<body>
	<h1>selectArticleList</h1>
	<div>번호 : ${article.articleId}</div>
	<div>제목 : ${article.articleTitle}</div>
	<div>내용 : ${article.articleContent}</div>
	<table>
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
</body>
</html>