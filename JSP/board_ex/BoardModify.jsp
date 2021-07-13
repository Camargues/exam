<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board_ex.model.*,board_ex.service.*" %>

<%
	// 0. 넘겨받는 데이타의 한글 처리
	 request.setCharacterEncoding("utf-8");
	 
%>

<!-- 1. 이전 화면의 입력값을 넘겨받아 BoardRec 객체의 각 멤버변수로 지정 -->
<jsp:useBean id="vo" class="board_ex.model.BoardVO">
	<jsp:setProperty name="vo" property="*"/>
	</jsp:useBean>

<%
	// 2. Service에 update() 호출하여 레코드 수정
	ModifyArticleService service = ModifyArticleService.getInstance();
	int result = service.update(vo);
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
	if (result == 1){
		response.sendRedirect("BoardView.jsp?seq=" + vo.getSeq());
	}
	else{%>
	암호가 잘못 입력되었습니다
	<br>
	<button type="button" onclick="location.href='BoardModifyForm.jsp?seq=<%=vo.getSeq() %>'">돌아가기</button>
	<button type="button" onclick="location.href='BoardList.jsp'">목록</button>
	<%}
%>

</body>
</html>