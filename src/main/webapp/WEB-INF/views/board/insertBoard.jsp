<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insertBoard.jsp</title>
	<script>
		/* 파일추가 */
		$(document).ready(function(){
			$('#btn').click(function(){
				$("p").after('<input type="file" name="multipartFile" accept="image/*" id="file">');
			});
		});
	</script>
</head>
<body>
	<h1>insertBoard</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertBoard" method="post">
		<div>boardTitle  <input type="text" name="boardTitle" class="form-control" placeholder="boardTitle"></div>
		<div>boardContent  <textarea class="form-control" placeholder="boardContent" name="boardContent"></textarea></div>
		<div>boardFile :
		<div><p></p></div>
		<div><input type="button" id="btn" value="파일추가" class="btn btn-default btn-lg active"></div>
		<div><center><input type="submit" value="확인" class="btn btn-primary btn-lg" ></center></div>
		</div>
	</form>
</body>
</html>
