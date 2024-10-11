<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="wep.mvc.dto.BoardDTO"%>
<%@ page import="wep.mvc.dao.BoardDAOImpl"%>
<%@ page import="wep.mvc.dao.BoardDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../BoardCSS/bootstrap.css">
<link rel="stylesheet" href="../BoardCSS/custom.css">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
	// 세션에서 userID 가져오기
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}

	// userSeq 파라미터 처리
	int userSeq = 0;
	if (request.getParameter("userSeq") != null) {
		try {
			userSeq = Integer.parseInt(request.getParameter("userSeq"));
		} catch (NumberFormatException e) {
			// 파라미터가 숫자가 아닌 경우
			userSeq = 0;
		}
	}

	// 데이터베이스에서 해당 글 정보 가져오기
	BoardDAO boardDAO = new BoardDAOImpl();
	BoardDTO bDTO = boardDAO.select(userSeq);

	// 게시글이 존재하지 않는 경우 처리
	if (bDTO == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 글입니다.')");
		script.println("location.href = 'boardMain.jsp';");
		script.println("</script>");
		return;
	}
	%>

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
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
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
						<td><%=bDTO.getBoardSeq()%></td>
					</tr>
					<tr>
						<td>카테고리 번호</td>
						<td><%=bDTO.getCategorySeq()%></td>
					</tr>
					<tr>
						<td>작성자 번호</td>
						<td><%=bDTO.getUserSeq()%></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><%=bDTO.getSub()%></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><%=bDTO.getbContent()%></td>
					</tr>
					<tr>
						<td>호스트 번호</td>
						<td><%=bDTO.getHostSeq()%></td>
					</tr>
				</tbody>
			</table>
			<a href="bbs.jsp" class="btn btn-primary">목록</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>
