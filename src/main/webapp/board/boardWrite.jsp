<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<link rel="stylesheet" href="${path}/css/write.css">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>	
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			
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
						
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>