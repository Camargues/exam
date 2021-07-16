<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- JSTL 선언 -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/multiInsert.jsp</title>
</head>
<body>
<h3>멤버 목록 보기</h3>
<table>
<tr><th>아이디</th><th>이름</th><th>나이</th>
</tr>
<!-- memberVOList에 있는 list를 불러옴 -->
<c:forEach var="vo" items="${memberVOList.list }">
<c:if test="${vo.state }">
	<tr>
		<td>${vo.id }</td>
		<td>${vo.name }</td>
		<td>${vo.age }</td>
	</tr>
	</c:if>
</c:forEach>
</table>
</body>
</html>