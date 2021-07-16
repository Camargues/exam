<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진첩</title>
</head>
<body>
<h1>사진첩</h1>
총 이미지 갯수 : ${ boardSize }
<hr>


<table>
<tr>
<!-- 증감 연산자에 사용할 변수 i 선언 -->
<c:set var="i" value="1"/>

<!-- 반복문 forEach 선언 -->
<c:forEach items="${boardList }" var="board">
<td>
<a href="getBoard.do?b_id=${board.b_id }">
<img src="/gWebBoard1/resources/upload/${board.b_fname }" width="300px"/>
</a>
</td>

	<c:choose>
		<c:when test="${i < 3}">
			<c:set var="i" value="${i + 1}"/>
		</c:when>

		<c:otherwise>
			</tr><tr>
			<c:set var="i" value="1"/>
		</c:otherwise>
	</c:choose>
	
</c:forEach>
</tr>
</table>
</body>
</html>