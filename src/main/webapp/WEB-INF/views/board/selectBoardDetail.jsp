<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>selectBoardDetail.jsp</title>
</head>
<body>
	<h1>selectBoardDetail</h1>
	board Content
	<c:forEach var="board" items="${list}">
		${board.boardContent}<br>
	파일
		${board.boardFile}
	</c:forEach>
		
</body>
</html>