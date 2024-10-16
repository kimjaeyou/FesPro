<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<<<<<<< HEAD
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<link rel="stylesheet" href="${path}/css/write.css">
=======
<link rel="stylesheet" href="../BoardCSS/bootstrap.css">
<link rel="stylesheet" href="../BoardCSS/custom.css">
>>>>>>> branch 'Integration' of https://github.com/kimjaeyou/FesPro.git
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<% 
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
<<<<<<< HEAD
=======
				<li><a href="../index.jsp">메인</a></li>
				<li class="active"><a href="../index.jsp">공지사항 게시판</a></li>
				<li class="active"><a href="../index.jsp">QA 게시판</a></li>
				<li class="active"><a href="../index.jsp">자유 게시판</a></li>
>>>>>>> branch 'Integration' of https://github.com/kimjaeyou/FesPro.git
			</ul>
			<% 
				if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<% 		
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%		
				}
			%>
			
		</div>
	</nav>
	<div class="container">
		<div class="row">
<<<<<<< HEAD
			
			<form method="post" action="${path}/front?key=board&methodName=write">
			<input type="hidden" name="categorySeq" value="0">
    <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <thead>
            <tr>
                <th colspan="2" style="background-color: #eeeeee; text-align: center;">글쓰기</th>                        
            </tr>
        </thead>
        <tbody>
            <!-- 카테고리 선택 드롭다운 -->
            <tr>
                <td>
                    <select class="form-control" name="categorySeq">
                        <option value="0">공지사항</option>
                        <option value="1">Q&A</option>
                        <option value="2">자유게시판</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" placeholder="글 제목" name="SUB" maxlength="50" required></td>
            </tr>
            <tr>
                <td><textarea class="form-control" placeholder="글 내용" name="B_CONTENT" maxlength="2048" style="height: 350px" required></textarea></td>                        
            </tr>
        </tbody>
    </table>
    <input type="submit" class="btn btn-primary pull-right" value="글쓰기">
</form>
						
=======
			<form method="post" action="boardMain.jsp">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
					</tr>
					<tr>
						<td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height: 350px"></textarea></td>						
					</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>						
>>>>>>> branch 'Integration' of https://github.com/kimjaeyou/FesPro.git
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap1.js"></script>
</body>
</html>