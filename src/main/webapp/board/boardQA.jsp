<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="${path}/reservation/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<jsp:include page="../common/header.jsp"></jsp:include>

<title></title>
<style type="text/css">

/* 배경 이미지 설정 스타일 */
#head {
<<<<<<< HEAD
    background-image: url("${path}/assets/img/Main_bg.png");
=======
    background-image: url("${path}/assets/img/Main_bg.png"); /* 경로 수정 */
>>>>>>> branch 'Integration' of https://github.com/kimjaeyou/FesPro.git
    background-size: cover; /* 이미지가 요소를 꽉 채우도록 설정 */
    background-position: center;
    background-repeat: no-repeat;
    width: 100%;
    height: 27%;
}

/* header 높이와 너비 설정 */
header {
    height: inherit;
    width: inherit;
}

.container {
    display: flex;
    justify-content: center;
    margin-top: 50px;
}

.sidebar {
    width: 200px;
    margin-right: 20px;
}

.content {
    flex-grow: 1;
    max-width: 900px;
}

/* 테이블 스타일 우선순위 높이기 */
table {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid gray !important;
    margin-top: 20px;
}

th, td {
    border: 1px solid gray !important;
    padding: 8px;
    text-align: center;
}

/* 테이블 열 비율 설정 */
th:nth-child(1), td:nth-child(1), th:nth-child(3), td:nth-child(3) {
    width: 15%; /* 번호와 작성자 열을 15%로 설정 */
}

th:nth-child(2), td:nth-child(2) {
    width: 70%; /* 제목 열을 70%로 설정 */
}

/* 네비게이션 바 */
.navbar {
    display: flex;
    justify-content: flex-start; /* 좌측 정렬 */
    background-color: white; /* 네비게이션 바 배경색 흰색 */
    padding: 10px;
    margin-left: 280px;
}

.nav-item {
    margin: 0 10px; /* 네비게이션 바 아이템 간격 */
    position: relative; /* 드롭다운을 위해 position 설정 */
    width: 100px; /* 메뉴의 너비 통일 */
}

.nav-item b {
    display: inline-block;
    text-decoration: none;
    color: white;
    padding: 10px 20px;
    background-color: #007bff; /* 파란색 배경 */
    height: 50px;
    line-height: 30px; /* 텍스트 중앙 정렬 */
    text-align: center;
    border-radius: 10px; /* 모서리 둥글게 */
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2); /* 입체감 부여 */
    transition: transform 0.2s ease-in-out; /* 입체 효과 */
}

.nav-item b:hover {
    transform: translateY(-2px); /* 호버 시 살짝 올라가는 효과 */
}

/* 메뉴 리스트 */
.nav-item .menu-list {
    display: none;
    position: absolute;
    top: 50px;
    left: 0; /* 버튼과 크기 일치 */
    background-color: #ffffff; /* 메뉴 배경색 */
    width: 150px; /* 메뉴 크기 */
    z-index: 10;
    padding: 0;
    margin: 0;
   
}

.nav-item:hover .menu-list {
    display: block; /* 호버 시 메뉴 리스트 표시 */
}

.menu-list li {
    list-style: none;
    border-bottom: 1px solid #dddddd;
    padding: 0;
}

.menu-list li a {
    display: block;
    padding: 10px;
    text-align: left;
    color: black; /* 메뉴 텍스트 색상 */
    text-decoration: none;
    margin: 0;
}

.menu-list li a:hover {
    background-color: #0056b3; /* 메뉴 항목 호버 시 색상 변경 */
}

/* 글쓰기 버튼에 새로운 스타일 적용 */
.btn-custom {
    position: fixed;
    right: 50px;
    bottom: 50px;
    width: 100px; /* 너비 고정 */
    height: 50px; /* 높이 고정 */
    background-color: #007bff; /* 파란색 배경 */
    color: white;
    text-align: center;
    line-height: 50px; /* 텍스트 중앙 정렬 */
    border-radius: 10px; /* 모서리 둥글게 */
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2); /* 입체감 */
    text-decoration: none;
    transition: transform 0.2s ease-in-out;
}

.btn-custom:hover {
    transform: translateY(-2px);
    color: white;
    text-decoration: none; /* 호버 시 밑줄 제거 */
}

</style>
</head>
<body>

    <!-- 네비게이션 바 생성 -->
    <div class="navbar">
        <!-- 게시판 버튼과 메뉴 목록 -->
        <div class="nav-item">
            <b>게시판</b>
            <ul class="menu-list">
                <li><a href="${path}/front?key=board&methodName=readNoti">공지사항</a></li>
                <li><a href="${path}/front?key=board&methodName=readQA">QA 게시판</a></li>
                <li><a href="${path}/front?key=board&methodName=readFree">자유 게시판</a></li>
            </ul>
        </div>
    </div>

    <div class="container">
        <!-- 오른쪽에 테이블 배치 -->
        <div class="content">
            <div class="row">
                <table class="table table-striped" style="text-align: center; border: 2px solid #dddddd !important;">
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

                <!-- 글쓰기 버튼을 오른쪽 아래에 고정 -->
                <a href="${path}/front?key=board&methodName=moveWritePage" class="btn-custom">글쓰기</a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="${path}/js/bootstrap.js"></script>

</body>
</html>
