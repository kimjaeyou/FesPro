<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script>
	function sendUpdate() {
		document.myPage2Form.methodName.value = "pwUpdateForm";
		document.myPage2Form.submit();
	}
	function sendDelete() {
		document.myPage2Form.methodName.value = "myHostDelete";
		document.myPage2Form.submit();
	}
</script>

</head>
<!-- <body class="sb-nav-fixed">

        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            Navbar Brand
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            Sidebar Toggle
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            Navbar Search
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            Navbar
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav> -->
<body>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-white"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">주최자</div>
						<a class="nav-link" href="${path}/front?key=fes&methodName=select">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 나의 서비스 내역
						</a> <a class="nav-link"
							href="${path}/front?key=fes&methodName=myPage2">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 회원 정보 변경
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">나의 정보 내역</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">정보 조회하기</li>
					</ol>
					<!--  
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Primary Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Warning Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Success Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Danger Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        -->
					<!-- 게시판 영역 -->
					<%
					//세션에서 id 가져오는 일 합니다.
					%>
					<div class="container">
						<div class="row">

							<form name="myPage2Form" method=post action="${path}/front">
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<thead>
										<tr>
											<th style="background-color: #eeeeee; text-align: center;"
												colspan="2">내정보 보기</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><p align="center">
													<span>기업 아이디</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.host_id}</b></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>기업명</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.com_name}</b></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>전화번호</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.host_tel}</b></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>대표자명</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.host_name}</b></span>
												</p></td>
										</tr>
										<%-- <tr>
											<td><p align="center">
													<span>승인여부</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.host_check}</b></span>
												</p></td>
										</tr> --%>
										<tr>
											<td><p align="center">
													<span>가입자명</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.rep_name}</b></span>
												</p></td>
										</tr>
										<%-- <tr>
											<td><p align="center">
													<span>정지여부</span>
												</p></td>
											<td><p align="center">
													<span><b>${hostDTO.host_ben_check}</b></span>
												</p></td>
										</tr> --%>
										<tr>

											<td width="450" height="20" colspan="2" align="center">
												<input type=hidden name="host_seq"
												value="${hostDTO.host_seq}"> <input type=hidden
												name="key" value="fes"> <input type=hidden
												name="methodName"> <input type=button
												value="비밀번호 수정하기" onClick="sendUpdate()"> <input
												type=button value="탈퇴하기" onClick="sendDelete()">
											</td>

										</tr>
									</tbody>
								</table>
							</form>

						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/My_scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>
