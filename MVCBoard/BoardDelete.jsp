<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcboard.model.*,mvcboard.command.*" %>
<%
int result = 0;
Object oj = request.getAttribute("result");

if(oj != null){
	result = Integer.parseInt(oj.toString());
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 게시글 삭제 </title>
</head>
<body>

	<% if(result != 0) { %>
			글을 삭제하였습니다.
	
	<% } else { %>
			삭제가 실패되었습니다.
			
	<% } %>
	<br/><br/>
	<button type="button" onclick="location.href='/MVCBoard/BoardControl?cmd=list'">목록</button>
</body>
</html>