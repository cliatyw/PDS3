<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertArticle</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script>
	/* 파일 추가 버튼을 누르면 input, 삭제 버튼을 생성하고
	삭제 버튼을 누르면 해당하는 div를 삭제한다. */
	$(document).ready(function(){
		$("#insertBtn").click(function(){
			$(this).parents('form').find("#file").append('<div><input type="file" id="multipartFile" name="multipartFile"><button type="button" class="deleteBtn">파일 삭제</button></div>');
			$(".deleteBtn").click(function(){
				$(this).parent('div').remove();
			});
		});
	});
</script>
</head>
<body>
	<h1>insertArticle</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertArticle" method="post">
		<div>articleTitle : <input type="text" name="articleTitle"></div>
		<div>articleContent : <input type="text" name="articleContent"></div>
		<div>articleFile : <button type="button" id="insertBtn">파일 추가</button></div>
		<div id="file">
			<div><input type="file" id="multipartFile" name="multipartFile"></div>
		</div>
		<button type="submit">입력</button>
	</form>
</body>
</html>