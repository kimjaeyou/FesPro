<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>회원정보변경</title>
<link href="../css/update.css" rel="stylesheet" />
<link href="../css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="../common/myHeader.jsp" />
	<div id="layoutSidenav">
		<jsp:include page="../common/mySide.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h2 class="mt-4 text-center">회원정보 변경</h2>
					<br>
					<br>
					<br>
					<h4>
						<p>기본정보</p>
					</h4>
					<hr>
					<table id="festable">
						<thead>
							<tr>
								<th>이름</th>
								<th><input type="text" placeholder="이름을 입력하세요"></th>
							</tr>
							<tr>
								<th>아이디</th>
								<th><input type="text" placeholder="아이디" disabled></th>
							</tr>
							<tr>
								<th>비밀번호</th>
								<th><input type="password" id="password"
									placeholder="비밀번호를 입력하세요"></th>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<th><input type="password" id="confirmPassword"
									placeholder="비밀번호를 다시 입력하세요"> <span
									id="passwordMessage"></span></th>
							</tr>
							<tr>
								<th>생년월일</th>
								<th><input type="text" class="birth-year"
									placeholder="0000"> 년 <input type="text"
									class="birth-month" placeholder="00"> 월 <input
									type="text" class="birth-day" placeholder="00"> 일</th>
							</tr>
							<tr>
								<th>전화번호</th>
								<th><input type="tel" placeholder="010"> - <input
									type="tel" placeholder="1234"> - <input type="tel"
									placeholder="5678"></th>
							</tr>
							<tr>
								<th>이메일</th>
								<th>
									<div class="email-input-container">
										<input type="text" id="emailInput1" placeholder="이메일 입력" /> @
										<input type="text" id="emailInput2" placeholder="이메일 입력" /> <select
											id="addressSelect" class="address-select">
											<option value="">주소 선택</option>
											<option value="naver.com">naver.com</option>
											<option value="dame.net">daum.net</option>
											<option value="gmail.com">gmail.com</option>
											<option value="kakao.com">kakao.com</option>
										</select>
									</div>
								</th>
							</tr>

							<tr>
								<th>주소</th>
								<th><input type="text" class="addr" placeholder="주소를 입력하세요"></th>
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<div class="gender-container">
										<label> <input type="radio" name="gender" value="male">
											남성
										</label> <label> <input type="radio" name="gender"
											value="female"> 여성
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<th>장애여부</th>
								<td>
									<div class="hindrance-container">
										<label> <input type="radio" name="hindrance"
											value="true"> 예
										</label> <label> <input type="radio" name="hindrance"
											value="false"> 아니오
										</label>
									</div>
								</td>
							</tr>


						</thead>
						<tbody>
						</tbody>
					</table>
					<form action="회원정보변경.html">
						<button type="submit" class="update-button">수정하기</button>
						<button type="button" class="delete-button"
							onclick="confirmDelete()">회원탈퇴</button>
					</form>
				</div>
			</main>

			<!-- 푸터입니다. -->

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
	<script src="../js/update.js"></script>
</body>

</html>
