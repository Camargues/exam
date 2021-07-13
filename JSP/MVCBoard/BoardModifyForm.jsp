<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcboard.command.*,mvcboard.model.*" %>
<%
	// 1. 수정할 레코드의 게시글번호를 넘거받기
	String seq = request.getParameter("seq");
	// 2. Service에 getArticleById()함수를 호출하여 그 게시글번호의 레코드를 검색
BoardVO vo = (BoardVO)request.getAttribute("vo");

%>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정하기</title>
</head>
 <body>
	<h4> 게시판 글 수정하기 </h4><br/>
	<form name='frm' method='post' action="/MVCBoard/BoardControl?cmd=modify-do">
	<input type="hidden" name="seq" value="<%=seq %>">
	제  목 : <input type='text' name="title" value="<%=vo.getTitle()%>"><br/><br/>
	패스워드(수정/삭제시 필요) :
			<input type='password' name="pass"><br/><br/>
	내  용 : <textarea name='content' rows='10' cols='40' name="content"><%=vo.getContent()%></textarea><br/><br/>

	<input type='submit' value='수정'>
	<button type="button" onclick="location.href='/MVCBoard/BoardControl?cmd=list'">목록</button>
	</form>

</body>
</html>