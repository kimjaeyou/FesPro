<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checkValid(){
	
}
</script>
</head>
<body>
<form name="writeForm" method="post" action="${path}/front" onSubmit='return checkValid()' enctype="multipart/form-data">
	<input type="hidden" name="key" value="fes" />
	<input type="hidden" name="methodName" value = "insert" /> 
	<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
		<thead>
    		<tr>
 				<th style="background-color: #eeeeee; text-align: center;" colspan="2">서비스 등록</th>
       		</tr>
    	</thead>
    	<tbody>
        	<tr>
        		<td><p align="center"><span>대분류명</span></p></td>
        		<td><p align="center"><span><label><input type="checkbox" checked name="MAXCLASSNM" value="culture">문화체험</label></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>소분류명</span></p></td>
        		<td><p align="center"><span>
        			<label><input type="radio" name="MINCLASSNM" value="education">교육체험</label>
        			<label><input type="radio" name="MINCLASSNM" value="farm">농장체험</label>
        			<label><input type="radio" name="MINCLASSNM" value="cultureFes">문화행사</label>
        			<label><input type="radio" name="MINCLASSNM" value="exhibition">전시/관람</label>
        			<label><input type="radio" name="MINCLASSNM" value="valunteer">단체봉사</label>
        			<label><input type="radio" name="MINCLASSNM" value="park">공원탐방</label>
        			<label><input type="radio" name="MINCLASSNM" value="kids">서울형키즈카페</label>
        			<label><input type="radio" name="MINCLASSNM" value="forest">산림여가</label>
        		</span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스상태</span></p></td>
        		<td><p align="center"><span>
        			<label><input type="radio" name="SVCSTATNM" value="info">안내중</label>
        			<label><input type="radio" name="SVCSTATNM" value="process">접수중</label>
        			<label><input type="radio" name="SVCSTATNM" value="processEnd">접수종료</label>
        			<label><input type="radio" name="SVCSTATNM" value="reservationEnd">예약마감</label>
        			<label><input type="radio" name="SVCSTATNM" value="reservationStop">예약일시중지</label>
        		</span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스명</span></p></td>
        		<td width="1000"><p align="center"><span><input type="text" name="SVCNM" size="100"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>결제방법</span></p></td>
        		<td><p align="center"><span>
        			<label><input type="radio" name="PAYATNM" value="free">무료</label>
        			<label><input type="radio" name="PAYATNM" value="notFree">유료</label>
        		</span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스대상</span></p></td>
        		<td><p align="center"><span>
        			<label><input type="radio" name="PAYATNM" value="kindergarten">유아</label>
        			<label><input type="radio" name="PAYATNM" value="element">초등학생</label>
        			<label><input type="radio" name="PAYATNM" value="middle">중학생</label>
        			<label><input type="radio" name="PAYATNM" value="high">고등학생</label>
        			<label><input type="radio" name="PAYATNM" value="adult">성인</label>
        		</span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스 개시 시작일시</span></p></td>
        		<td><p align="center"><span><label><input type="date" name="SVCOPNBGNDT"></label></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스 개시 종료일시</span></p></td>
        		<td><p align="center"><span><label><input type="date" name="SVCOPNENDDT"></label></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>접수 시작일시</span></p></td>
        		<td><p align="center"><span><label><input type="date" name="RCPTBGNDT"></label></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>접수 종료일시</span></p></td>
        		<td><p align="center"><span><label><input type="date" name="RCPTENDDT"></label></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>상세내용</span></p></td>
        		<td width="1000"><p align="center"><span><textarea name="DTLCONT" cols="50" rows="10"></textarea></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>전화번호</span></p></td>
        		<td width="1000"><p align="center"><span><input type="text" name="TELNO" size="100"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스이용시작시간</span></p></td>
        		<td width="1000"><p align="center"><span><input type="time" name="V_MIN"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>서비스이용종료시간</span></p></td>
        		<td width="1000"><p align="center"><span><input type="time" name="V_MAX"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>취소기간기준정보</span></p></td>
        		<td><p align="center"><span>
        			<label><input type="radio" name="REVSTDDAYNM" value="processEndDay">접수종료일</label>
        			<label><input type="radio" name="REVSTDDAYNM" value="useDay">이용일</label>
        			<label><input type="radio" name="REVSTDDAYNM" value="useStartDay">이용기간시작일</label>
        		</span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>취소기간 기준일까지</span></p></td>
        		<td width="1000"><p align="center"><span><input type="text" name="REVSTDDAY" size="100"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><span>가격</span></p></td>
        		<td width="1000"><p align="center"><span><input type="text" name="PRICE" size="100"></span></p></td>
        	</tr>
        	<tr>
        		<td><p align="center"><b><span>서비스 포스터/이미지</span></b></p></td>
        		<td width="450" height="20"><b><span style="font-size:9pt;">
        		<input type="file" name="IMGURL" maxlength="60" size="40"></span></b></td>
    		</tr>
        	<!-- 지도API 활용 예정: 장소명o, 장소X좌표,장소Y좌표, 지역명 -->
        	<tr>
        		<td><p align="center"><b><span>장소명</span></b></p></td>
        		<td width="1000"><p align="center"><span><input type="text" id="placenm" name="PLACENM" size="100" onkeyup="getPLACENMValue()"></span></p>
        		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13ac0c7b043360f46d8f5ed642147a6a&libraries=services"></script>
        		<div id="map" style="width:100%;height:350px;"></div>
        		</td>
        	</tr>
        	<tr>
        		<td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=글쓰기> 
        		<input type=reset value=다시쓰기></span></b></td>
    		</tr>
    	</tbody>
	</table>

<script>

// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

// 키워드로 장소를 검색합니다
document.getElementById('placenm').addEventListener('keyup', function(){
	var keyword=getPLACENMValue();
	ps.keywordSearch(keyword, placesSearchCB); 
})

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
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
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function(mouseEvent) {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
        
        //마커를 클릭하면 x좌표, y좌표, 지역명을 가져온다
     	// 클릭한 위도, 경도 정보를 가져옵니다 
        var latlng = mouseEvent.latLng; 
        
        // 마커 위치를 클릭한 위치로 옮깁니다
        marker.setPosition(latlng);
        
        var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
        message += '경도는 ' + latlng.getLng() + ' 입니다';
        
        var resultDiv = document.getElementById('clickLatlng'); 
        resultDiv.innerHTML = message;
        
        console.log(message);
    });
}

// 키보드를 뗄때마다 값을 가져오기
function getPLACENMValue(){
	const inputPLACENMValue = document.getElementById('placenm').value;
	//console.log(inputPLACENMValue);
	return inputPLACENMValue;
}

</script>
<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js"></script>
<script type="text/javascript">
kakao.maps.load(function() {
    // v3가 모두 로드된 후, 이 콜백 함수가 실행됩니다.
    var map = new kakao.maps.Map(node, options);
});
</script>
</body>
</html>