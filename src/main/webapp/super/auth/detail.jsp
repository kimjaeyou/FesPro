<%@page import="wep.mvc.dto.FesDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<!-- 부트스트랩 컴포넌트 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
textarea[readonly] {
	background-color: #f0f0f0; /* 연한 회색 */
	color: #000; /* 텍스트 색상 */
}

 
</style>

<script>
	$(function(){
		/* 등록상태 라디오 */
		const user_ben_check = ${user.user_ben_check};
		//console.log("등록상태 : " + fesState);
		if (user_ben_check === 0) {
	    $("#radio_1").prop("checked", true); //승인대기
	} else{ //수정대기
	    $("#radio_2").prop("checked", true);
	} 
		
	});
</script>
</head>

<body>
	<h1>문화행사 상세페이지</h1>

	<!-- 폼 -->
	<form action="front?key=superAuth&methodName=update" method="post"><!-- 
		<input type="hidden" id="benC" nam="user_ben_check"
			value=${user.user_ben_check}> -->
		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="user_seq" name="user_seq"
						readonly>${user.user_seq}</textarea>
					<label for="user_seq">회원 번호</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="user_id" name="user_id" readonly>${user.user_id}</textarea>
					<label for="user_id">회원 아이디</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="user_pw" name="user_pw" readonly>${user.user_pw}</textarea>
					<label for="user_pw">회원 비밀번호</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="age" name="age" readonly>${user.age}</textarea>
					<label for="age">회원 나이</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="addr" name="addr" readonly>${user.addr}</textarea>
					<label for="addr">회원 주소</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="gender" name="gender" readonly>${user.gender}</textarea>
					<label for="gender">회원 성별</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="email" name="email" readonly>${user.email}</textarea>
					<label for="email">이메일</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="user_name" name="user_name"
						readonly>${user.user_name}</textarea>
					<label for="user_name">회원 이름</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="disable" name="disable" readonly>${user.disable}</textarea>
					<label for="disable">장애 여부</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="user_tel" name="user_tel"
						readonly>${user.user_tel}</textarea>
					<label for="user_tel">회원 전화번호</label>
				</div>
			</div>
		</div>
		<br>

		<div class="col-md-6">
			활동 상태 <br>
			<!-- 등록상태 라디오 -->
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="authStateOptions"
					id="radio_1" value="0"> <label class="form-check-label"
					for="inlineRadio1">벤 상태</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="authStateOptions"
					id="radio_2" value="1"> <label class="form-check-label"
					for="inlineRadio2">활성화 상태</label>
			</div>

		</div>
		<!-- 버튼 -->
		<div class="d-grid gap-2">
			<button class="btn btn-primary" type="submit">저장</button>
			<button class="btn btn-outline-danger" type="button"
				onclick="history.back()">뒤로가기</button>
		</div>
	</form>
	<!-- 폼 끝 -->

</body>
</html>