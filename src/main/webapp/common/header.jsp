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
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>Headers · Bootstrap v5.3</title>
    <link rel="canonical" href="https://get bootstrap.com/docs/5.3/examples/headers/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
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

<
style>.bd-placeholder-img {
   font-size: 1.125rem;
   text-anchor: middle;
   -webkit-user-select: none;
   -moz-user-select: none;
   user-select: none;
}

.bi {
   vertical-align: -.125em;
   fill: currentColor;
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

.bd-mode-toggle {
   z-index: 1500;
}

.navbar-nav {
   display: inline-block;
}

.navbar-nav li {
   display: inline;
   margin-right: 10px;
}

.bd-mode-toggle .dropdown-menu .active .bi {
   display: block !important;
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

#btnYun {
   background-color: #0250C4;
   color: white;
   border: 2px solid #A6A6A6;
   padding: 10px 20px;
   text-decoration: none;
   display: inline-block;
   font-size: 14px;
   font-weight: bold;
   margin: 4px 2px;
   cursor: pointer;
   border-radius: 5px;
}

#btnYun:hover {
   background-color: darkblue;
}

.navbar-nav {
   background: #B3CEE5;
   display: flex;
   margin: 10px;
   padding: 10px;
   border: #A6A6A6;
   border-radius: 15px;
   font-size: 1.25rem;
   text-align: center;
   display: flex;
   justify-content: center;
   margin-right: 10px;
}
</style>
<!-- Custom styles for this template -->
    <!--  <link href="headers.css" rel="stylesheet">-->
</head>
<main>
    <div class="container">
        <header
            class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <div class="col-md-3 mb-2 mb-md-0">
                <a href="${path}/front?key=main&methodName=read" class="d-inline-flex link-body-emphasis text-decoration-none">
                    <img alt="logo" src="${path}/assets/img/FesProLogo_bg.png">
                </a>
            </div>
            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
                <!-- <li><a href="#" class="nav-link px-2">문화행사</a></li> -->
                  <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  문화체험
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">교육체험</a></li>
                  <li><a class="dropdown-item" href="#">농장체험</a></li>
                  <li><a class="dropdown-item" href="#">문화행사</a></li>
                  <li><a class="dropdown-item" href="#">전시/관람</a></li>
                  <li><a class="dropdown-item" href="#">단체봉사</a></li>
                  <li><a class="dropdown-item" href="#">공원탐방</a></li>
                  <li><a class="dropdown-item" href="#">서울형키즈카페</a></li>
                  <li><a class="dropdown-item" href="#">산림여가</a></li>
                </ul>
              </li>
                <li><a href="#" class="nav-link px-2">예약보기</a></li>
                <li><a href="${path}/front?key=board&methodName=readNoti" class="nav-link px-2">게시판</a></li>
                <li><a href="${path}/front?key=board&methodName=readNoti" class="nav-link px-2">공지사항</a></li>
            </ul>
   <c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <ul class="nav navbar-nav navbar-right">
            <li class="active">[${sessionScope.loginUser.user_name} / ${sessionScope.loginUser.user_id} ]님 로그인 중 입니다.</li>
            ${sessionScope.loginUser.user_name}
            <form id="member-update-form" method="get" action="${pageContext.request.contextPath}/front">
                <input type="hidden" name="key" value="user" /> 
                <input type="hidden" name="methodName" value="logout" />
                <button type="button" name="btnYun" id="btnYun" onclick="location.href='${pageContext.request.contextPath}/front?key=user&methodName=logout'">로그아웃</button>
            </form>
        </ul>
    </c:when>
    
    <c:when test="${not empty sessionScope.loginCom}">
        <ul class="nav navbar-nav navbar-right">
            <li class="active">(${sessionScope.loginCom.host_name}/${sessionScope.loginCom.host_id})님 로그인 중 입니다.</li>
            <form id="member-update-form" method="get" action="${pageContext.request.contextPath}/front">
                <input type="hidden" name="key" value="host" /> 
                <input type="hidden" name="methodName" value="logout" />
                <button type="button" name="btnYun" id="btnYun" onclick="location.href='${pageContext.request.contextPath}/front?key=user&methodName=logout'">로그아웃</button>
            </form>
        </ul>
    </c:when>
    
    <c:when test="${empty sessionScope.loginUser}">
        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2"><a href="${path}/user/login.jsp">Login</a></button>
            <button type="button" class="btn btn-primary"><a href="${path}/user/choice.jsp">Sign-up</a></button>
        </div>
    </c:when>
    
    <c:when test="${empty sessionScope.loginCom}">
        <div class="col-md-3 text-end">
            <button type="button" class="btn btn-outline-primary me-2"><a href="${path}/user/login.jsp">Login</a></button>
            <button type="button" class="btn btn-primary"><a href="${path}/user/choice.jsp">Sign-up</a></button>
        </div>
    </c:when>
</c:choose>
   
        </header>
    </div>
</main>



