<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="sample.*" %>
    <%
    	EmpDAO dao = EmpDAO.getInstance();
    	List<EmpVO> list = dao.selectEmp();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원목록 보기</title>
</head>
<body>
<table border="2">
<tr><td>사번</td><td>사원명</td><td>매니저</td><td>업무</td></tr>
<% for(EmpVO vo : list){%>
<tr>
<td><%=vo.getEno() %></td>
<td><a href='viewEmp.jsp?eno=<%=vo.getEno() %>'><%=vo.getEname() %></a></td>
<td><%=vo.getManager() %></td>
<td><%=vo.getJob() %></td>
</tr>
<%}
%>
</table>
</body>
</html>
