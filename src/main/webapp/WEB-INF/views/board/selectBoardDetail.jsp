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
	<c:forEach var="board" items="${list}">
	<a href="${pageContext.request.contextPath}/deleteBoard?boardId=${board.boardId}">삭제</a><br>
	[]board Content					
		${board.boardContent}<br>	
	<c:forEach var="boardFile" items="${board.boardFile}">		 
	파일	이름 ${boardFile.boardFileName} 
	파일확장명 ${boardFile.boardFileExt}<br>
	<a href="/pds/resources/upload/${boardFile.boardFileName}.${boardFile.boardFileExt}" download target="_blank""> 파일 다운로드</a><br>
	</c:forEach>	
	</c:forEach> 	
</body>
</html>