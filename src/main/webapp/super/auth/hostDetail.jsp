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

 /* 스크롤을 제거하는 스타일 */
        html, body {
            overflow: hidden; /* 스크롤을 숨김 */
            height: 100%; /* 100% 높이를 차지하도록 설정 */
            margin: 0;
            padding: 0;
        }
        
        /* 페이지 전체 크기를 채우는 레이아웃을 유지하기 위한 스타일 */
        #layoutSidenav_content {
            min-height: 100%;
            height: auto;
        }
</style>

<script>
	$(function(){
		/* 등록상태 라디오 */
		const host_ben_check = ${host.getHost_ben_check()};
		const host_check = ${host.getHost_check()};
		//console.log("등록상태 : " + fesState);
		if (host_ben_check === 0) {
	    $("#radio_1").prop("checked", true); //벤
	} else if(host_ben_check === 1) { //활성화
	    $("#radio_2").prop("checked", true);
	} 	//console.log("등록상태 : " + fesState);
		else if (host_check === 0) {
	    $("#radio_3").prop("checked", true); //승인대기
	} else(host_check === 1) { //수정대기
	    $("#radio_4").prop("checked", true);
	}
		
	});
</script>
</head>

<body>
	<h1>문화행사 상세페이지</h1>

	<!-- 폼 -->
	<form action="front?key=superAuth&methodName=hostUpdate" method="post">
		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="host_seq" name="host_seq"
						readonly>${host.host_seq}</textarea>
					<label for="host_seq">주최자 번호</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="host_id" name="host_id" readonly>${host.host_id}</textarea>
					<label for="host_id">주최자 아이디</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="com_name" name="com_name" readonly>${host.com_name}</textarea>
					<label for="com_name">기업 명</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="host_pw" name="host_pw" readonly>${host.host_pw}</textarea>
					<label for="host_pw">주최자 비밀번호</label>
				</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="host_tel" name="host_tel" readonly>${host.host_tel}</textarea>
					<label for="host_tel">주최자 전화번호</label>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="host_name" name="host_name" readonly>${host.host_name}</textarea>
					<label for="host_name">대표자 이름</label>
				</div>
			</div>
		</div>
		<br>
		<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="rep_name" name="rep_name"
						readonly>${host.rep_name}</textarea>
					<label for="rep_name">가입자 명</label>
				</div>
			</div>

		<div class="col-md-6">
			승인 상태 <br>
			<!-- 등록상태 라디오 -->
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="hostLoginStateOptions"
					id="radio_3" value="0"> <label class="form-check-label"
					for="inlineRadio1">미승인 상태</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="hostLoginStateOptions"
					id="radio_4" value="1"> <label class="form-check-label"
					for="inlineRadio2">승인 완료 상태</label>
			</div>
			
		</div>
		<br>

		<div class="col-md-6">
			활동 상태 <br>
			<!-- 등록상태 라디오 -->
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="hostStateOptions"
					id="radio_1" value="0"> <label class="form-check-label"
					for="inlineRadio1">벤 상태</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-state-radio" type="radio" name="hostStateOptions"
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