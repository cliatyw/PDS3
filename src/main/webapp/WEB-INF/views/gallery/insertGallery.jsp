<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#btn').click(function(){
		 if($("#file").val()!=""){
			var ext = $('#file').val().split('.').pop().toLowerCase();
			if($.inArray(ext,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg'])==-1){
				alert('이미지 파일만 업로드 할수 있습니다.');
				return false;
			 } else {
				 $(this).parents('span').find('#form').submit();
			 } 
		 } 
	});
});
</script>
<title>insertGallery.jsp</title>
</head>
<body>
	<span>
		<h1>addGallery</h1>
		<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertGallery" method="post" id="form">
			<div>galleryTitle : <input type="text" name="galleryTitle"></div>
			<div>galleryContent : <textarea name="galleryContent"></textarea></div>
			<div>galleryFile : <input type="file" accept="image/*" name="multipartFile" id="file"></div>
			<div><input type="submit" id="btn"></div>
		</form>
	</span>
</body>
</html>