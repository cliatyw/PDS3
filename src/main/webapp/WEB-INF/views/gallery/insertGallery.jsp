<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addGallery</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/selectGalleryList" method="post">
		<div>galleryTitle : <input type="text" name="galleryTitle"></div>
		<div>galleryContent : <textarea name="galleryContent"></textarea></div>
		<div>galleryFile : <input type="file" name="multipartFile"></div>
		<div><input type="submit"></div>
	</form>
</body>
</html>