<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기업 회원가입</title>
    <link rel="stylesheet" href="../css/comUser.css"> <!-- CSS 파일 링크 -->
</head>
<body>
    <div class="signup-container">
        <h2>기업 회원가입</h2>
        <form id="corporate-signup-form">
            <div class="form-group">
                <label for="company-name">기업명</label>
                <input type="text" id="company-name" name="company-name" placeholder="기업명을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="representative-name">대표자명</label>
                <input type="text" id="representative-name" name="representative-name" placeholder="대표자명을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="username">아이디</label>
                <div class="input-group">
                    <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" required>
                    <button type="button" id="check-username" class="check-btn">중복 체크</button>
                </div>
            </div>

            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호 입력 (최소 8자)" required>
            </div>

            <div class="form-group">
                <label for="confirm-password">비밀번호 확인</label>
                <input type="password" id="confirm-password" name="confirm-password" placeholder="비밀번호를 다시 입력하세요" required>
                <p id="password-match-message" class="info-text"></p>
            </div>

            <div class="form-group">
                <label for="contact-phone">전화번호</label>
                <div class="input-group">
                    <input type="text" id="contact-phone1" name="contact-phone1" maxlength="3" placeholder="010" class="phone-input" required>
                    <input type="text" id="contact-phone2" name="contact-phone2" maxlength="4" placeholder="1234" class="phone-input" required>
                    <input type="text" id="contact-phone3" name="contact-phone3" maxlength="4" placeholder="5678" class="phone-input" required>
                </div>
                <p class="info-text">예: 010-1234-5678</p>
            </div>

            <button type="submit" class="signup-btn">가입하기</button>
        </form>
    </div>
    <script src="../js/comUser.js"></script> <!-- JavaScript 파일 링크 -->
</body>
</html>
