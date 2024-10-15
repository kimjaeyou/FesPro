<%@page import="wep.mvc.dto.UsersDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myPageCheck.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>관심정보 설정</title>
<link href="../css/My_styles.css" rel="stylesheet" />
<link href="../css/like.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<jsp:include page="../common/mySide.jsp" />
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h2 class="mt-4 text-center">관심정보 설정</h2>
				<br>
				<div class="card mb-4 search-card">
					<div class="d-flex align-items-center justify-content-between">
						<label for="searchInput" class="me-2">서비스명:</label> <input
							type="text" class="form-control me-2 large-input"
							id="searchInput" placeholder="검색어를 입력하세요.">
						<button class="btn btn-secondary text-white large-button"
							type="button">검색</button>
					</div>
				</div>

				<h5>
					<i class="fas fa-table me-1"></i> 지갑 <span id="rowCount"></span>
				</h5>
			</div>
		</main>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
</body>

</html>