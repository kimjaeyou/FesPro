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
        <form id="corporate-signup-form" action="${pageContext.request.contextPath}/front">
                <input type="hidden" name="key" value="host"  /> 
                <input type="hidden" name="methodName" value="insert" />
        
            <div class="form-group">
                <label for="company-name">기업명</label>
                <input type="text" id="com-name" name="comname" placeholder="기업명을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="representative-name">대표자명</label>
                <input type="text" id="host-name" name="host-name" placeholder="대표자명을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="Register-name">가입자명</label>
                <input type="text" id="rep-name" name="rep-name" placeholder="가입자명을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="username">아이디</label>
                <div class="input-group">
                    <input type="text" id="company-id" name="company-id" placeholder="아이디를 입력하세요." required>
                    <button type="button" id="check-username" class="check-btn">중복 체크</button>
                </div>
            </div>

            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="company-pw" name="company-pw" placeholder="비밀번호를 입력하세요." required>
            </div>

            <div class="form-group">
                <label for="confirm-password">비밀번호 확인</label>
                <input type="password" id="confirm-password" name="confirm-password" placeholder="비밀번호를 다시 입력하세요" required>
                <p id="password-match-message" class="info-text"></p>
            </div>

            <div class="form-group">
                <label for="contact-phone">전화번호</label>
                <div class="input-group">
                    <input type="text" id="company-phone1" name="com-phone1" maxlength="3" placeholder="010" class="phone-input" required>
                    <input type="text" id="company-phone2" name="com-phone2" maxlength="4" placeholder="1234" class="phone-input" required>
                    <input type="text" id="company-phone3" name="com-phone3" maxlength="4" placeholder="5678" class="phone-input" required>
                </div>
            </div>
            <button type="submit" class="signup-btn">가입하기</button>
        </form>
    </div>
    <script src="../js/comUser.js"></script> <!-- JavaScript 파일 링크 -->
</body>
</html>
