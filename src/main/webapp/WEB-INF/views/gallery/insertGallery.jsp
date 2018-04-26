<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	/* add버튼 클릭시 <input type="file"> 추가 */
	$('#fileAdd').click(function(){
		if($('.multipartFile').length < 5) {
			$('#upload').append('<div><input class="multipartFile" type="file" id="multipartFile" name="multipartFile" accept="image/*" multiple="multiple"/;></div>')
		} else {
			alert('5개 이상 지정안됨');
		}
	});
	/* remove버튼 클릭시 마지막 <input type="file"> 삭제 */
	$('#remove').click(function(){ 
		$('#upload').children().last().remove();
	});
	/*  btn 버턴 클릭시 폼유효성 검사후 submit */
	$('#btn').click(function(){
		if($('#galleryTitle').val().length < 1) {
			alert('title을 입력하세요');
		}else if($('#galleryContent').val().length < 1){
			alert('내용을 입력하세요');
		} else if ($('.multipartFile').length == 0) {
			alert('한개이상의 파일을 업로드');
		} else {
			var flag = false;
			$('.multipartFile').each(function(index, item){
				if($(this).val().length <1) {
					flag = true;
					if(flag) {
						alert('파일을 선택하세요');
						return;
					}
				}
			});
			/* 이미지 파일만 업로드 */
			for(var i=0; i < $('.multipartFile').length; i++){
				var ext = $('.multipartFile:eq('+i+')').val().split('.').pop().toLowerCase();
				if($.inArray(ext,['xwd','xpm','xbm','rgb','ppm','pgm','pbm','pnm','ras','tif','tiff','ief','gif','jpg','jpeg'])==-1){
					alert('이미지 파일만 선택하세요');
					return;
				}
			}
			alert('submit 실행...');
			$('form').submit();
		}
	});
});
</script>
<title>insertGallery.jsp</title>
</head>
<body>
	<h1>addGallery</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertGallery" method="post" id="form">
		<div>galleryTitle : <input type="text" name="galleryTitle" id="galleryTitle"></div>
		<div>galleryContent : <textarea name="galleryContent" id="galleryContent"></textarea></div>
		<div id="upload"></div>
		<div>galleryFile : <input type="button" value="fileAdd" id="fileAdd"></div>
		<input id="remove" type="button" value="remove">
		<div><input type="button" id="btn" value="입력"></div>
	</form>
</body>
</html>