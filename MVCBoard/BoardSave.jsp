<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="mvcboard.model.*,mvcboard.command.*" %>

<%
	request.setCharacterEncoding("utf-8");
%>


<%

	//BoardSave.jsp에서 새로고침을 하게 되면 중복 입력되기에
	// 추후에 입력 후 BoardView.jsp?id=글번호 로 넘겨서 처리하고자
	
	response.sendRedirect("/MVCBoard/BoardControl?cmd=list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판글저장</title>
</head>
<body>
</body>
</html>