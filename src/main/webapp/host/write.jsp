<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="../css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script>
	function checkValid() {

		var f = window.document.writeForm;

		if (!f.MAXCLASSNM.checked) {
			alert("대분류명을 체크해 주세요");
			return false;
		}

		if (f.MINCLASSNM.value == "") {
			alert("소분류명을 체크해 주세요");
			return false;
		}

		if (f.SVCSTATNM.value == "") {
			alert("서비스상태를 체크해 주세요");
			return false;
		}

		if (f.SVCNM.value == "") {
			alert("서비스명을 입력해 주세요");
			return false;
		}

		if (f.PAYATNM.value == "") {
			alert("결제방법을 체크해 주세요");
			return false;
		}

		if (f.USETGTINFO.value == "") {
			alert("서비스대상을 체크해 주세요");
			return false;
		}

		if (f.SVCOPNBGNDT.value == "") {
			alert("서비스개시시작일시를 입력해 주세요");
			return false;
		}

		if (f.SVCOPNENDDT.value == "") {
			alert("서비스개시종료일시를 입력해 주세요");
			return false;
		}

		if (f.RCPTBGNDT.value == "") {
			alert("접수시작일시를 입력해 주세요");
			return false;
		}

		if (f.RCPTENDDT.value == "") {
			alert("접수종료일시를 입력해 주세요");
			return false;
		}

		if (f.DTLCONT.value == "") {
			alert("상세내용을 입력해 주세요");
			return false;
		}

		if (f.TELNO.value == "") {
			alert("전화번호를 입력해 주세요");
			return false;
		}

		if (f.V_MIN.value == "") {
			alert("서비스이용시작시간을 입력해 주세요");
			return false;
		}

		if (f.V_MAX.value == "") {
			alert("서비스이용종료시간을 입력해 주세요");
			return false;
		}

		if (f.REVSTDDAYNM.value == "") {
			alert("취소기간기준정보를 선택해 주세요");
			return false;
		}

		if (f.REVSTDDAY.value == "") {
			alert("취소기간 기준일까지를 입력해 주세요");
			return false;
		}

		if (f.PRICE.value == "") {
			alert("가격을 입력해 주세요");
			return false;
		}

		if (f.IMGURL.value == "") {
			alert("서비스 포스터 또는 이미지를 첨부해 주세요");
			return false;
		}

		if (f.PLACENM.value == "") {
			alert("장소명을 입력해 주세요");
			return false;
		}

		if (f.X.value == "") {
			alert("지도에서 장소를 선택해 주세요");
			return false;
		}

		if (f.Y.value == "") {
			alert("지도에서 장소를 선택해 주세요");
			return false;
		}

		if (f.AREANM.value == "") {
			alert("지역명(XX구)을 입력해주세요");
			return false;
		}

		if (!document.querySelector('input[name="tag_content"]:checked')) {
			alert("태그를 골라주세요");
			return false;
		}

		return true;

	}
</script>
</head>
<body>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-white"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">주최자</div>
						<a class="nav-link" href="${path}/front?key=fes&methodName=select">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 나의 서비스 내역
						</a> <a class="nav-link"
							href="${path}/front?key=fes&methodName=myPage2">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 회원 정보 변경
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">나의 서비스 등록</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">서비스 등록 신청하기</li>
					</ol>

					<div class="container">
						<div class="row">

							<form name="writeForm" method="post" action="${path}/front"
								onSubmit='return checkValid()' enctype="multipart/form-data">
								<input type="hidden" name="key" value="fes" /> <input
									type="hidden" name="methodName" value="insert" />
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<thead>
										<tr>
											<th style="background-color: #eeeeee; text-align: center;"
												colspan="2">서비스 등록</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><p align="center">
													<span>대분류명</span>
												</p></td>
											<td><p align="center">
													<span><label><input type="checkbox" checked
															name="MAXCLASSNM" value="culture">문화체험</label></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>소분류명</span>
												</p></td>
											<td><p align="center">
													<span> <label><input type="radio"
															name="MINCLASSNM" value="education">교육체험</label> <label><input
															type="radio" name="MINCLASSNM" value="farm">농장체험</label>
														<label><input type="radio" name="MINCLASSNM"
															value="cultureFes">문화행사</label> <label><input
															type="radio" name="MINCLASSNM" value="exhibition">전시/관람</label>
														<label><input type="radio" name="MINCLASSNM"
															value="valunteer">단체봉사</label> <label><input
															type="radio" name="MINCLASSNM" value="park">공원탐방</label>
														<label><input type="radio" name="MINCLASSNM"
															value="kids">서울형키즈카페</label> <label><input
															type="radio" name="MINCLASSNM" value="forest">산림여가</label>
													</span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스상태</span>
												</p></td>
											<td><p align="center">
													<span> <label><input type="radio"
															name="SVCSTATNM" value="info">안내중</label> <label><input
															type="radio" name="SVCSTATNM" value="process">접수중</label>
														<label><input type="radio" name="SVCSTATNM"
															value="processEnd">접수종료</label> <label><input
															type="radio" name="SVCSTATNM" value="reservationEnd">예약마감</label>
														<label><input type="radio" name="SVCSTATNM"
															value="reservationStop">예약일시중지</label>
													</span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스명</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="text" name="SVCNM" size="100"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>결제방법</span>
												</p></td>
											<td><p align="center">
													<span> <label><input type="radio"
															name="PAYATNM" value="free">무료</label> <label><input
															type="radio" name="PAYATNM" value="notFree">유료</label>
													</span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스대상</span>
												</p></td>
											<td><p align="center">
													<span> <label><input type="radio"
															name="PAYATNM" value="kindergarten">유아</label> <label><input
															type="radio" name="PAYATNM" value="element">초등학생</label>
														<label><input type="radio" name="PAYATNM"
															value="middle">중학생</label> <label><input
															type="radio" name="PAYATNM" value="high">고등학생</label> <label><input
															type="radio" name="PAYATNM" value="adult">성인</label>
													</span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스 개시 시작일시</span>
												</p></td>
											<td><p align="center">
													<span><label><input type="date"
															name="SVCOPNBGNDT"></label></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스 개시 종료일시</span>
												</p></td>
											<td><p align="center">
													<span><label><input type="date"
															name="SVCOPNENDDT"></label></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>접수 시작일시</span>
												</p></td>
											<td><p align="center">
													<span><label><input type="date"
															name="RCPTBGNDT"></label></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>접수 종료일시</span>
												</p></td>
											<td><p align="center">
													<span><label><input type="date"
															name="RCPTENDDT"></label></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>상세내용</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><textarea name="DTLCONT" cols="50" rows="10"></textarea></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>전화번호</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="text" name="TELNO" size="100"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스이용시작시간</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="time" name="V_MIN"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>서비스이용종료시간</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="time" name="V_MAX"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>취소기간기준정보</span>
												</p></td>
											<td><p align="center">
													<span> <label><input type="radio"
															name="REVSTDDAYNM" value="processEndDay">접수종료일</label> <label><input
															type="radio" name="REVSTDDAYNM" value="useDay">이용일</label>
														<label><input type="radio" name="REVSTDDAYNM"
															value="useStartDay">이용기간시작일</label>
													</span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>취소기간 기준일까지</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="text" name="REVSTDDAY" size="100"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>가격</span>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="text" name="PRICE" size="100"></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<b><span>서비스 포스터/이미지</span></b>
												</p></td>
											<td width="450" height="20"><b><span
													style="font-size: 9pt;"> <input type="file"
														name="IMGURL" maxlength="60" size="40"></span></b></td>
										</tr>
										<!-- 지도API 활용 예정: 장소명o, 장소X좌표,장소Y좌표, 지역명 -->
										<tr>
											<td><p align="center">
													<b><span>장소명</span></b>
												</p></td>
											<td width="1000"><p align="center">
													<span><input type="text" id="placenm" name="PLACENM"
														size="100" onkeyup="getPLACENMValue()"></span>
												</p> <script type="text/javascript"
													src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13ac0c7b043360f46d8f5ed642147a6a&libraries=services&onload=false"></script>
												<div id="map" style="width: 100%; height: 350px;"></div> <label>위도:
													<input type="text" id="latitude" name="X" readonly>
											</label> <label>경도: <input type="text" id="longitude"
													name="Y" readonly></label> <input type="text" name="AREANM"
												size="15" placeholder="XX구 입력해 주세요."> </span>
											</p></td>
										</tr>
										<tr>

											<td><p align="center">
													<b><span>분류태그</span></b>
												</p></td>
											<td><p align="center">
													<span> <label><input type="checkbox"
															name="tag_content" value="가족">가족</label> <label><input
															type="checkbox" name="tag_content" value="효도">효도</label>
														<label><input type="checkbox" name="tag_content"
															value="연인">연인</label> <label><input
															type="checkbox" name="tag_content" value="학습">학습</label>
														<label><input type="checkbox" name="tag_content"
															value="건강">건강</label> <label><input
															type="checkbox" name="tag_content" value="키즈">키즈</label></span>
												</p></td>
										</tr>
										<tr>

											<td width="450" height="20" colspan="2" align="center"><b><span
													style="font-size: 9pt;"><input type=submit value=글쓰기>
														<input type=reset value=다시쓰기></span></b></td>
										</tr>
									</tbody>
								</table>

							</form>


						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script>
		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places();

		// 키워드로 장소를 검색합니다
		document.getElementById('placenm').addEventListener('keyup',
				function() {
					var keyword = getPLACENMValue();
					ps.keywordSearch(keyword, placesSearchCB);
				})

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				var bounds = new kakao.maps.LatLngBounds();

				for (var i = 0; i < data.length; i++) {
					displayMarker(data[i]);
					bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
				}

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
				map.setBounds(bounds);
			}
		}

		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {

			// 마커를 생성하고 지도에 표시합니다
			var marker = new kakao.maps.Marker({
				map : map,
				position : new kakao.maps.LatLng(place.y, place.x)
			});

			// 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function(mouseEvent) {
				// 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
				infowindow
						.setContent('<div style="padding:5px;font-size:12px;">'
								+ place.place_name + '</div>');
				infowindow.open(map, marker);

				//마커를 클릭하면 x좌표, y좌표, 지역명을 가져온다
				// 클릭한 위도, 경도 정보를 가져옵니다 
				var latlng = marker.getPosition();

				// 마커 위치를 클릭한 위치로 옮깁니다
				marker.setPosition(latlng);

				var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
				message += '경도는 ' + latlng.getLng() + ' 입니다';

				console.log(message);

				document.getElementById('latitude').value = latlng.getLat();
				document.getElementById('longitude').value = latlng.getLng();
			});
		}

		// 키보드를 뗄때마다 값을 가져오기
		function getPLACENMValue() {
			const inputPLACENMValue = document.getElementById('placenm').value;
			//console.log(inputPLACENMValue);
			return inputPLACENMValue;
		}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/My_scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>
