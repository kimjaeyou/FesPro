<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../boardCSS/bootstrap.css">
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="../reservation/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="../common/header.jsp"></jsp:include>

<title>JSP 게시판 웹 사이트</title>
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
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="boardMain.jsp">메인</a></li>
				<li class="active"><a href="boardNoti.jsp">공지사항 게시판</a></li>
				<li class="active"><a href="boardFree.jsp">자유 게시판</a></li>
				<li class="active"><a href="boardQA.jsp">QA 게시판</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">게시글
							상세보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>글 번호</td>
						<td></td>
					</tr>
					<tr>
						<td>카테고리 번호</td>
						<td></td>
					</tr>
					<tr>
						<td>작성자 번호</td>
						<td></td>
					</tr>
					<tr>
						<td>제목</td>
						<td></td>
					</tr>
					<tr>
						<td>내용</td>
						<td></td>
					</tr>
					<tr>
						<td>호스트 번호</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<a href="../index.jsp" class="btn btn-primary">목록</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
