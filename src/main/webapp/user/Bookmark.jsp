<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>즐겨찾기 목록</title>
<link href="../css/My_styles.css" rel="stylesheet" />
<link href="../css/Bookmark.css" rel="stylesheet" />
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
					<h2 class="mt-4 text-center">즐겨찾기 목록</h2>
					<br>
					<div class="card mb-4 search-card">
						<div class="d-flex align-items-center justify-content-between">
							<label for="searchInput" class="me-2">서비스명:</label> <input
								type="text" class="form-control me-2 large-input"
								id="searchInput" placeholder="검색어를 입력하세요">
							<button class="btn btn-secondary text-white large-button"
								type="button">검색</button>
						</div>
					</div>

					<h5>
						<i class="fas fa-table me-1"></i> 목록 <span id="rowCount"></span>
					</h5>

					<table id="festable" class="large-table">
						<thead>
							<tr>
								<th>서비스명</th>
								<th>장소명</th>
								<th>접수기간 / 이용기간</th>
								<th>이용요금</th>
								<th>접수상태</th>
								<th>신청방법</th>
								<th>예약방법</th>
								<th>취소</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><a href=""></a></td>
								<td></a></td>
								<td></a></td>
								<td></a></td>
								<td></a></td>
								<td></a></td>
								<td></a></td>
								<td><button>취소</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</main>
			<!-- 메인 페이지 끝 -->

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
</body>

</html>