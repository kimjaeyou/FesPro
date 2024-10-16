<%@page import="wep.mvc.dto.ReviewDTO2"%>
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
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<link href="${path}/css/review.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
		<jsp:include page="../common/mySide.jsp" />
		<div id="layoutSidenav_content">
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
    						<c:when test="${empty requestScope.review}">
	   						<tr>
					        <td colspan="6">
            				<p align="center"><b><span style="font-size:9pt;">작성한 댓글이 없습니다.</span></b></p>
        					</td>
    						</tr>
    						</c:when>
    						
    						<c:otherwise>
							<c:forEach items="${review}" var="view">
							<tr>
								<td>${view.review_SEQ}</td>
								<td>${view.score}점</td>
								<td>${view.svcnm}</td>
								<td>${view.rv_Content}</td>
								<td>${view.sysdate}</td>
								<td>
								<form id="delete-form" method="post" action="${path}/front">
										<input type="hidden" name="key" value="mypage"> 
										<input type="hidden" name="methodName" value="reviewDelete">
										<input type="hidden" name="review_SEQ" value="${view.review_SEQ}">
										<button type="submit" class="delete-button">삭제</button>
									</form>
								</td>
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