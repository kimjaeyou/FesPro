<%@page import="wep.mvc.dto.UsersDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myPageCheck.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>회원정보변경</title>
<link href="${path}/css/update.css" rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		<jsp:include page="../common/mySide.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h2 class="mt-4 text-center">회원정보 변경</h2>
					<br>
					<h4>
						<p>기본정보</p>
					</h4>
					<hr>
					<form id="update-form" method="post"
						action="${pageContext.request.contextPath}/front">
						<input type="hidden" name="key" value="mypage" /> 
						<input type="hidden" name="methodName" value="update" />

						<table id="festable">
							<thead>
								<tr>
									<th>이름</th>
									<th><input type="text" placeholder="이름을 입력하세요" name="name"
										value="${requestScope.users.user_name}" required></th>
								</tr>
								<tr>
									<th>아이디</th>
									<th><input type="text" value="${sessionScope.loginUser.user_id}"
										name="id" readonly required></th>
								</tr>
								<tr>
									<th>비밀번호</th>
									<th><input type="password" id="pw" name="pw"
										placeholder="비밀번호를 입력하세요" autoComplete="off"  required></th>
								</tr>
								
								<tr>
									<th>비밀번호 확인</th>
									<th><input type="password" id="check-pw"
										name="check-pw" autoComplete="off" placeholder="비밀번호를 다시 입력하세요" required>								
										<p id="print"> </p>
									</th> 
								</tr>

								<tr>
									<th>나이</th>
									<th><input type="text" name="age" class="age"
										maxlength="3" placeholder="나이를 입력하세요" value="${requestScope.users.age}"
										required> 세
								</tr>
								<tr>
									<th>전화번호</th>
									<th><input type="tel" maxlength="3" placeholder="010"
										name="tel1" value="${requestScope.users.user_tel.split('-')[0]}"
										required> - <input type="tel" maxlength="4"
										placeholder="1234" name="tel2"
										value="${requestScope.users.user_tel.split('-')[1]}" required>-
										<input type="tel" maxlength="4" placeholder="5678" name="tel3"
										value="${requestScope.users.user_tel.split('-')[2]}" required></th>
								</tr>
								<tr>
									<th>이메일</th>
									<th>
										<div class="email-input-container">
											<input type="text" id="email1" name="email1"
												placeholder="이메일 입력"
												value="${requestScope.users.email.split('@')[0]}" required /> @ <input
												type="text" id="email2" name="email2" placeholder="이메일 입력"
												value="${requestScope.users.email.split('@')[1]}" required />
										</div>
									</th>
								</tr>
								<tr>
									<th>주소</th>
									<th><input type="text" class="addr" name="addr"
										placeholder="주소를 입력하세요" value="${requestScope.users.addr}" required></th>
								</tr>
								<tr>
									<th>성별</th>
									<td>
										<div class="gender-container">
											<label> <input type="radio" name="gender" value="남성"
												required>남성
											</label> <label> <input type="radio" name="gender" value="여성">
												여성
											</label>
										</div>
									</td>
								</tr>
								<tr>
									<th>장애여부</th>
									<td>
										<div class="hindrance-container">
											<label> <input type="radio" name="hindrance"
												value="O" required> 예
											</label> <label> <input type="radio" name="hindrance"
												value="X"> 아니오
											</label>
										</div>
									</td>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<button type="submit" class="update-button">수정하기</button>
					</form>
					<form id="member-delete-form" method="post"
						action="${pageContext.request.contextPath}/front">
						<input type="hidden" name="key" value="user" /> <input
							type="hidden" name="methodName" value="delete" /> <input
							type="hidden" value="${loginUser.user_id}" name="id" readonly
							required>
						<button type="submit" class="delete-button">회원탈퇴</button>
					</form>
				</div>
			</main>
		</div>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="${path}/js/update.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>

</html>
