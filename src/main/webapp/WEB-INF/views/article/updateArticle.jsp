<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertArticle</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		/* 삭제를 클릭할 때 tr을 삭제하고 파일을 삭제하기 위해서
		그 해당하는 행의 id값을 hidden 으로 저장한다. */
		$('.trDelete').click(function(){
			var id = $(this).parent('tr').find('td:eq(0)').text();
			$(this).parent('tr').remove();
			$('#formDiv').append('<input type="hidden" name="articleFileId" value="'+id+'">');
		});
		/* 파일이 없을때 file table을 삭제한다. */
		if($('#table').find('td:eq(0)').text() == 0){
			$('#table').remove();
		}
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
		$('#updateArticle').click(function(){
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
				$('#updateArticleForm').submit();
			}
		});
	});
</script>
</head>
<body>
	<h1>insertArticle</h1>
	<form id="updateArticleForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/updateArticle" method="post">
		<div class="modal-body" id="formDiv">
			<input type="hidden" name="articleId" value="${article.articleId}">
			<table class="table">
				<tr>
					<td>articleTitle</td>
					<td><input type="text" class="form-control" id="articleTitle" name="articleTitle" value="${article.articleTitle}"></td>
				</tr>
				<tr>
					<td>articleContent</td>
					<td><textarea class="form-control" id="articleContent" name="articleContent">${article.articleContent}</textarea></td>
				</tr>
			</table>
			<table class="table" id="table">
				<thead>
					<tr>
						<th>articleFileId</th>
						<th>articleFileName</th>
						<th>articleFileExt</th>
						<th>articleFileType</th>
						<th>articleFileSize</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="articleFile" items="${article.articleFile}">
						<tr>
							<td>${articleFile.articleFileId}</td>
							<td>${articleFile.articleFileName}</td>
							<td>${articleFile.articleFileExt}</td>
							<td>${articleFile.articleFileType}</td>
							<td>${articleFile.articleFileSize}</td>
							<td class="trDelete">삭제</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>articleFile : <button type="button" class="btn btn-outline-info" id="insertBtn">파일 추가</button></div>
		<div class="modal-body" id="file"></div>
		<input type="button" class="btn btn-success" id="updateArticle" value="수정">
		<button type="button" class="btn btn-defalt" onclick="location.href='${pageContext.request.contextPath}/selectArticleDetail?articleId=${article.articleId}'">취소</button>
	</form>
</body>
</html>