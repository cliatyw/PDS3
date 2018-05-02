<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>selectBoardList.jsp</title>
</head>
<body>
	<h1>selectBoardList</h1>
	<a href="${pageContext.request.contextPath}/insertBoard"><button type="button" class="btn btn-primary">등록</button></a><br><br>
</a>
	<table class="table table-striped">
      <thead>
        <tr>
          <th>BoardId</th>
          <th>BoardContent</th>
        </tr>
      </thead>
      <c:forEach var="board" items="${list}">
      <tbody>
        <tr>
          <td>${board.boardId}</td>
          <td><a href="${pageContext.request.contextPath}/selectBoardDetail?boardId=${board.boardId}">${board.boardTitle}</a></td>
        </tr>
      </tbody>
      </c:forEach>
    </table>
</body>
</html>
