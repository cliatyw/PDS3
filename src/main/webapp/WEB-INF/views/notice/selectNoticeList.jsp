<!-- [최상욱] -->
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
				<th>noticeleId</th>
				<th>noticeTitle</th>
				<th>noticeContent</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${list}">
				<tr>
					<td>${notice.noticeId}</td>
					<td>${notice.noticeTitle}</td>
					<td>${notice.noticeContent}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>