<!-- [김도희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insertResume.jsp</title>
	<!-- 파일확장자 검사 -->
	<script>
		$(document).ready(function(){
			$('#btn').click(function(){
				 if($("#file").val()!=""){
					var ext = $('#file').val().split('.').pop().toLowerCase();
					if($.inArray(ext,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg'])==-1){
						alert('이미지 파일만 업로드 할수 있습니다.');
					 } else {
						 $(this).parents('span').find('#form').submit();
					 } 
				 } 
			});
		});
	</script>
</head>
<body>
	<h1>insertResume</h1>
	<span>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertResume" method="post" id="form">
		<div>resumeTitle : <input type="text" name="resumeTitle" class="form-control" placeholder="resumeTitle"></div>
		<div>resumeContent : <textarea name="resumeContent" class="form-control" placeholder="resumeContent"></textarea></div>
		<div>resumeFile : <input type="file" name="multipartFile" accept="image/*" id="file"></div>
		<div><input type="button" value="확인" id='btn' class="btn btn-primary btn-lg btn-block"></div>
	</form>
	</span>
</body>
</html>