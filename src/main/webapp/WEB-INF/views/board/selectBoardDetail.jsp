<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>selectBoardDetail.jsp</title>
	<script>
		$(document).ready(function(){
			$('#updateBtn').click(function(){
				/* boardtitl과 content 입력가능상태 */
				$('#title').removeAttr("readonly");
				$('#content').removeAttr("readonly");
				/* 수정버튼 화면에서 보이지않게 제거 */
				$('#updateBtn').remove();
				/* 파일삭제버튼 생성 */
				$('.deleteFile').after('<button type="button" id="fileDown">파일삭제</button>');
				/* 수정확인 버튼 생성 */
				$('#submit').after('<input type="submit" value="수정 확인"> ');
			});
			$('.updateFile').eq(0).click(function(){
				$('#a').remove();
				$('#fileDown').remove();
			});
		});
	</script>
</head>
<body>
	<h1>selectBoardDetail</h1>
	<!-- 부트스트랩 미완성 -->
	<!-- <table class="table table-striped">
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
    </table> -->
	<form action="${pageContext.request.contextPath}/updateBoard" method="post">
		<button type="button" id="updateBtn" class="btn btn-primary">수정</button>
		<a href="${pageContext.request.contextPath}/deleteBoard?boardId=${boardId}"><button type="button" class="btn btn-primary">삭제</button></a>
		<div>boardId - ${boardId}</div>
		<input type=hidden value="${boardId}" name="boardId">
		<div>boardTitle  <input type="text" id="title" name="boardTitle" class="form-control" placeholder="${boardTitle}" readonly></div>
		<div>boardContent  <textarea id="content" class="form-control" placeholder="${boardContent}" name="boardContent" readonly></textarea></div>	
		<h4>첨부파일</h4>
		<c:forEach var="boardFile" items="${boardFile}">
			<div class="updateFile">
				<a href="/pds/resources/upload/${boardFile.boardFileName}.${boardFile.boardFileExt}" download target="_blank" id="a"">
						<button type="button" class="btn btn-default" id="fileDown">${boardFile.boardFileName}.${boardFile.boardFileExt}
						</button>	
				</a><p class="deleteFile"></p>
				<%-- <input type=hidden value="${boardFile.boardFileName}" name="boardFileName">
				<input type=hidden value="${boardFile.boardFileExt}" name="boardFileExt"> --%>				
			</div>
		</c:forEach>
		<p id="file"></p>
		<div><p id="submit"></p></div>
	</form>	
</body>
</html>