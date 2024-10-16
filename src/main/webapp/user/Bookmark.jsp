<%@page import="wep.mvc.dto.UsersDTO"%>
<%@page import="wep.mvc.dto.FesDTO"%>
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
<title>즐겨찾기 목록</title>
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<link href="${path}/css/Bookmark.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
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
						<i class="fas fa-table me-1"></i> <span id="rowCount">목록</span>
					</h5>
					<table id="festable" class="large-table">
						<thead>
							<tr>
								<th>서비스번호</th>
								<th>서비스명</th>
								<th>장소명</th>
								<th>접수기간</th>
								<th>이용기간</th>
								<th>신청기간</th>
								<th>이용요금</th>
								<th>접수상태</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						 <c:choose>
    						<c:when test="${empty requestScope.like}">
	   						<tr>
					        <td colspan="5">
            				<p align="center"><b><span style="font-size:9pt;">즐겨찾기 목록이 없습니다.</span></b></p>
        					</td>
    						</tr>
    						</c:when>
							 <c:otherwise>
							<c:forEach items="${like}" var="likes">
							<tr>
								<td><a href="">${likes.SVCID}</a></td>
								<td>${likes.SVCNM}</td>
								<td>${likes.PLACENM}</td>
								<td>${likes.RCPTBGNDT} ~ ${likes.RCPTENDDT}</td>
								<td>${likes.SVCOPNBGNDT} ~ ${likes.SVCOPNENDDT}</td>
								<td>${likes.v_MAX} ~ ${likes.v_MIN}</td>
								<td>${likes.PRICE}원</td>
								<td>${likes.SVCSTATNM}</td>
								<td>
									<form id="delete-form" method="post" action="${path}/front?key=mypage&methodName=likeSelectAll">
										<input type="hidden" name="key" value="mypage"> 
										<input type="hidden" name="methodName" value="reviewDelete">
										<input type="hidden" name="SVCID" value="${likes.SVCID}">
										<button type="submit" class="delete-button">삭제</button>
									</form>
								<td>
								</tr>
							</c:forEach>
							</c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
</body>

</html>