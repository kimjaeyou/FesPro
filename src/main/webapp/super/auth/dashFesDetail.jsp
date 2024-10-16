<%@page import="wep.mvc.dto.FesDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link href="${path}/css/My_styles.css" rel="stylesheet" />
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
	
	<!-- jquery -->
     <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <!-- 부트스트랩 컴포넌트 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
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
    		const fesState = ${fes.getFes_state()};
    		//console.log("등록상태 : " + fesState);
    		if (fesState === 0) {
		    $("#radio_1").prop("checked", true); //승인대기
		} else if (fesState === 2) { //수정대기
		    $("#radio_2").prop("checked", true);
		} else if (fesState === 1) {
		    $("#radio_3").prop("checked", true); //승인완료
		} else if (fesState === 3) {
		    $("#radio_4").prop("checked", true); //비활성화
		}
    		
    	});
    </script>
</head>

<body>
	<h1>문화행사 상세페이지</h1>
	
	<!-- 폼 -->
	<form action="front?key=superfestival&methodName=update" method="post">
    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="SVCID" name="SVCID" readonly>${fes.SVCID}</textarea>
                <label for="SVCID">서비스 아이디</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="MAXCLASSNM" name="MAXCLASSNM" readonly>${fes.MAXCLASSNM}</textarea>
                <label for="MAXCLASSNM">대분류명</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="MINCLASSNM" name="MINCLASSNM" readonly>${fes.MINCLASSNM}</textarea>
                <label for="MINCLASSNM">소분류명</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="SVCSTATNM" name="SVCSTATNM" readonly>${fes.SVCSTATNM}</textarea>
                <label for="SVCSTATNM">서비스 상태</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="SVCNM" name="SVCNM" readonly>${fes.SVCNM}</textarea>
                <label for="SVCNM">서비스명</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="PAYATNM" name="PAYATNM" readonly>${fes.PAYATNM}</textarea>
                <label for="PAYATNM">결제 방법</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="PLACENM" name="PLACENM" readonly>${fes.PLACENM}</textarea>
                <label for="PLACENM">장소명</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="USETGTINFO" name="USETGTINFO" readonly>${fes.USETGTINFO}</textarea>
                <label for="USETGTINFO">서비스 대상</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="X" name="X" readonly>${fes.getX()}</textarea>
                <label for="X">장소 X 좌표</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="Y" name="Y" readonly>${fes.getY()}</textarea>
                <label for="Y">장소 Y 좌표</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="SVCOPNBGNDT" name="SVCOPNBGNDT" readonly>${fes.SVCOPNBGNDT}</textarea>
                <label for="SVCOPNBGNDT">서비스 개시 시작일시</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="SVCOPNENDDT" name="SVCOPNENDDT" readonly>${fes.SVCOPNENDDT}</textarea>
                <label for="SVCOPNENDDT">서비스 개시 종료일시</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="RCPTBGNDT" name="RCPTBGNDT" readonly>${fes.RCPTBGNDT}</textarea>
                <label for="RCPTBGNDT">접수 시작일시</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="AREANM" name="AREANM" readonly>${fes.AREANM}</textarea>
                <label for="AREANM">지역명</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="IMGURL" name="IMGURL" readonly>${fes.IMGURL}</textarea>
                <label for="IMGURL">이미지 경로</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="DTLCONT" name="DTLCONT" readonly>${fes.getDTLCONT()}</textarea>
                <label for="DTLCONT">상세 내용</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="TELNO" name="TELNO" readonly>${fes.getTELNO()}</textarea>
                <label for="TELNO">전화번호</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="V_MAX" name="V_MAX" readonly>${fes.getV_MAX()}</textarea>
                <label for="V_MAX">서비스 이용 시작시간</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="V_MIN" name="V_MIN" readonly>${fes.getV_MIN()}</textarea>
                <label for="V_MIN">서비스 이용 종료시간</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="REVSTDDAY" name="REVSTDDAY" readonly>${fes.REVSTDDAY}</textarea>
                <label for="REVSTDDAY">취소 기간 기준일</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="REVSTDDAYNM" name="REVSTDDAYNM" readonly>${fes.getREVSTDDAYNM()}</textarea>
                <label for="REVSTDDAYNM">취소 기간 기준 정보</label>
            </div>
        </div>
        <%-- <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="Fes_state" name="Fes_state">${fes.getFes_state()}</textarea>
                <label for="Fes_state">등록 상태</label>
            </div>
        </div> --%>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="host_seq" name="host_seq" readonly>${fes.getHost_seq()}</textarea>
                <label for="host_seq">주최자 Sequence</label>
            </div>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="Update_date" name="Update_date" readonly>${fes.getUpdate_date()}</textarea>
                <label for="Update_date">등록/수정 일시</label>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-floating">
                <textarea class="form-control" id="MAXNUM" name="MAXNUM" readonly>${fes.MAXNUM}</textarea>
                <label for="MAXNUM">최대 인원수</label>
            </div>
        </div>
    </div>
    <br>

		<div class="row">
			<div class="col-md-6">
				<div class="form-floating">
					<textarea class="form-control" id="PRICE" name="PRICE" readonly>${fes.PRICE}</textarea>
					<label for="PRICE">가격</label>
				</div>
			</div>
			
			<div class="col-md-6">
			등록 상태
			<br>
			<!-- 등록상태 라디오 -->
				<div class="form-check form-check-inline">
					<input class="form-state-radio" type="radio" name="festivalStateOptions" id="radio_1" value="0">
					<label class="form-check-label" for="inlineRadio1">승인 대기</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-state-radio" type="radio" name="festivalStateOptions" id="radio_2" value="2">
					<label class="form-check-label" for="inlineRadio2">수정 대기</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-state-radio" type="radio" name="festivalStateOptions" id="radio_3" value="1">
					<label class="form-check-label" for="inlineRadio2">승인 완료</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-state-radio" type="radio" name="festivalStateOptions" id="radio_4" value="3">
					<label class="form-check-label" for="inlineRadio2">비활성화</label>
				</div>
			</div>
		</div>
		<p>
		
        <!-- 버튼 -->
    <div class="d-grid gap-2">
        <button class="btn btn-primary" type="submit">저장</button>
        <button class="btn btn-outline-danger" type="button"  onclick="history.back()">뒤로가기</button>
    </div>
</form>
<!-- 폼 끝 -->
	
</body>
</html>