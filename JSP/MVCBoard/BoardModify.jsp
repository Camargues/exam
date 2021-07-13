<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcboard.model.*,mvcboard.command.*" %>


<%
int result = 0;
Object oj = request.getAttribute("result");

if(oj != null){
	result = Integer.parseInt(oj.toString());
}

String seq = request.getParameter("seq");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글수정</title>
</head>
<body>

<%  // 게시글 수정이 성공적으로 되었다면 그 해당 게시글을 보여주는 페이지로 이동하고
    // 그렇지 않다면, "암호가 잘못 입력되었습니다"를 출력
	if(result != 0) {
		response.sendRedirect("/MVCBoard/BoardControl?cmd=view&seq=" + seq);
	}
	else{%>
	암호가 잘못 입력되었습니다
	<br>
	<button type="button" onclick="location.href='/MVCBoard/BoardControl?cmd=modify&seq=<%=seq %>'">돌아가기</button>
	<button type="button" onclick="location.href='/MVCBoard/BoardControl?cmd=list'">목록</button>
	<%}
%>

</body>
</html>