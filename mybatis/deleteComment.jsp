<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>   
 <%@ page import="mybatis.guest.service.CommentService" %>   
  
      
  <!-- 키에 해당하는 글번호를 넘겨받아 서비스의 메소드 호출  -->
  <% 
  long commentNo = Integer.parseInt( request.getParameter("cId"));
  Comment comment = CommentService.getInstance().selectByPK(commentNo);
  %>
     
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
<title> 메세지 보기 </title>
</head>
<body>
<form action="deleteCommentSave.jsp">
<table>
정말 삭제하시려면 작성자명을 다시 입력해주세요
	<tr><td></td><td><input type="hidden" name="commentNo" size="3" readonly value="<%=  comment.getCommentNo()%>"/></td></tr>
	<tr><td>사용자</td><td><input type="text" name="userId" size="15""/></td></tr>
			<tr><td colspan="2">
				<input type="submit" id="btnModify" value="삭제"/>
				<input type="button" id="btnDelete" value="취소" onClick="location.href='viewComment.jsp?cId='<%=comment.getCommentNo()%>"/>
				</td></tr>
</table>


</form>
</body>
</html>