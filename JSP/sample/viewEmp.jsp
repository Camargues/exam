<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="sample.*" %>
    <%
 	// 이전 페이지에서 parameter 값 받기
    int eno = Integer.parseInt(request.getParameter("eno"));
    
    
    // DAO에 viewEMP() 호출
   	EmpDAO dao = EmpDAO.getInstance();
    // VO에 
    EmpVO vo = dao.viewEmp(eno);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원목록 보기</title>
</head>
<body>
<table border="2">
<tr><td>사번</td><td>사원명</td><td>매니저</td><td>업무</td><td>입사일</td><td>봉급</td><td>보너스</td><td>부서번호</td></tr>
<% {%>
<tr>
<td><%=vo.getEno() %></td>
<td><%=vo.getEname() %></td>
<td><%=vo.getManager() %></td>
<td><%=vo.getJob() %></td>
<td><%=vo.getHiredate().substring(0, 10) %></td>
<td><%=vo.getSalary() %></td>
<td><%=vo.getCommission() %></td>
<td><%=vo.getDno() %></td>
</tr>
<%}
%>
</table>
<button type="button" onclick="location.href='modifyFormEmp.jsp?eno=<%=vo.getEno() %>'">수정</button>
<button type="button" onclick="location.href='deleteEmp.jsp?eno=<%=vo.getEno() %>'">삭제</button>
</body>
</html>
