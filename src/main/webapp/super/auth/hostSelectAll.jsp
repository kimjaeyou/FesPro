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
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	<style>
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
	$(".detailBtn").click(function(){
		//console.log("상세보기 버튼 클릭");
		const host_id = $(this).data("host_id");
		//console.log(svcid);
		window.location.href ="${path}/front?key=superAuth&methodName=hostDetail&host_id=" +host_id;
	});
});
</script>
</head>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">전체 주최자 조회</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">전체 주최자의 목록을 출력합니다</li>
			</ol>

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> 전체 주최자 테이블
				</div>
				<div class="card-body">

					<!-- 테이블 -->
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>주최자 고유번호</th>
								<th>주최자 아이디</th>
								<th>주최자 기업명</th>
								<th>주최자 비밀번호</th>
								<th>주최자 전화번호</th>
								<th>대표자 이름</th>
								<th style="font-weight: bold; background-color: #e0f7fa;">회원가입 승인여부</th>
								<th>가입자 이름</th>
								<th style="font-weight: bold; background-color: #e0f7fa;">밴 여부</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>주최자 고유번호</th>
								<th>주최자 아이디</th>
								<th>주최자 기업명</th>
								<th>주최자 비밀번호</th>
								<th>주최자 전화번호</th>
								<th>대표자 이름</th>
								<th style="font-weight: bold; background-color: #e0f7fa;">회원가입 승인여부</th>
								<th>가입자 이름</th>
								<th style="font-weight: bold; background-color: #e0f7fa;">밴 여부</th>
							</tr>
						</tfoot>
						<tbody>
							 <!-- 서버에서 전달된 DTO 데이터를 JSTL로 출력 -->
                        <c:forEach var="host" items="${hostList}">
                            <tr>
                                <td>${host.host_seq}</td>
                                <td><button class="detailBtn" data-host_id="${host.host_id}"/>${host.host_id}</td>
                                <td>${host.com_name}</td>
                                <td>${host.host_pw}</td>
                                <td>${host.host_tel}</td>
                                <td>${host.host_name}</td>
                                <td style="font-weight: bold; background-color: #e0f7fa;">${host.host_check}</td>
                                <td>${host.rep_name}</td>
                                <td style="font-weight: bold; background-color: #e0f7fa;">${host.host_ben_check}</td>
                            </tr>
                        </c:forEach>
						</tbody>
						
					</table>

				</div>
			</div>
		</div>
	<!-- 테이블 끝 -->
	<!-- 차트 -->
		<div class="row">
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
			</div>
		<!-- 차트 끝 -->
	
	</main>

</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
	crossorigin="anonymous"></script>
<script src="${path}/js/datatables-simple-demo.js"></script>
</body>
</html>
