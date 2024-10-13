<%@page import="wep.mvc.dto.FesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link href="${path}/css/My_styles.css" rel="stylesheet" />
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
	
	<!-- jquery -->
     <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	 <!-- 차트js  -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- 차트 만들어논 js 파일-->
    <script type="text/javascript" src="${path}/super/festival/chart.js"></script>
    <script>
    	/* 캔버스 이름으로 찾기 */
    	const getCanvas = function(canvasName){
    		return document.getElementById(canvasName).getContext('2d');
    	};

    	/* 리퀘스트로 넘어온 json 데이터 */
   		const userList = ${requestScope.userList};
   		//console.log(userList);
   		
    	/* 차트 함수 Call */
    	$(function(){
    		//연령, 성별 통계
    		ageGender(getCanvas('ageGender'),userList);
    		
    		//성별 비율
    		genderRatio(getCanvas('genderRatio'),userList);
    		
    		//연령별 비율
    		ageRatio(getCanvas('ageRatio'),userList);
    		
    	});
    </script>
</head>

<body>
	<h1>문화행사 상세페이지</h1>
	FesDto = ${fes.SVCID} <br>
	${requestScope.reservation}
	<form action="front?key=superfestival&methodName=update" method="post">
        <label for="SVCID">서비스 아이디:</label>
        <input type="text" id="SVCID" name="SVCID" value="${fes.SVCID}" readonly><br><br>
        
        <label for="MAXCLASSNM">대분류명:</label>
        <input type="text" id="MAXCLASSNM" name="MAXCLASSNM" value="${fes.MAXCLASSNM}"><br><br>
        
        <label for="MINCLASSNM">소분류명:</label>
        <input type="text" id="MINCLASSNM" name="MINCLASSNM" value="${fes.MINCLASSNM}"><br><br>
        
        <label for="SVCSTATNM">서비스 상태:</label>
        <input type="text" id="SVCSTATNM" name="SVCSTATNM" value="${fes.SVCSTATNM}"><br><br>
        
        <label for="SVCNM">서비스명:</label>
        <input type="text" id="SVCNM" name="SVCNM" value="${fes.SVCNM}"><br><br>
        
        <label for="PAYATNM">결제 방법:</label>
        <input type="text" id="PAYATNM" name="PAYATNM" value="${fes.PAYATNM}"><br><br>
        
        <label for="PLACENM">장소명:</label>
        <input type="text" id="PLACENM" name="PLACENM" value="${fes.PLACENM}"><br><br>
        
        <label for="USETGTINFO">서비스 대상:</label>
        <input type="text" id="USETGTINFO" name="USETGTINFO" value="${fes.USETGTINFO}"><br><br>
        
        <label for="X">장소 X 좌표:</label>
        <input type="text" id="X" name="X" value="${fes.getX()}"><br><br>
        
        <label for="Y">장소 Y 좌표:</label>
        <input type="text" id="Y" name="Y" value="${fes.getY()}"><br><br>
        
        <label for="SVCOPNBGNDT">서비스 개시 시작일시:</label>
        <input type="text" id="SVCOPNBGNDT" name="SVCOPNBGNDT" value="${fes.SVCOPNBGNDT}"><br><br>
        
        <label for="SVCOPNENDDT">서비스 개시 종료일시:</label>
        <input type="text" id="SVCOPNENDDT" name="SVCOPNENDDT" value="${fes.SVCOPNENDDT}"><br><br>
        
        <label for="RCPTBGNDT">접수 시작일시:</label>
        <input type="text" id="RCPTBGNDT" name="RCPTBGNDT" value="${fes.RCPTBGNDT}"><br><br>
        
        <label for="AREANM">지역명:</label>
        <input type="text" id="AREANM" name="AREANM" value="${fes.AREANM}"><br><br>
        
        <label for="IMGURL">이미지 경로:</label>
        <input type="text" id="IMGURL" name="IMGURL" value="${fes.IMGURL}"><br><br>
        
        <label for="DTLCONT">상세 내용:</label>
        <textarea id="DTLCONT" name="DTLCONT">${fes.getDTLCONT()}</textarea><br><br>
        
        <label for="TELNO">전화번호:</label>
        <input type="text" id="TELNO" name="TELNO" value="${fes.getTELNO()}"><br><br>
        
        <label for="V_MAX">서비스 이용 시작시간:</label>
        <input type="text" id="V_MAX" name="V_MAX" value="${fes.getV_MAX()}"><br><br>
        
        <label for="V_MIN">서비스 이용 종료시간:</label>
        <input type="text" id="V_MIN" name="V_MIN" value="${fes.getV_MIN()}"><br><br>
        
        <label for="REVSTDDAY">취소 기간 기준일:</label>
        <input type="text" id="REVSTDDAY" name="REVSTDDAY" value="${fes.REVSTDDAY}"><br><br>
        
        <label for="REVSTDDAYNM">취소 기간 기준 정보:</label>
        <input type="text" id="REVSTDDAYNM" name="REVSTDDAYNM" value="${fes.getREVSTDDAYNM()}"><br><br>
        
        <label for="Fes_state">등록 상태:</label>
        <input type="number" id="Fes_state" name="Fes_state" value="${fes.getFes_state()}"><br><br>
        
        <label for="Update_date">등록/수정 일시:</label>
        <input type="text" id="Update_date" name="Update_date" value="${fes.getUpdate_date()}"><br><br>
        
        <label for="MAXNUM">최대 인원수:</label>
        <input type="number" id="MAXNUM" name="MAXNUM" value="${fes.MAXNUM}"><br><br>
        
        <label for="PRICE">가격:</label>
        <input type="number" id="PRICE" name="PRICE" value="${fes.PRICE}"><br><br>
        
        <label for="host_seq">주최자 Sequence:</label>
        <input type="number" id="host_seq" name="host_seq" value="${fes.getHost_seq()}" readonly><br><br>
        
        <input type="submit" value="저장">
        <input type="button" value = "뒤로가기">
    </form>
	
	<p>
	<!-- 차트 -->
	<h1>예약자 통계</h1>
		<div class="row">
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령, 성별 통계
					</div>
					<div class="card-body">
						<canvas id="ageGender" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>
			
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 남녀 비율
					</div>
					<div class="card-body">
						<canvas id="genderRatio" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>
			
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령대 별 비율
					</div>
					<div class="card-body">
						<canvas id="ageRatio" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>
			
		<h1>리뷰 통계</h1>
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> 성별 별
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>
			
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> 연령대 별
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>
		<!-- 차트 끝 -->
</body>
</html>