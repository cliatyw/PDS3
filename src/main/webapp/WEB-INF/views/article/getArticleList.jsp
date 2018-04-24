<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getArticleList</title>
</head>
<body>
	<h1>getArticleList</h1>
	<table>
		<thead>
			<tr>
				<th>articleId</th>
				<th>articleTitle</th>
				<th>articleContent</th>
				<th>articleFile</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td>${article.articleId}</td>
					<td>${article.articleTitle}</td>
					<td>${article.articleContent}</td>
					<td><a href="${path}/${article.articleFile.articleFileName}.${article.articleFile.articleFileExt}" download target="_blank">${article.articleFile.articleFileName}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>