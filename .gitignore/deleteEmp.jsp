<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
    <%@ page import="sample.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 삭제</title>
<%
 	// 이전 페이지에서 parameter 값 받기
    int eno = Integer.parseInt(request.getParameter("eno"));
    
    
    // DAO에 viewEMP() 호출
   	EmpDAO dao = EmpDAO.getInstance();
    // VO에 
    int result = dao.deleteEmp(eno);
    
    /* if(result > 0){
    	response.sendRedirect("selectEmp.jsp");
    } */
    %>
</head>
<body>

<%= result%>개의 행이 삭제되었습니다
<br>
<a href="selectEmp.jsp">사원 목록으로 돌아가기</a>
</body>
</html>