<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원등록 화면</title>
</head>
<body>

<!--  사번 / 이름 / 월급 / 업무를 입력받는 화면 -->
<form method="post" action="saveEmp.jsp">
<table>
<tr>
	<td>사번</td>
	<td><input type="text" id="eno" name="eno"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" id="ename" name="ename"></td>
</tr>
<tr>
	<td>월급</td>
	<td><input type="text" id="salary" name="salary"></td>
</tr>
<tr>
	<td>업무</td>
	<td><input type="text" id="job" name="job"></td>
</tr>
<tr>
	<td>입사일</td>
	<td><input type="date" id="hiredate" name="hiredate"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="등록">
<input type="reset" value="초기화">
</td>
</table>
</form>
</body>
</html>