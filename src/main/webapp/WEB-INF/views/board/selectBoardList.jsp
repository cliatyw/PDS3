<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>selectBoardList.jsp</title>
</head>
<body>
	<h1>selectBoardList</h1>
	<table border="1">
		<thead>
			<th>아이디</th>
			<th>제목</th>
		</thead>
		<c:forEach var="board" items="${list}">
		<tbody>
			<td>${board.boardId}</td>
			<td><a href="${pageContext.request.contextPath}/selectBoardDetail?boardId=${board.boardId}">${board.boardTitle}</a></td>
		</tbody>
		</c:forEach>
	</table>	
</body>
</html>