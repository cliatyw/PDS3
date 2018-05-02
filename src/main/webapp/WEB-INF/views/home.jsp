<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>팀원</th>
				<th>역할</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>김기성</td>
				<td><a href="${pageContext.request.contextPath}/selectArticleList">Article</a></td>
			</tr>
			<tr>
				<td>김도희</td>
				<td><a href="${pageContext.request.contextPath}/selectResumeList">Resume</a></td>
			</tr>
			<tr>
				<td>김도희</td>
				<td><a href="${pageContext.request.contextPath}/selectBoardList">Board</a></td>
			</tr>
			<tr>
				<td>최상욱</td>
				<td><a href="${pageContext.request.contextPath}/selectGalleryList">Gallery</a></td>
			</tr>
			<tr>
				<td>최상욱</td>
				<td><a href="${pageContext.request.contextPath}/selectNoticeList">Notice</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
