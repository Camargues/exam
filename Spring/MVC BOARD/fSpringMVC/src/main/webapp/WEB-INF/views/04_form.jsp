<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/04_form.jsp</title>
</head>
<body>
폼에서 넘겨받은 파라미터 값 출력<hr/>
id : ${memberVO.id }<br>
age : ${memberVO.age }<br>
name : ${memberVO.name }
<hr>
${sessionScope.login }
</body>
</html>