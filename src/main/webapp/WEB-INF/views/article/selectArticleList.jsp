<!-- [김기성] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selectArticleList</title>
</head>
<body>
	<h1>selectArticleList</h1>
	<form action="${pageContext.request.contextPath}/selectArticleList" method="get">
		<select name="pagePerRow">
			<option value="3">3개씩</option>
			<option value="5">5개씩</option>
			<option value="10">10개씩</option>
		</select>
		<button type="submit">보기</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>articleId</th>
				<th>articleTitle</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td>${article.articleId}</td>
					<td><a href="${pageContext.request.contextPath}/selectArticleDetail?articleId=${article.articleId}">${article.articleTitle}</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteArticle?articleId=${article.articleId}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/selectArticleList?currentPage=1&pagePerRow=${pagePerRow}">[처음으로]</a>
	</c:if>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/selectArticleList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">[이전]</a>
	</c:if>
	<c:forEach var="a" begin="${blockStart}" end="${blockEnd}">
		<a href="${pageContext.request.contextPath}/selectArticleList?currentPage=${a}&pagePerRow=${pagePerRow}">${a}</a>
	</c:forEach>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/selectArticleList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">[다음]</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="${pageContext.request.contextPath}/selectArticleList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">[끝으로]</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/">홈으로</a>
	<a href="${pageContext.request.contextPath}/insertArticle">등록</a>
</body>
</html>