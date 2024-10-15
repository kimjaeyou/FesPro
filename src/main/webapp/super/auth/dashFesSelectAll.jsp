<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <jsp:include page="/common/header.jsp"/> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
$(function(){
	$(".detailBtn").click(function(){
		//console.log("상세보기 버튼 클릭");
		const svcid = $(this).data("svcid");
		//console.log(svcid);
		window.location.href ="${path}/front?key=superfestival&methodName=dashFesDetail&svcid=" +svcid;
	});
});
</script>

</head>

	<main>
	<!-- 페이지 제목 -->
		<div class="container-fluid px-4">
			<h1 class="mt-4">전체 문화행사 조회</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">전체 문화행사의 목록을 출력합니다</li>
			</ol>
	<!-- 테이블 -->
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> 문화 행사 테이블
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>서비스 아이디</th>
								<th>대분류명</th>
								<th>소분류명</th>
								<th>서비스상태</th>
								<th>서비스명</th>
								<th>결제방법</th>
								<th>장소명</th>
								<th>서비스대상</th>
								<th>장소 x좌표</th>
								<th>장소 y좌표</th>
								<th>서비스 개시 시작일시</th>
								<th>서비스 개시 종료일시</th>
								<th>접수 시작일시</th>
								<th>지역명</th>
								<th>이미지 경로</th>
								<th>상세 내용</th>
								<th>전화번호</th>
								<th>서비스 이용 시작시간</th>
								<th>서비스 이용 종료시간</th>
								<th>취소 기간 기준일까지</th>
								<th>취소 기간 기준정보</th>
								<th>등록신청 정보 (승인전, 승인완료 등)</th>
								<th>등록신청/수정신청 일시</th>
								<th>최대 인원수</th>
								<th>가격</th>
								<th>주최자 sequence</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>서비스 아이디</th>
								<th>대분류명</th>
								<th>소분류명</th>
								<th>서비스상태</th>
								<th>서비스명</th>
								<th>결제방법</th>
								<th>장소명</th>
								<th>서비스대상</th>
								<th>장소 x좌표</th>
								<th>장소 y좌표</th>
								<th>서비스 개시 시작일시</th>
								<th>서비스 개시 종료일시</th>
								<th>접수 시작일시</th>
								<th>지역명</th>
								<th>이미지 경로</th>
								<th>상세 내용</th>
								<th>전화번호</th>
								<th>서비스 이용 시작시간</th>
								<th>서비스 이용 종료시간</th>
								<th>취소 기간 기준일까지</th>
								<th>취소 기간 기준정보</th>
								<th>등록신청 정보 (승인전, 승인완료 등)</th>
								<th>등록신청/수정신청 일시</th>
								<th>최대 인원수</th>
								<th>가격</th>
								<th>주최자 sequence</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${festivalList}" var="festival">
								<tr>
									<td><button class="detailBtn" data-svcid="${festival.SVCID}"/>${festival.SVCID}</td> <!-- 버튼 클릭 이벤트 -> 서블릿 -> 상세페이지 -->
									<td>${festival.MAXCLASSNM}</td>
									<td>${festival.MINCLASSNM}</td>
									<td>${festival.SVCSTATNM}</td>
									<td>${festival.SVCNM}</td>
									<td>${festival.PAYATNM}</td>
									<td>${festival.PLACENM}</td>
									<td>${festival.USETGTINFO}</td>
									<td>${festival.getX()}</td>
									<td>${festival.getY()}</td>
									<td>${festival.SVCOPNBGNDT}</td>
									<td>${festival.SVCOPNENDDT}</td>
									<td>${festival.RCPTBGNDT}</td>
									<td>${festival.AREANM}</td>
									<td>${festival.IMGURL}</td>
									<td>${festival.getDTLCONT()}</td>
									<td>${festival.TELNO}</td>
									<td>${festival.getV_MAX()}</td>
									<td>${festival.getV_MIN()}</td>
									<td>${festival.REVSTDDAY}</td>
									<td>${festival.REVSTDDAYNM}</td>
									<td>${festival.getFes_state()}</td>
									<td>${festival.getUpdate_date()}</td>
									<td>${festival.MAXNUM}</td>
									<td>${festival.PRICE}</td>
									<td>${festival.getHost_seq()}</td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
	<!-- 테이블 끝 -->
	<!-- 차트 -->
		<%-- <div class="row">
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> Area Chart Example
					</div>
					<div class="card-body">
						<canvas id="myAreaChart" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> Bar Chart Example
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="100%" height="40"></canvas>
					</div>
				</div>
			</div> --%>
	<!-- 차트 끝 -->
		</main>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
	crossorigin="anonymous"></script>
<!-- 부트스트랩 테이블 라이브러리 -->
<script src="${path}/js/datatables-simple-demo.js"></script>
</body>
</html>
