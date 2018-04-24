<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume.jsp</title>
</head>
<body>
	<h1>addResume</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/addResume" method="post">
		<div>resumeTitle : <input type="text" name="resumeTitle"></div>
		<div>resumeContent : <textarea name="resumeContent"></textarea></div>
		<div>resumeFile : <input type="file" name="multipartFile"></div>
		<div><input type="submit" value="확인"></div>
	</form>
</body>
</html>