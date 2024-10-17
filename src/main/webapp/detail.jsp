<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="UTF-8" data-bs-theme="light">
<jsp:include page="/common/header.jsp" />

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">

<style>
.body_containner .area1 {
	width: 90%;
	height: 30%;
	align-content: center;
	text-align: center;
	position: relative; /* relative로 변경 */
}

.area1 .sub_main {
	font: bold;
	font-family: 'Noto Sans';
	position: relative;
	float: none;
	margin-bottom: 20px;
	font-size: 200%;
}

.area1 .img_main #img {
	position: relative;
	width: 45%;
	height: 450px;
	left: 10%;
	float: left;
}

.areaControl {
	text-align: center;
	align-content: center;
}

.conButton {
	position: relative;
	width: 28%;
	height: 90px;
	background-color: #007BFF;
	border: 1px solid #007BFF;
	border-radius: 10px;
	font-size: 200%;
	color: white;
	margin-top: 20px;
	margin-bottom: 20px;
}

.area1 button {
	margin-top: 6%;
	margin-bottom: 6%;
}

.explain_data_small {
	position: relative;
	margin-left: 45px;
	margin-top: 10px;
	left: 10%;
	top: 10%;
	float: left;
	border-radius: 10px;
	box-shadow: 0px 10px 15px 0px #b8b8b8;
}

.explain_data_small div {
	font: bold;
	font-family: Roboto;
	border-bottom: 1px rgba(156, 156, 156, 0.5) solid;
	font-size: 120%;
	top: 10%;
	margin-top: 10px;
	text-align: left;
	font-weight: bolder;
	padding: 3px;
	padding-left: 10px;
	padding-right: 10px;
}

#like {
	background-color: pink;
	border: pink;
	margin-left: 3%;
}

.area2 {
	width: 80%;
	left: 6%;
	position: relative; /* relative로 변경 */
	float: left;
	border: 1px solid rgb(0, 123, 255);
	border-radius: 10px;
	clear: both; /* float 해제 */
	margin-top: 30px; /* 여백 추가 */
	padding: 40px;
	margin-bottom: 50px;
}

.area2 div {
	font: bold;
	font-family: 'Noto Sans';
}

/* 차트 영역 */
.area3 {
	width: 80%;
	left: 6%;
	position: relative; /* relative로 변경 */
	float: left;
	border: 1px solid rgb(0, 123, 255);
	border-radius: 10px;
	clear: both; /* float 해제 */
	margin-top: 30px; /* 여백 추가 */
	padding: 40px;
	margin-bottom: 50px;
}

#reviewsContainer {
	display: flex;
}

#reviews {
	flex: 2;
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 20px;
}

#graphM {
	align-content: center;
	text-align: center;
	padding: 15px;
	background-color: #f1f1f1;
	width: 100%;
}

.rv_con {
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 15px;
	margin-bottom: 15px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	font-size: 20px;
	color: #555;
	width: 90%;
}

.rv_con span {
	margin-left: 5%;
	font-size: 20px;
	color: #D9D748;
}

.avg_con {
	display: flex;
	align-items: center;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 15px;
	margin-top: 20px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	font-size: 20px;
	color: #555;
	width: 90%;
}

.avg_range {
	font-size: 20px;
	color: #555;
	margin: 0 10px;
}

#num {
	position: relative;
	float: left;
	font-size: 20px;
	color: #D9D748;
}

body {
	background-color: white;
	color: black;
  }
</style>
</head>
<body>
	<jsp:include page="/common/alarm.jsp" />
	<div class="body_containner">
		<div class="area1">
			<div class="sub_main">${fes.SVCNM}</div>
			<div class="img_main">
				<img id="img" alt="image" src="${fes.IMGURL}">
			</div>
			<div class="explain_data_small">
				<div class="target">대상 : ${fes.USETGTINFO}</div>
				<div class="location">장소 : ${fes.PLACENM}</div>
				<div class="use_date">이용기간 : ${fes.SVCOPNBGNDT} ~
					${fes.SVCOPNENDDT}</div>
				<div class="in_date">접수기간 : ${fes.RCPTBGNDT} ~
					${fes.RCPTENDDT}</div>
				<div class="man_count">모집정원 : ${fes.MAXNUM}</div>
				<div class="cost">이용요금 : ${fes.PRICE}</div>
				<div class="how">예약방법 : 현장 결제/사전 결제</div>
				<div class="tel">문의 : ${fes.TELNO}</div>
				<form action="front">
					<input type="hidden" name="key" value="reservation" /> <input
						type="hidden" name="methodName" value="revMove" /> <input
						type="hidden" name="SVCID" value="${fes.SVCID}" /> <input
						type="hidden" name="SVCNM" value="${fes.SVCNM}" /> <input
						type="hidden" name="fes" value="${fes}" />
					<button class="btn btn-primary" id="reservation">예약하기</button>
					<button class="btn btn-primary" id="like">좋아요</button>
				</form>


			</div>

		</div>

		<div class="area2">
			<div class="areaControl">
				<button class="conButton" id="information">이용 안내</button>
				<button class="conButton" id="maps">지도</button>
				<button class="conButton" id="review">리뷰</button>
			</div>
			<hr>
			<div class="data_explain">
				<script type="text/javascript">
					const data = `${fes.DTLCONT}`;
					let formattedData = data.replace(/다\./g, '다.<br>');
					/* formattedData = formattedData.replace(/(\d)\. /g, '<br>$1.'); */
					formattedData = formattedData.replace(
							/(\★|\※|\▣|\■|\▶|\□|\○|\❐|\ㅇ)/g, '<br>$1');

					document.querySelector('.data_explain').innerHTML = formattedData
							+ "<br><br>";
				</script>

			</div>
		</div>
		
		<!-- 차트 div -->
		<div class="area3">
			<!-- 캐러셀 -->
			<div id="carouselExample" class="carousel carousel-dark slide" >
			  <div class="carousel-inner">
			  
			<div class="carousel-item active">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령, 성별 통계
					</div>
					<div class="card-body">
						<canvas id="ageGender" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>

			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 남녀 비율
					</div>
					<div class="card-body">
						<canvas id="genderRatio" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>

			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령대 별 비율
					</div>
					<div class="card-body">
						<canvas id="ageRatio" width="100%" height="400"></canvas>
					</div>
				</div>
			</div>
			
			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> 성별 별 평균 평점
					</div>
					<div class="card-body">
						<canvas id="genderReviewAvg" width="100%" height="400" ></canvas>
					</div>
				</div>
			</div>
			
			<div class="carousel-item">
				<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i> 연령대 별 평균 평점
						</div>
						<div class="card-body">
							<canvas id="ageReviewAvg" width="100%" height="400"></canvas>
						</div>
					</div>
			</div>
		</div>
			  
			  <!-- 전환 버튼 -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
<!-- 캐러셀 끝 -->
		</div>

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<!-- <script src="js/scripts.js"></script> -->

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13ac0c7b043360f46d8f5ed642147a6a&libraries=services&onload=false"></script>
<script type="text/javascript">
	$('#like').on('click', function(e) {
		e.preventDefault(); // 기본 동작 막기

		// 필요한 데이터 가져오기
		const sid = $('input[name="SVCID"]').val();

		$.ajax({
			url : 'ajax?key=main&methodName=setLike',
			type : 'POST',
			dataType : 'json',
			data : {
				sid : sid
			},
			success : function(res) {

				alert(res === 1 ? '좋아요가 등록되었습니다.' : '좋아요 등록에 실패했습니다.');
			},
			error : function(err) {

				console.log(err);
			}
		});
	});

	document
			.getElementById('information')
			.addEventListener(
					'click',
					function(e) {
						document.querySelector('.data_explain').innerHTML = "";
						const data = `${fes.DTLCONT}`;
						let formattedData = data.replace(/다\./g, '다.<br>');
						/* formattedData = formattedData.replace(/(\d)\./g,
								'<br>$1.'); */
						formattedData = formattedData.replace(
								/(\★|\※|\▣|\■|\▶|\□|\○|\❐|\ㅇ)/g, '<br>$1');

						document.querySelector('.data_explain').innerHTML = formattedData
								+ '<br><br>';
					});

	document.getElementById('maps').addEventListener('click', function(e) {
		const x = parseFloat('${fes.getX()}').toFixed(4);
		const y = parseFloat('${fes.getY()}').toFixed(4);
		// .data_explain 영역을 초기화
		document.querySelector('.data_explain').innerHTML = "";

		// 카카오맵 API 로드 후 지도 생성
		kakao.maps.load(function() {
			// 지도가 들어갈 HTML 요소 생성
			const mapContainer = document.createElement('div');
			mapContainer.style.width = '100%'; // 너비 조정
			mapContainer.style.height = '400px'; // 높이 조정
			document.querySelector('.data_explain').appendChild(mapContainer);

			// 지도의 중심좌표 설정 (여기서는 서울 시청 좌표 사용)
			const mapOption = {
				center : new kakao.maps.LatLng(y, x), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};
			// 지도 생성
			const map = new kakao.maps.Map(mapContainer, mapOption);

			// 마커 추가 (마커를 지도에 표시할 위치)
			const markerPosition = new kakao.maps.LatLng(y, x);

			// 마커 생성
			const marker = new kakao.maps.Marker({
				position : markerPosition
			});

			// 마커를 지도 위에 표시
			marker.setMap(map);
		});
	});

	document.getElementById('review').addEventListener('click',function(e) {
						let score = 0;
						let cnt = 0;
						document.querySelector('.data_explain').innerHTML = "";
						const sid = $('input[name="SVCID"]').val();
						$.ajax({
									url : 'ajax?key=main&methodName=selecReview',
									type : 'get',
									dataType : 'json',
									data : {sid : sid},
									success : function(res) {
										if (res && res.length > 0) {
											let str = '<div id=reviewsContainer><div id=reviews>';
											$.each(res,function(index,item) {
																score += item.SCORE;
																cnt = index;
																str += "<div class=rv_con>"
																		+ item.RV_CONTENT
																		+ "<span>"
																		+ "★".repeat(item.SCORE)
																		+ "☆".repeat(5 - item.SCORE)
																		+ "</span></div>";
															});
											str += "</div></div>";
											avg = score / (cnt + 1);
											str += '<br><div><h2>평점 : '
													+ avg
													+ '</h2></div>'
													+ '<div class=avg_con><div class="avg_range">0</div><div style="'
													+ 'font-size: 20px; background-color: #75DE27; height : 40px; width :'
													+ 100
													* (avg / 5)
													+ '%; ">'
													+ '</div><span style="position:absolute; left:83%;">MAX</span></div>'
											$('.data_explain').html(str);
										}
										else{
											$('.data_explain').html(
													"<div style='align-content: center; text-align:center;'><h1>NO DATA<br><sapn style='font-size:20px;'>아직 리뷰 참여한 사람이 없어요</span></h1></div>");
										}
									},
									error : function(err) {
										console.log(err);
									}
								});
					});
</script>

<!-- 차트js 라이브러리  -->
 <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- 차트 만들어논 js 파일-->
 <script type="text/javascript" src="${path}/super/festival/chart.js"></script>
  <!-- 부트스트랩 스타일(차트에도 필요) -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- 차트 데이터 뿌리기 -->
<script type="text/javascript">
	/* 리퀘스트 데이터 - 유저 */
	const userList = ${requestScope.chartUserList};
	/* 리퀘스트 데이터 - 리뷰쓴 유저 */
  	const reviewUserList = ${requestScope.reviewUserList};
	
	/* 캔버스엘리먼트 이름으로 찾기 */
	const getCanvas = function(canvasName){
		return document.getElementById(canvasName).getContext('2d');
	};
	/* 차트 Call ============*/
	//연령, 성별 통계
	ageGender(getCanvas('ageGender'),userList);
	//성별 비율
	genderRatio(getCanvas('genderRatio'),userList);
	//연령별 비율
	ageRatio(getCanvas('ageRatio'),userList);
	//성별별 평균 평점
	genderReviewAvg(getCanvas('genderReviewAvg'),reviewUserList);
	//연령별 평균 평점
	ageReviewAvg(getCanvas('ageReviewAvg'),reviewUserList);
	
</script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        // data-bs-theme 속성을 light로 강제 변경
        document.documentElement.setAttribute("data-bs-theme", "light");
    });
</script>


</html>

