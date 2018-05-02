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
	$('#list').click(function(){
		location.href = "${pageContext.request.contextPath}/selectNoticeList";
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>addNotice</h1>
	<TABLE border='0' width='600' cellpadding='0' cellspacing='0'>
		<TR>
			<TD><hr size='1' noshade>
			</TD>
	 	</TR>
	</TABLE>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/insertNotice" method="post" id="form">
		<TABLE border='0' width='600' cellpadding='2' cellspacing='2'>
			<TR>
				<TD width='150' bgcolor='cccccc'>
					<font size='2'><center><b>제목</b></center></font>
				</TD>
				<TD>
					<font size='2'>
					<input type="text" size='70' maxlength='50' name="noticeTitle" id="noticeTitle"></font>
				</TD>
			</TR>
			<TR>
				<TD width='150' bgcolor='cccccc'>
					<font size='2'><center><b>내용</b></center></font>
				</TD>
				<TD>
	       			<font size='2'><textarea wrap='hard' cols='70' rows='15' name="noticeContent" id="noticeContent"></textarea></font>
	      		</TD>
			</TR>
			<TR>
		      		<TD colspan='2'><hr size='1' noshade></TD>

			</TR>
			<TR>

				<TD align='center' colspan='2' width='100%'>
				<div align='left' id="upload"></div>
				<div align='left' ><input type="button" value="파일첨부" id="fileAdd"></div>
				<div align='left' ><input id="remove" type="button" value="파일제거"></div>
				<TABLE>
					<TR>
						<TD width='100' align='center'><input Type = 'Reset' Value = '다시 작성'></TD>
						<TD width='200' align='center'><input Type = 'button' Value = '등록' id="btn"></TD>
						<TD width='200' align='center'><input Type = 'button' Value = '목록' id='list'></TD>
					</TR>
				</TABLE>
				</TD>
			</TR>
		</TABLE>
		<!-- <div>noticeTitle : <input type="text" name="noticeTitle" id="noticeTitle"></div>
		<div>noticeContent : <textarea name="noticeContent" id="noticeContent"></textarea></div>
		
		
		<div><input type="button" id="btn" value="입력"></div> -->
	</form>
</body>
</html>