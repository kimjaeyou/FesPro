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
	height: 90%;
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
	margin-top: 10px;
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
	height: 100%;
	left: 5%;
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
				<form action="front?key=reservation&methodName=revMove">
					<input type="hidden" name="key" value="reservation" /> <input
						type="hidden" name="methodName" value="revMove" /> <input
						type="hidden" name="SVCID" value="${fes.SVCID}" />
						<input type = "hidden" name="SVCNM" value = "${fes.SVCNM}"/>
					<button class="btn btn-primary" id="reservation">예약하기</button>
					<button class="btn btn-primary" id="like">좋아요</button>
				</form>

			</div>

		</div>

		<div class="area2">
			<div class="areaControl">
				<button class="conButton">이용 안내</button>
				<button class="conButton">지도</button>
				<button class="conButton">리뷰</button>
			</div>
			<hr>
			<div class="data_explain">
				<script type="text/javascript">
					const data = `${fes.DTLCONT}`;
					let formattedData = data.replace(/다\./g, '다.<br>');
					formattedData = formattedData.replace(/(\d)\./g, '<br>$1.');
					formattedData = formattedData.replace(/(\★|\※)/g, '<br>$1');

					document.querySelector('.data_explain').innerHTML = formattedData;
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

<script type="text/javascript">
	document.getElementById('like').addEventListener('click', function(e) {
		document.querySelector('input[name="key"]').value = 'main';
		document.querySelector('input[name="methodName"]').value = 'setLike';
	});
</script>

</html>
