<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page language="java" import="java.sql.*"%>

<%
String driver="oracle.jdbc.driver.OracleDriver";
String user="hr";
String pass="1234";
String dbURL="jdbc:oracle:thin:@localhost:1521:xe";


	Class.forName(driver);
	Connection connection=DriverManager.getConnection(dbURL,user,pass);
	
	String sql = "select * from employee where ename=upper(?)";
	System.out.println(sql);
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setString(1, request.getParameter("id"));
	ResultSet rs = ps.executeQuery();		

	String result="NO";
	if (rs.next()){		
		result = "YES";
	}		
	out.print(result);
%>

