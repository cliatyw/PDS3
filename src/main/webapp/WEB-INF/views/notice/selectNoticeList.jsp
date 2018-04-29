<!-- [최상욱] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getArticleList</title>
</head>
<body>
	<h1>getNoticeList</h1>
	<TABLE border=0 width='600' cellpadding='0' cellspacing='0'>
		<TR>
			<TD><hr size='1' noshade>
			</TD>
	 	</TR>
	</TABLE>   
	<TABLE border=0 cellspacing=1 cellpadding=2 width='600'>
		<TR bgcolor='cccccc'>  
			<TD width='50'><font size=2><center><b>번호</b></center></font></TD>      
			<TD width='450'><font size=2><center><b>제목</b></center></font></TD>  
			<TD width='50'><font size=2><center><b>수정</b></center></font></TD>  
			<TD width='50'><font size=2><center><b>삭제</b></center></font></TD>  
		</TR>   
		<c:forEach var="notice" items="${list}">
			<TR bgcolor='ededed'>   
				<TD align=center><font size=2 color='black'>${notice.noticeId}</font></TD>  
				<TD align=center><font size=2 color="black"><a href="${pageContext.request.contextPath}/selectNoticeDetail?noticeId=${notice.noticeId}">${notice.noticeTitle}</a></font></TD>
				<TD align=center><font size=2 color="black"><a href="*">수정</a></font></TD>
				<TD align=center><font size=2 color="black"><a href="${pageContext.request.contextPath}/deleteNotice?noticeId=${notice.noticeId}">삭제</a></font></TD>
			</TR>
		</c:forEach>
	</table>
	<TABLE border=0 width='600'>
	<TR>
		<TD align=left><td align='left'><a href="${pageContext.request.contextPath}/">[메인]</a></td></TD>
		<TD align=right><td align='right'><a href="${pageContext.request.contextPath}/insertNotice">[등록]</a></td></TD>
	</TR>
</TABLE>         
</body>
</html>


