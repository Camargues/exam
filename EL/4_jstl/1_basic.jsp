<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1_basic.jsp</title>
</head>
<body>
<!-- 변수 선언 -->
<c:set var='gender' value='male'/>
<c:set var='age'>25</c:set>
<!-- 제어문 -->
<c:if test="${ gender eq 'male' }">남성입니다</c:if>
<c:if test="${ gender eq 'female' }">여성입니다</c:if>
<br>
<c:if test="${ age ge 20 }">성인입니다</c:if>
<c:if test="${ age lt 20 }">미성년자입니다</c:if>
<hr/>
<c:choose>
<c:when test="${ age le 10 }">어린이</c:when>
<c:when test="${ age le 20 }">청소년</c:when>
<c:otherwise>성인</c:otherwise>
</c:choose>
<br>
<!-- 1~100 합구하기 -->
<c:set var='sum' value='0'/>
<c:forEach var='i' begin='1' end='100'>
<c:set var='sum' value='${ sum+i }'/>
</c:forEach>
1~100까지의 합 : ${ sum }<br/>
<!-- 1~100까지 홀수의 합과 짝수의 합 출력 -->
<c:set var='oddsum' value='0'/>
<c:set var='evensum' value='0'/>
<c:forEach var='i' begin='1' end='100'>
<c:if test="${ i mod 2 eq 1}">
<c:set var='oddsum' value='${ oddsum + i }'/>
</c:if>
<c:if test="${ i mod 2 eq 0}">
<c:set var='evensum' value='${ evensum + i }'/>
</c:if>
</c:forEach>
1~100까지의 홀수 합 : ${ oddsum }<br/>
1~100까지의 짝수 합 : ${ evensum }
</body>
</html>