<%@page import="java.sql.Connection"%>
<%@page import="wep.mvc.util.DbUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DB 연결 TEST</h1>
<%
	Connection con = DbUtil.getConnection();
%>

연결 : <%=con%>
</body>
</html>