<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale"="1">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="../reservation/assets/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
				<li class="active"><a href="${path}/front?key=board&=methodName=readNoti">공지사항 게시판</a></li>
				<li class="active"><a href="${path}/front?key=board&=methodName=readQA">QA 게시판</a></li>
				<li class="active"><a href="${path}/front?key=board&=methodName=readFree">자유 게시판</a></li>
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
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
					
				</thead>
				<h2>여기서 출력중</h2>
				<c:forEach var="post" items="${noti}">
					<tr>
						<td>${post.boardSeq}</td>
						<td>${post.sub}</td>
						<td>${post.categorySeq}</td>
					</tr>
				</c:forEach>
			</table>



			<a href="${path}/front?key=board&methodName=write"
				class="btn btn-primary pull-right">글쓰기</a>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>