<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#fileAdd').click(function(){
		$('#fileSection').append('<div><input type="file" id="multipartFile" name="multipartFile" accept="image/*" multiple="multiple"/;></div>')
	});
	$('#btn').click(function(){
		if($("#multipartFile").val()!=""){
			var ext = $('#multipartFile').val().split('.').pop().toLowerCase();
			if($.inArray(ext,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg'])==-1){
				alert('이미지 파일만 업로드 할수 있습니다.');
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
			<div>galleryFile : <input type="button" value="fileAdd" id="fileAdd"></div>
			<div id="fileSection"></div>
			<div><input type="submit" id="btn"></div>
		</form>
	</span>
</body>
</html>