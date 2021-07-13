<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="sample.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원수정 화면</title>
<%
 	// 이전 페이지에서 parameter 값 받기
    int eno = Integer.parseInt(request.getParameter("eno"));
    
    
    // DAO에 viewEMP() 호출
   	EmpDAO dao = EmpDAO.getInstance();
    // VO에 
    EmpVO vo = dao.viewEmp(eno);
    
    
    
    %>
</head>
<body>

<!--  사번 / 이름 / 월급 / 업무를 입력받는 화면 -->
<form method="get" action="updateEmp.jsp">
<table>
<tr>
<td><input type="hidden" id="exeno" name="exeno" value="<%= vo.getEno() %>"></td>
<!-- 기존 사번 내용 숨기기 -->
</tr>
<tr>
	<td>사번</td>
	<td><input type="text" id="eno" name="eno" value="<%= vo.getEno() %>"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" id="ename" name="ename" value="<%= vo.getEname() %>"></td>
</tr>
<tr>
	<td>월급</td>
	<td><input type="text" id="salary" name="salary" value="<%= vo.getSalary() %>"></td>
</tr>
<tr>
	<td>업무</td>
	<td><input type="text" id="job" name="job" value="<%= vo.getJob() %>"></td>
</tr>
<tr>
	<td>입사일</td>
	<td><input type="date" id="hiredate" name="hiredate" value="<%=vo.getHiredate().substring(0, 10)%>"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="수정">
<input type="reset" value="초기화">
</td>
</table>
</form>
</body>
</html>
