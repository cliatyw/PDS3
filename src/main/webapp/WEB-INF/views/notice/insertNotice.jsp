<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addNotice</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/selectNoticeList" method="post">
		<div>noticeTitle : <input type="text" name="noticeTitle"></div>
		<div>noticeContent : <textarea name="noticeContent"></textarea></div>
		<div>noticeFile : <input type="file" name="multipartFile"></div>
		<div><input type="submit"></div>
	</form>
</body>
</html>