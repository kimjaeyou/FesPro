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

<%-- <link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script> --%>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<!-- datatables -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.css"
	rel="stylesheet">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.datatables.net/v/bs5/dt-2.1.8/datatables.min.js"></script>

<script>
	$(function() {
		/* 테이블 생성 */
		$('#example').DataTable();
	
	/* 부모에게 이벤트를 위임해 렌더링 되지 않았던 버튼들에게도 기능을 넣음 */
		 $(document).on('click', '.btn.btn-primary', function() {
			//console.log("상세보기 버튼 클릭");
			const svcid = $(this).data("svcid");
			const state = $(this).data("state");
			//console.log(svcid);
			//행사에 대해 svcid와 행사승인상태를 실어서 보내줌
			console.log("state : " +state);
			window.location.href = "${path}/front?key=superfestival&methodName=dashWaitAcceptDetail&svcid="+ svcid +"&state=" +state;
		}); 
	});
</script>
</head>

<!-- 페이지 제목 -->
<h1 class="mt-4">문화행사 조회</h1>
<ol class="breadcrumb mb-4">
	<li class="breadcrumb-item active">모든 문화행사 목록을 출력하고 </li>
</ol>
<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 문화 행사 테이블
	</div>
	<div class="card-body">
		<!-- 테이블 시작 -->
		<table id="example" class="table table-striped" style="width: 100%">
			<thead>
				<tr>
					<th>서비스명</th>
					<!-- <th>서비스 아이디</th> -->
					<!-- 					<th>대분류명</th>
					<th>소분류명</th> -->
					<th>서비스상태</th>
					<!-- <th>결제방법</th> -->
					<!-- <th>장소명</th> -->
					<!-- <th>서비스대상</th> -->
					<!-- <th>장소 x좌표</th> -->
					<!-- <th>장소 y좌표</th> -->
					<!-- <th>서비스 개시 시작일시</th>
								<th>서비스 개시 종료일시</th>
								<th>접수 시작일시</th> -->
					<th>지역명</th>
					<!-- <th>이미지 경로</th>
								<th>상세 내용</th> -->
					<th>전화번호</th>
					<!-- <th>서비스 이용 시작시간</th>
								<th>서비스 이용 종료시간</th>
								<th>취소 기간 기준일까지</th>
								<th>취소 기간 기준정보</th> -->
					<th>등록신청 정보</th>
					<!-- <th>등록/수정 신청일</th> -->
					<!-- 	<th>최대 인원수</th> -->
					<!-- 	<th>가격</th>
					<th>주최자 sequence</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${festivalList}" var="festival">
					<tr>
						<td><button type="button" class="btn btn-primary" data-svcid="${festival.SVCID}" data-state="${festival.getFes_state()}" >${festival.SVCNM}</button></td>
						<!-- 버튼 클릭 이벤트 -> 서블릿 -> 상세페이지 -->
						<%-- <td>${festival.MAXCLASSNM}</td>
						<td>${festival.MINCLASSNM}</td> --%>
						<td>${festival.SVCSTATNM}</td>
						<%-- <td>${festival.SVCNM}</td> --%>
						<%-- <td>${festival.PAYATNM}</td> --%>
						<%-- <td>${festival.PLACENM}</td> --%>
						<%-- <td>${festival.USETGTINFO}</td> --%>
						<%-- <td>${festival.getX()}</td>
									<td>${festival.getY()}</td> --%>
						<%-- 	<td>${festival.SVCOPNBGNDT}</td>
									<td>${festival.SVCOPNENDDT}</td>
									<td>${festival.RCPTBGNDT}</td> --%>
						<td>${festival.AREANM}</td>
						<%-- <td>${festival.IMGURL}</td> --%>
						<%-- <td>${festival.getDTLCONT()}</td> --%>
						<td>${festival.TELNO}</td>
						<%-- <td>${festival.getV_MAX()}</td>
						<td>${festival.getV_MIN()}</td>
						<td>${festival.REVSTDDAY}</td>
						<td>${festival.REVSTDDAYNM}</td> --%>
						<!-- 0=승인대기 / 1=승인완료 / 2=승인대기 /3=비활성화-->
						<td><c:choose>
								<c:when test="${festival.getFes_state() == 0}"><span class="badge rounded-pill text-bg-warning">승인대기</span></c:when>
								<c:when test="${festival.getFes_state() == 1}"><span class="badge rounded-pill text-bg-success">승인완료</span></c:when>
								<c:when test="${festival.getFes_state() == 2}"><span class="badge rounded-pill text-bg-warning">수정대기</span></c:when>
								<c:when test="${festival.getFes_state() == 3}"><span class="badge rounded-pill text-bg-danger">비활성화</span></c:when>
								<c:otherwise>잘못된 상태</c:otherwise>
							</c:choose></td>
						<%-- <td>${festival.getUpdate_date()}</td> --%>
						<%-- <td>${festival.MAXNUM}</td> --%>
						<%-- <td>${festival.PRICE}</td> --%>
						<%-- <td>${festival.getHost_seq()}</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 테이블 끝 -->
	</div>
</div>

</body>
</html>
