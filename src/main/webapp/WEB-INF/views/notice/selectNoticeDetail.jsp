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
		<c:forEach var="noticeFile" items="${notice.noticeFile}">
			<a href="/pds/resources/upload/${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}" download target="_blank"">${noticeFile.noticeFileName}.${noticeFile.noticeFileExt}</a><br>
		</c:forEach>
</body>
</html>