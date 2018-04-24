<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insertBoard.jsp</title>
</head>
<body>
	<h1>insertBoard</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertBoard" method="post">
		<div>boardTitle : <input type="text" name="boardTitle"></div>
		<div>boardContent : <textarea name="boardContent"></textarea></div>
		<div>boardFile : <input type="file" name="multipartFile"></div>
		<div><input type="submit" value="확인"></div>
	</form>
</body>
</html>
