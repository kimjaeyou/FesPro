<%@page import="wep.mvc.dto.UsersDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="myPageCheck.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>나의 이용후기</title>
<link href="../css/My_styles.css" rel="stylesheet" />
<link href="../css/review.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="../common/myHeader.jsp" />
	<div id="layoutSidenav">
		<jsp:include page="../common/mySide.jsp" />
		<div id="layoutSidenav_content">
			<!-- 메인 페이지-->
			<main>
				<div class="container-fluid px-4">

					<h2 class="mt-4 text-center">
						나의 이용후기
					</h2>
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
						<i class="fas fa-table me-1"></i> 후기 <span id="rowCount"></span>
					</h5>

					<table id="festable" class="large-table">
						<thead>
							<tr>
								<th>번호</th>
								<th>점수</th>
								<th>서비스명</th>
								<th>내용</th>
								<th>작성일자</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						 <c:choose>
    						<c:when test="${empty requestScope.like}">
	   						<tr>
					        <td colspan="5">
            				<p align="center"><b><span style="font-size:9pt;">작성한 댓글이 없습니다.</span></b></p>
        					</td>
    						</tr>
    						</c:when>
    						
    						<c:otherwise>
							<c:forEach items="${review}" var="review">
							<tr>
								<td>${review.REVIEW_SEQ}</td>
								<td>${review.SCORE}</td>
								<td>${review.서비스명}</td>
								<td>${review.RV_CONTENT}</td>
								<td>${review.작성일자}</td>
								<td><button>삭제</button></td>
							</tr>
							</c:forEach>
							</c:otherwise>
							</c:choose>
						</tbody>
					</table>
			</main>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
</body>

</html>