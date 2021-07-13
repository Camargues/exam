
 <%@ page import="java.util.*" %>
<%@page import="mybatis.guest.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원정보</title>
<%
List<HashMap> mList = EmployeeService.getInstance().empSelect();

%>
</head>
<body>
<!-- 
	table 구조로 사원번호 사원명 업무 부서명을 출력
 -->
 <table border="1">
<tr><th>사원번호</th><th>사원명</th><th>업무</th><th>부서명</th>
<%for(HashMap map : mList){ %>
	<tr>
			<td><%=map.get("ENO")  %></td>
			<td><%=map.get("ENAME")  %></td>
			<td><%=map.get("JOB")  %></td>
			<td><%=map.get("DNAME")  %></td>
	</tr>
<%} %>
 </table>
</body>
</html>