<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../common/header.jsp"></jsp:include>

<title>공지사항 게시판</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #000000">
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
						<td>번호 출력란</td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td>카테고리명 출력란</td>
					</tr>
					<tr>
						<td>작성자 아이디</td>
						<td>작성자 아이디 출력란</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>제목출력란</td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td>내용 출력란</td>
					</tr>

				</tbody>
			</table>
			<h3>${list}</h3>
			<a href="${path}/front?key=board&methodName=read" class="btn btn-primary">목록</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
