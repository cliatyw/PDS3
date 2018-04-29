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
	<h1>selectNoticeDetail.jsp</h1>
		${notice.noticeId}
		${notice.noticeContent}<br>
		<table border=1>
		<tr>
			<th>${notice.noticeId}</th>
			<th>${notice.noticeContent}</th>
			<th>fileid</th>
			<th>download</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="noticeFile" items="${notice.noticeFile}">
			<tr>
				<td>${notice.noticeId}</td>
				<td>${notice.noticeContent}</td>
				<td>${noticeFile.noticeFileId}</td>
				<td><a href="/pds/resources/upload/${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}" download target="_blank"">${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteNoticeFile?noticeFileId=${noticeFile.noticeFileId}&noticeId=${notice.noticeId}">삭제</a></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>