<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="canonical"href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="${pageContext.request.contextPath}/reservation/assets/dist/css/bootstrap.min.css"rel="stylesheet">
<jsp:include page="../common/header.jsp"></jsp:include>

<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
a, a:hover {
	color: #000000;
	text-decoration: none;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${path}/front?key=board&methodName=readNoti">공지사항 게시판</a></li>
				<li class="active"><a
					href="${path}/front?key=board&methodName=readQA">QA 게시판</a></li>
				<li class="active"><a
					href="${path}/front?key=board&methodName=readFree">자유 게시판</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach var="post" items="${noti}">
						
						<tr>
							<td>${post.boardSeq}</td>
							<td><a href="${path}/front?key=board&methodName=select">${post.sub}</td>
							<td><c:choose>
									<c:when test="${not empty post.userSeq}">
                                    ${post.userSeq}
                                </c:when>
									<c:when test="${not empty post.hostSeq}">
                                    ${post.hostSeq}
                                </c:when>
								</c:choose></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			<a href="${path}/front?key=board&methodName=write" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
