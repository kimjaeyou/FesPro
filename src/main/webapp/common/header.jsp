<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="${path}/reservation/assets/js/color-modes.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.122.0">
<title>Headers · Bootstrap v5.3</title>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/headers/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8;
}

.navbar-nav {
	display: inline-block;
}

.navbar-nav li {
	display: inline;
	margin-right: 10px;
}

img {
	width: 100px;
	height: 100px;
}

.navbar-nav a {
	text-decoration: none;
	color: inherit;
}

.btn a {
	text-decoration: none;
	color: inherit;
}

.btn a:hover {
	text-decoration: none;
}

.login-info {
	display: inline-block;
	margin-right: 10px;
	font-size: 19px;
	color: #333;
	text-align: center;
	margin-bottom: 15px;
}

.btn-danger {
	padding: 8px 15px;
	font-size: 14px;
}

.logout-btn:hover {
	background-color: #c82333;
}

.header-container {
	border-bottom: 1px solid #ccc;
	padding-bottom: 20px;
}

.login-section {
	border: 2px solid blue;
	padding: 15px;
	border-radius: 15px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
	display: flex;
	flex-direction: column;
	align-items: center;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.login-buttons {
	display: flex;
	justify-content: center;
	width: 100%;
}

.active {
	font-size: 1rem;
	margin-left: 13px;
}

.con_tables {
	display: table;
	border: none;
}

.con_rows {
	display: table-row;
	border: none;
}

.con_rows2 {
	display: table-row;
}

.con_cells {
	border: none;
	align-content: center;
	text-align: center;
	align-items: center;
	display: table-cell;
	font-size: 20px;
	font: bold;
	font-family: Roboto;
	color: black;
	align-content: center;
}

.con_cells img {
	width: 30px;
	height: 30px;
}
</style>

</head>
<main>
	<div class="container">
		<header
			class="header-container d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
			<div class="col-md-3 mb-2 mb-md-0">
				<a href="${path}/front?key=main&methodName=read"
					class="d-inline-flex link-body-emphasis text-decoration-none">
					<img alt="logo" src="${path}/assets/img/FesProLogo_bg.png">
				</a>
			</div>
			<ul
				class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
				<li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> 문화체험 </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=all">전체검색</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=교육체험">교육체험</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=농장체험">농장체험</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=문화행사">문화행사</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=전시/관람">전시/관람</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=단체봉사">단체봉사</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=공원탐방">공원탐방</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=서울형키즈카페">서울형키즈카페</a></li>
						<li><a class="dropdown-item"
							href="${path}/front?key=main&methodName=searchPage&search=산림여가">산림여가</a></li>
					</ul></li>
				<li><a href="" class="nav-link px-2">예약보기</a></li>
				<li><a href="${path}/front?key=board&methodName=readFree"
					class="nav-link px-2">자유 게시판</a></li>
				<li><a href="${path}/front?key=board&methodName=readNoti"
					class="nav-link px-2">공지사항</a></li>
			</ul>

			<div class="login-section">
				<c:choose>
					<c:when test="${not empty sessionScope.loginUser}">
						<div class="con_tables">
							<div class="con_rows2">
								<div class="con_cells"></div>
								<div class="con_cells">
									<img id="profil" alt="profil"
										src="${path}/assets/img/profil.png">안녕하세요,
									${sessionScope.loginUser.user_name}님!
								</div>
							</div>
							<div class="con_rows">
								<div class="con_cells"></div>
								<div class="con_cells">
									<img id="message" alt="message"
										src="${path}/assets/img/messageImg/message_0.png"> 메세지
								</div>
								<div class="con_cells"></div>

							</div>
							<div class="con_rows2">
								<div class="con_cells"></div>
								<div class="con_cells">
									<form id="member-update-form" method="get"
										action="${pageContext.request.contextPath}/front"
										style="display: inline;">
										<input type="hidden" name="key" value="user" /> <input
											type="hidden" name="methodName" value="logout" />
										<button type="button" name="btnYun" id="btnYun"
											class="btn btn-danger btn-sm"
											onclick="location.href='${pageContext.request.contextPath}/front?key=user&methodName=logout'">
											로그아웃</button>
									</form>
								</div>
								<div class="con_cells"></div>
							</div>
						</div>
					</c:when>

					<c:when test="${not empty sessionScope.loginCom}">
						<div class="con_tables">
							<div class="con_rows2">
								<div class="con_cells"></div>
								<div class="con_cells">
									<img id="profil" alt="profil"
										src="${path}/assets/img/profil.png">안녕하세요,
									${sessionScope.loginCom.rep_name}님!
								</div>
							</div>
							<div class="con_rows">
								<div class="con_cells"></div>
								<div class="con_cells">
									<img id="message" alt="message"
										src="${path}/assets/img/messageImg/message_0.png"> 메세지
								</div>
								<div class="con_cells"></div>

							</div>
							<div class="con_rows2">
								<div class="con_cells"></div>
								<div class="con_cells">
									<form id="member-update-form" method="get"
										action="${pageContext.request.contextPath}/front"
										style="display: inline;">
										<input type="hidden" name="key" value="user" /> <input
											type="hidden" name="methodName" value="logout" />
										<button type="button" name="btnYun" id="btnYun"
											class="btn btn-danger btn-sm"
											onclick="location.href='${pageContext.request.contextPath}/front?key=user&methodName=logout'">
											로그아웃</button>
									</form>
								</div>
								<div class="con_cells"></div>
							</div>
						</div>
					</c:when>

					<c:when test="${empty sessionScope.loginUser || empty sessionScope.loginCom}" >
						<div class="con_tables">
							<div class="con_rows2">
								<div class="con_cells">
									<button type="button" class="btn btn-outline-primary me-2"
										style="width: 100%; margin: 1px;">
										<a href="${path}/user/login.jsp"
											style="text-decoration: none; color: inherit;">Login</a>
									</button>
									<button type="button" class="btn btn-primary"
										style="width: 100%; margin: 1px;">
										<a href="${path}/user/choice.jsp"
											style="text-decoration: none; color: inherit;">Sign-up</a>
									</button>
								</div>
								<div class="con_cells"></div>
							</div>
						</div>
					</c:when>
				</c:choose>
			</div>
		</header>
	</div>
</main>

<script src="${path}/reservation/assets/dist/js/bootstrap.bundle.min.js"></script>