<%@page import="wep.mvc.dto.UsersDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="loginCheck.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="../css/choice.css"> <!-- CSS 파일 링크 -->
</head>
<body>
    <div class="signup-container">
        <h2>회원가입</h2>
        <button class="signup-btn" onclick="location.href='user.jsp';">일반회원</button>
        <button class="signup-btn" onclick="location.href='comUser.jsp';">기업회원</button>
    </div>
</body>
</html>
