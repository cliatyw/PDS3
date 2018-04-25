<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/insertArticle">Article</a>
<a href="${pageContext.request.contextPath}/insertBoard">Board</a>
<a href="${pageContext.request.contextPath}/insertGallery">Gallery</a>
<a href="${pageContext.request.contextPath}/insertNotice">Notice</a>
<a href="${pageContext.request.contextPath}/insertResume">Resume</a>
</body>
</html>
