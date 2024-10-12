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
					<h4>
						<p>기본정보</p>
					</h4>
					<hr>
					
					<form id="member-update-form" method="get" action="${pageContext.request.contextPath}/front">
          			<input type="hidden" name="key" value="user" /> 
            		<input type="hidden" name="methodName" value="update" />
            		
            			
					<table id="festable">
						<thead>
							<tr>
								<th>이름</th>
								<th><input type="text" placeholder="이름을 입력하세요"  name="name" value="${loginUser.user_name}" required></th>
							</tr>
							<tr>
								<th>아이디</th>
								<th><input type="text" value="${loginUser.user_id}" name="id" readonly required></th>
							</tr>
							<tr>
								<th>비밀번호</th>
								<th><input type="password" id="password" name="pw"
									placeholder="비밀번호를 입력하세요" required></th>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<th><input type="password" id="confirmPassword"
									placeholder="비밀번호를 다시 입력하세요" required> <span
									id="passwordMessage"></span></th>
							</tr>
							<tr>
								<th>나이</th>
								<th><input type="text" name="age" class="age" placeholder="0000" value="${loginUser.age}" required> 세
							</tr>
							<tr>
								<th>전화번호</th>
								<th><input type="tel" placeholder="010"  name="tel1"required> - 
									<input type="tel" placeholder="1234" name="tel2"required> - 
									<input type="tel" placeholder="5678" name="tel3"required></th>
							</tr>
							<tr>
								<th>이메일</th>
								<th>
									<div class="email-input-container">
										<input type="text" id="emailInput1" name="email1"placeholder="이메일 입력" value="${loginUser.email}" required/> @
										<input type="text" id="emailInput2" name="email2"placeholder="이메일 입력" value="${loginUser.email}" required/> 
									</div>
								</th>
							</tr>

							<tr>
								<th>주소</th>
								<th><input type="text" class="addr"name="addr" placeholder="주소를 입력하세요" value="${loginUser.addr}"required></th>
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<div class="gender-container">
										<label> <input type="radio" name="gender" value="1"required>남성
										</label> <label> <input type="radio" name="gender" value="2"> 여성
										</label>
									</div>
								</td>
							</tr>
							<tr>
								<th>장애여부</th>
								<td>
									<div class="hindrance-container">
										<label> <input type="radio" name="hindrance" value="1"required> 예
										</label> <label> <input type="radio" name="hindrance" value="0"> 아니오
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
           		
           			<form id="member-delete-form" method="get" action="${pageContext.request.contextPath}/front">
          		      	<button type="submit" class="delete-button">회원탈퇴</button>
						<input type="hidden" name="key" value="user" /> 
    		        	<input type="hidden" name="methodName" value="delete" />	
					
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
