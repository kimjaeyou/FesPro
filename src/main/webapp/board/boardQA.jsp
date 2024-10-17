<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="${path}/reservation/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="../common/header.jsp"></jsp:include>

<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
a, a:hover {
    color: #000000;
    text-decoration: none;
}
.container {
    display: flex;
    justify-content: flex-start; /* 요소들이 왼쪽으로 정렬되도록 설정 */
}

.sidebar {
    width: 200px;
    margin-right: 20px; /* 테이블과의 간격을 추가 */
}

.content {
    flex-grow: 1; /* 테이블이 남은 공간을 차지하도록 설정 */
}

.navbar-collapse {
    display: flex;
    flex-direction: column; /* 세로로 배치 */
    list-style-type: none; /* 기본 리스트 스타일 제거 */
    padding: 0;
}

.navbar-nav li {
    margin-bottom: 10px;
}

.navbar-nav a {
    display: block;
    width: 150px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background-color: #eeeeee;
    border: 1px solid #dddddd;
    border-radius: 10px;
    font-weight: bold;
}

/* 테이블 스타일 추가 */
table {
    border-collapse: collapse; /* 중복 테두리 제거 */
    width: 100%;
}

th, td {
    border: 1px solid #000000; /* 각 셀에 1px 검정 테두리 추가 */
    padding: 8px; /* 셀 안의 여백 추가 */
    text-align: center; /* 텍스트 중앙 정렬 */
}
</style>
</head>
<body>

    <div class="container">
        <!-- 왼쪽에 버튼 배치 -->
        <div class="sidebar">
            <nav class="navbar navbar-default">
                <div class="navbar-header"></div>
                <div class="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="${path}/front?key=board&methodName=readNoti">공지사항</a>
                        </li>
                        <li class="active">
                            <a href="${path}/front?key=board&methodName=readQA">QA 게시판</a>
                        </li>
                        <li class="active">
                            <a href="${path}/front?key=board&methodName=readFree">자유 게시판</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <!-- 오른쪽에 테이블 배치 -->
        <div class="content">
            <div class="row">
                <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                    <thead>
                        <tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach var="post" items="${QA}">

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

			<a href="${path}/front?key=board&methodName=write"
				class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path}	/js/bootstrap.js"></script>
</body>
</html>
