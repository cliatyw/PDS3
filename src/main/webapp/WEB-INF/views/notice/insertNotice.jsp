<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//add버튼 클릭시 <input type="file"> 추가
	$('#fileAdd').click(function(){
		if($('.multipartFile').length < 5) {
			$('#upload').append('<div><input class="multipartFile" type="file" id="multipartFile" name="multipartFile" multiple="multiple"/;></div>')
		} else {
			alert('5개 이상 지정안됨');
		}
	});
	//remove버튼 클릭시 마지막 <input type="file"> 삭제
	$('#remove').click(function(){ 
		$('#upload').children().last().remove();
	});
	// btn 버턴 클릭시 폼유효성 검사후 submit
	$('#btn').click(function(){
		if($('#noticeTitle').val().length < 1) {
			alert('title을 입력하세요');
		}else if($('#noticeContent').val().length < 1){
			alert('내용을 입력하세요');
		} else if ($('.multipartFile').length == 0) {
			alert('한개이상의 파일을 업로드');
		} else {
			 var flag = false;
			$('.multipartFile').each(function(index, item){
				if($(this).val().length <1) {
					flag = true;
				}
			});
			if(flag) {
				alert('파일을 선택하세요');
			} else {
				alert('submit 실행...');
				$('form').submit();
			}
		}
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>addNotice</h1>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertNotice" method="post" id="form">
		<div>noticeTitle : <input type="text" name="noticeTitle" id="noticeTitle"></div>
		<div>noticeContent : <textarea name="noticeContent" id="noticeContent"></textarea></div>
		<div id="upload"></div>
		<div>noticeFile : <input type="button" value="fileAdd" id="fileAdd"></div>
		<input id="remove" type="button" value="remove">
		<div><input type="button" id="btn" value="입력"></div>
	</form>
</body>
</html>