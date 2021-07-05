<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="sample.*" %>
    <%
    // 한글처리
    request.setCharacterEncoding("utf-8");
    // 1. 이전 화면에서 사용자 입력값을 얻어오기
    int eno = Integer.parseInt(request.getParameter("eno"));
    String ename = request.getParameter("ename");
    int salary = Integer.parseInt(request.getParameter("salary"));
    String job = request.getParameter("job");
    String hiredate = request.getParameter("hiredate");
    // 2. 입력값을 VO 객체에 전송
    EmpVO vo = new EmpVO();
    vo.setEno(eno);
    vo.setEname(ename);
    vo.setSalary(salary);
    vo.setJob(job);
    vo.setHiredate(hiredate);
    // 3. DAO의 insert 함수 호출
    EmpDAO dao = EmpDAO.getInstance();
    // 싱글톤 호출
    dao.insertEmp(vo);
    
    response.sendRedirect("selectEmp.jsp");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>