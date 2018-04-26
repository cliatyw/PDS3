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
				<th>galleryId</th>
				<th>galleryTitle</th>
				<th>galleryContent</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="gallery" items="${list}">
				<tr>
					<td>${gallery.galleryId}</td>
					<td>${gallery.galleryTitle}</td>
					<td>${gallery.galleryContent}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>