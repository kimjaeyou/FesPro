<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="stylesheet" href="../css/user.css">
</head>
<body>
	<div class="signup-container">
		<h2>회원가입</h2>

		<form id="signup-form" method="post"
			action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value="user">
			<input type="hidden" name="methodName" value="insert">


			<div class="form-group">
				<label for="name">이름</label> <input type="text" id="name"
					name="name" placeholder="이름을 입력하세요." required>
			</div>

			<div class="form-group">
				<label for="username">아이디</label>
				<div class="input-group">
					<input type="text" id="username" name="username"
						placeholder="아이디를 입력하세요" required>
				</div>
			</div>

			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password" placeholder="비밀번호를 입력하세요."
					required>
			</div>

			<div class="form-group">
				<label for="confirm-password">비밀번호 확인</label> 
				<input type="password" id="confirm-password" name="confirm-password" placeholder="비밀번호를 다시 입력하세요" required>
				<p id="password-match-message" class="info-text"></p>
			</div>

			<div class="form-group">
				<label for="age">나이</label>
				<div class="input-group">
					<input type="text" id="age" name="age" maxlength="3"
						placeholder="니이를 입력하세요." class="date-input" required> <span>세</span>
				</div>
			</div>

			<div class="form-group">
				<label for="phone">전화번호</label>
				<div class="input-group">
					<input type="text" id="phone1" name="phone1" maxlength="3"
						placeholder="010" class="phone-input" required> <span>-</span>
					<input type="text" id="phone2" name="phone2" maxlength="4"
						placeholder="1234" class="phone-input" required> <span>-</span>
					<input type="text" id="phone3" name="phone3" maxlength="4"
						placeholder="5678" class="phone-input" required>
				</div>
			</div>
			<label for="emailInput1">이메일</label>
			<div class="email-input-container">
				<input type="text" id="emailInput1" name="email1" placeholder="이메일 입력"  required/> @ 
				<input type="text" id="emailInput2"	name="email2" placeholder="이메일 입력" required/> 
			</div>

			<br>
			<div class="form-group">
				<label for="address">주소</label> <input type="text" id="address"
					name="address" placeholder="주소를 입력하세요." required>
			</div>

			<div class="form-group">
				<label>성별</label>
				<div class="gender-container">
					<label> <input type="radio" name="gender" value="남성" required> 남성 
					<input type="radio" name="gender" value="여성"> 여성
					</label>
				</div>
			</div>

			<div class="form-group">
				<label>장애여부</label>
				<div class="hindrance-container">
					<label> <input type="radio" name="hindrance" value="O" required> 예 
					<input type="radio" name="hindrance" value="X" > 아니오
					</label>
				</div>
			</div>

			<button type="submit" class="signup-btn">가입하기</button>

		</form>
	</div>

	<script src="../js/user.js"></script>
	<!-- 외부 JavaScript 파일 연결 -->
</body>
</html>
