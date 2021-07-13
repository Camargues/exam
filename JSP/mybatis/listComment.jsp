<%@ page language="java" contentType="text/html; charset=utf-8" %>
 <%@ page import="java.util.*" %>
 <%@ page import="mybatis.guest.model.Comment" %>    
 <%@ page import="mybatis.guest.service.CommentService" %>  
  
  <!-- 서비스의 메소드 호출  -->
  <%
     //Map condition = new HashMap();

     String condition = request.getParameter("condition");
     String keyword = request.getParameter("keyword");
     
     HashMap map = new HashMap();
     map.put("condition", condition);
     // condition 이란 이름으로 파라메터 condition 값 입력
     map.put("keyword", keyword);
     
     List<Comment> mList = CommentService.getInstance().selectComment(map);
 %>
  
<!DOCTYPE HTML>
<html> 
<head>
	<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>

<a href="insertCommentForm.jsp">방명록 남기기 </a><br/><br/>

<!-- 조건 검색 -->
<form action="" method="get">
<select name="condition">
<option value='USER_ID'>작성자</option>
<option value='COMMENT_CONTENT'>내용</option>
</select>
<input type='text' name='keyword'>
<input type="submit" value='검색'>
</form>

<table border="1">
	<tr><td>글번호</td><td>작성자</td><td>등록일</td></tr>
	<% for( Comment comment : mList ) { %>
		<tr>
			<td><%= comment.getCommentNo() %></td>
			<td><a href="viewComment.jsp?cId=<%=comment.getCommentNo()%>"><%= comment.getUserId()%> 님이 쓴 글</a></td>
			<td><%= comment.getRegDate()%></td>
		</tr>
	<% } %>
</table>
</body>
</html>