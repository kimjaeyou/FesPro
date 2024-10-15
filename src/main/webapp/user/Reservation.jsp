<%@page import="wep.mvc.dto.UsersDTO"%>
<%@page import="wep.mvc.dto.ReservationDTO2"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="myPageCheck.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>나의 예약내역</title>
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<link href="${path}/css/Reservation.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="../common/myHeader.jsp" />
	<div id="layoutSidenav">
		<jsp:include page="../common/mySide.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h2 class="mt-4 text-center">나의 예약내역</h2>
					<br>
					<div class="card mb-4">
						<div class="card-body">
							<h5 id="notice">유의사항</h5>
							<ul>
								<li>예약 상세 정보와 진행 상태를 확인할 수 있습니다.</li>
								<li>예약을 취소하기 위해서는 R로 시작하는 예약번호를 클릭하시기 바랍니다.</li>
								<li>2024년 8월 5일부터 무료 서비스의 예약변경 시 이용인원, 이용자 정보 등은 변경이 가능합니다,
									그러나 이용날짜 및 이용회차는 변경 할 수 없습니다.(유료 서비스 변경 불가)</li>
								<li>추첨중, 심사중, 대기자 접수의 경우 관리자 승인 전까지 예약 접수 상태로 노출됩니다.</li>
								<li>유료 서비스의 경우 각 서비스 별 정책의 결제 시간 전까지 미 결제 시 예약이 자동 취소됩니다.</li>
								<li>무통장 입금 후 관리자 승인 전까지 입금 확인중 상태로 노출됩니다.</li>
								<li>예약 항목을 선택하시면 상세 화면을 볼 수 있습니다.</li>
							</ul>
						</div>
					</div>
					<div class="card mb-4 search-card">
						<div class="d-flex align-items-center justify-content-between">
							<div class="d-flex align-items-center me-3">
								<label for="startDate" class="me-2">신청일:</label> <input
									type="date" class="form-control me-2" id="startDate"
									placeholder="시작 날짜" style="width: 150px;"> <span
									class="me-2"> ~ </span> <input type="date"
									class="form-control me-2" id="endDate" placeholder="종료 날짜"
									style="width: 150px;">
							</div>
							<div class="d-flex align-items-center">
								<label for="searchInput" class="me-2">서비스명:</label> <input
									type="text" class="form-control me-2" id="searchInput"
									placeholder="검색어를 입력하세요" style="width: 200px;">
								
								<form method="post" action="${pageContext.request.contextPath}/front">
									<input type="hidden" name="key" value="mypage" /> 
									<input type="hidden" name="methodName" value="resSelect" />
									<input type="hidden" name="name" value="${re.svcnm}" />
									<button class="btn btn-secondary text-white" type="button">
										검색</button>
								</form>
								
							</div>
						</div>
					</div>
					<h5>
						<i class="fas fa-table me-1"></i> 예약내역 <span id="rowCount"></span>
					</h5>
					<table id="festable">
						<thead>
							<tr>
								<th>예약번호</th>
								<th>서비스명</th>
								<th>이용일자</th>
								<th>신청일</th>
								<th>이용요금</th>
								<th>예약현황</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
								<c:when test="${empty reservation}">
									<tr>
										<td colspan="6">
											<p align="center">
												<b><span style="font-size: 9pt;">예약정보가 없습니다.</span></b>
											</p>
										</td>
									</tr>
								</c:when>
								 <c:otherwise>
									<c:forEach items="${reservation}" var="re">
										<tr>
											<td><a href="${path}/front?key=&methodName=/${re.reserv_Seq}" class="no-underline1">${re.reserv_Seq}</a></td>
											<td><a href="${path}/front?key=&methodName=" class="no-underline2">${re.svcnm}</a></td>
											<td>${re.resv_Date} / ${re.svc_Time}차</td>
											<td>${re.svc_Date}</td>
											<td>${re.resv_Price}원</td>
											<td>${re.resv_Check}</td>
											<td>
											<form id="delete-form" method="post" action="${path}/front">
											<input type="hidden" name="key" value="mypage">
											<input type="hidden" name="methodName" value="resDelete">
											<input type="hidden" name="reserv_Seq" value="${re.reserv_Seq}">
											<button type="submit" class="delete-button">예약취소</button>
											</form>
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
</body>
</html>