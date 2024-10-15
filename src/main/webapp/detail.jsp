<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="UTF-8">
<jsp:include page="/common/header.jsp" />
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
	font-family: monospace;
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
	width: 30%;
	height: 100px;
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
	margin-left: 20px;
	margin-top: 10px;
	left: 10%;
	top: 10%;
	float: left;
	border: 1px solid blue;
	border-radius: 10px;
	box-shadow: 0px 10px 15px 0px #007BFF inset;
}

.explain_data_small div {
	font: bold;
	font-family: monospace;
	border-bottom: 1px black solid;
	font-size: 120%;
	top: 10%;
	margin-top: 10px;
	text-align: left;
	font-weight: bolder;
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
	border: 1px solid blue;
	border-radius: 10px;
	clear: both; /* float 해제 */
	margin-top: 30px; /* 여백 추가 */
}

.area2 div {
	font: bold;
	font-family: monospace;
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
						type="hidden" name="SVCID" value="${fes.SVCID}" />
						<input type = "hidden" name="SVCNM" value = "${fes.SVCNM}"/>
						<input type = "hidden" name="fes" value = "${fes}"/>
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
							/(\★|\※|\▣|\■|\▶|\□|\○|\❐ )/g, '<br>$1');

					document.querySelector('.data_explain').innerHTML = formattedData
							+ "<br><br>";
				</script>

			</div>
		</div>

	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<!-- <script src="js/scripts.js"></script> -->

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
								/(\★|\※|\▣|\■|\▶|\□|\○|\❐ )/g, '<br>$1');

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

	document.getElementById('review').addEventListener('click', function(e) {

	});
</script>




</html>
