<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>selectBoardDetail.jsp</title>
</head>
<body>
	<h1>selectBoardDetail</h1>
	<table class="table table-striped">
      <thead>
        <tr>
          <th>BoardId</th>
          <th>BoardTitle</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>2</td>
        </tr>
      </tbody>
    </table>
	<c:forEach var="board" items="${list}">
	<a href="${pageContext.request.contextPath}/deleteBoard?boardId=${board.boardId}">삭제</button></a>	
	<div>boardContent  <textarea class="form-control" placeholder="${board.boardContent}" name="boardContent" readonly></textarea></div>	
	<c:forEach var="boardFile" items="${board.boardFile}"><br>
	<a href="/pds/resources/upload/${boardFile.boardFileName}.${boardFile.boardFileExt}" download target="_blank""><button type="button" class="btn btn-default">파일 다운로드</button></a><br>
	</c:forEach>	
	</c:forEach> 	
</body>
</html>