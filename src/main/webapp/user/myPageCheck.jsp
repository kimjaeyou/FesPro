<%@page import="wep.mvc.dto.HostDTO"%>
<%@page import="wep.mvc.dto.UsersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 비회원이 마이페이지 가는거 막기
    UsersDTO loginUser = (UsersDTO) session.getAttribute("loginUser");
    HostDTO hostUser = (HostDTO) session.getAttribute("loginCom");

    if (loginUser == null && hostUser == null) {
        response.sendRedirect(request.getContextPath() + "/front?key=main&methodName=read");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
