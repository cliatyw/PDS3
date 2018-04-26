<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertArticle</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script>
	$(document).ready(function(){
		/* 파일 추가 버튼을 누르면 input, 삭제 버튼을 생성하고
		삭제 버튼을 누르면 해당하는 div를 삭제한다.
		파일 추가 버튼을 누를시 한개라도 파일이 없다면 false로 설정하고,
		true일때만 버튼을 생성한다. */
		$('#insertBtn').click(function(){
			var flag = true;
			$('.multipartFile').each(function(){
				/* console.log($(this).val()); */
				if($(this).val()==""){
					flag = false;
				}
			});
			if(flag) {
				$('#file').append('<div><input type="file" class="multipartFile" name="multipartFile"><button type="button" class="deleteBtn">파일 삭제</button></div>');
				$('.deleteBtn').click(function(){
					$(this).parent('div').remove();
				});
			}
		});
		/* 입력버튼을 누르면 title과 content의 내용이 있는지 검사하고
		파일이 없는 div는 삭제한 후 submit한다. */
		$('#insertArticle').click(function(){
			$('.multipartFile').each(function(){
				if($(this).val()==""){
					$(this).parent('div').remove();
				}
			});
			if($('#articleTitle').val()==""){
				alert("제목을 입력하시오.");
			}else if($('#articleContent').val()==""){
				alert("내용을 입력하시오.");
			}
			if($('#articleTitle').val()!=="" && $('#articleContent').val()!==""){
				$('#insertArticleForm').submit();
			}
		});
	});
</script>
</head>
<body>
	<h1>insertArticle</h1>
	<form id="insertArticleForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertArticle" method="post">
		<div>articleTitle : <input type="text" id="articleTitle" name="articleTitle"></div>
		<div>articleContent : <input type="text" id="articleContent" name="articleContent"></div>
		<div>articleFile : <button type="button" id="insertBtn">파일 추가</button></div>
		<div id="file"></div>
		<input type="button" id="insertArticle" value="입력">
	</form>
</body>
</html>