<%@page import="wep.mvc.dto.UsersDTO"%>
<%@page import="wep.mvc.dao.UsersDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="loginCheck.jsp" %>
<!DOCTYPE html>
<html lang="utf-8" data-bs-theme="auto">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="../css/login.css"> <!-- CSS 파일 링크 -->
</head>
<body>
    <div class="login-container">
        <h2>로그인</h2>
        <div class="tab">
            <button class="tab-btn active" id="member-tab" onclick="showSection('member')">회원 로그인</button>
            <button class="tab-btn" id="corporate-tab" onclick="showSection('corporate')">기업 로그인</button>
        </div>

        <!-- 일반회원 -->
        <div id="member-login" class="login-section active">
            <form id="member-login-form" method="get" action="${pageContext.request.contextPath}/front" onsubmit="return validateLogin('member')">
                <input type="hidden" name="key" value="user" /> 
                <input type="hidden" name="methodName" value="login" />
                <div class="form-group">
                    <input type="text" id="member-id" name="member-id" placeholder="회원아이디를 입력하세요" required aria-label="회원 아이디">
                </div>
                <div class="form-group">
                    <input type="password" id="member-password" name="member-password" placeholder="비밀번호를 입력하세요" required aria-label="비밀번호">
                </div>
                <div class="error-message" id="member-error"></div>
                <button type="submit" class="login-btn">로그인</button>
                <button type="button" class="register-btn" onclick="location.href='choice.jsp';">회원가입하기</button>
            </form>
        </div>

        <!-- 기업회원 -->
        <div id="corporate-login" class="login-section">
            <form id="corporate-login-form" method="post" action="${pageContext.request.contextPath}/front" onsubmit="return validateLogin('corporate')">
              <input type="hidden" name="key" value="host" /> 
              <input type="hidden" name="methodName" value="login" />
             
                <div class="form-group">
                    <input type="text" id="corporate-id" name="corporate-id" placeholder="기업아이디를 입력하세요" required aria-label="기업 아이디">
                </div>
                <div class="form-group">
                    <input type="password" id="corporate-pw" name="corporate-pw" placeholder="비밀번호를 입력하세요" required aria-label="비밀번호">
                </div>
                <div class="error-message" id="corporate-error"></div>
                <button type="submit" class="login-btn">로그인</button>
                <button type="button" class="register-btn" onclick="location.href='choice.jsp';">회원가입하기</button>
            </form>
        </div>

       
    </div>
	
    <script src="../js/login.js"></script> <!-- JavaScript 파일 링크 -->
</body>
</html>
