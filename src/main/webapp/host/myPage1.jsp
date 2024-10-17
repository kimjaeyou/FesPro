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
					<h1 class="mt-4">나의 서비스 내역</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">내가 주최한 서비스 내역</li>
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
							<!-- 등록하러 가기 -->
							<button>
								<a href="${path}/host/write.jsp">서비스 등록하러 가기</a>
							</button>
							<hr>
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th style="background-color: #eeeeee; text-align: center;">서비스아이디</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스명</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스상태</th>
										<th style="background-color: #eeeeee; text-align: center;">등록(수정)신청일시</th>
										<th style="background-color: #eeeeee; text-align: center;">등록(수정)신청정보</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스
											통계보기</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty fesDTOList}">
											<tr>
												<td colspan="7">
													<p align="center">
														<b><span>등록된 행사가 없습니다.</span></b>
													</p>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${fesDTOList}" var="FesDTO">
												<tr>
													<td>
														<p align="center">
															<span>${FesDTO.SVCID}</span>
														</p>
													</td>
													<td>
														<p align="center">
															<span><a
																href="${path}/front?key=fes&methodName=selectBySVCID&SVCID=${FesDTO.SVCID}">${FesDTO.SVCNM}</a></span>
														</p>
													</td>
													<td>
														<p align="center">
															<span>${FesDTO.SVCSTATNM}</span>
														</p>
													</td>

													<td>
														<p align="center">
															<span>${FesDTO.getUpdate_date()}</span>
														</p>
													</td>
													<td>
														<p align="center">
															<span> <c:set var="fesState"
																	value="${FesDTO.getFes_state()}" /> <c:choose>
																	<c:when test="${fesState eq 0}">승인대기</c:when>
																	<c:when test="${fesState eq 1}">승인완료</c:when>
																	<c:when test="${fesState eq 2}">수정신청 승인대기</c:when>
																	<c:when test="${fesState eq 3}">비활성화(삭제)</c:when>

																</c:choose>
															</span>
														</p>
													</td>

													<td>
														<p align="center">
															<span><a
																href="${path}/front?key=fes&methodName=detail&SVCID=${FesDTO.SVCID}">서비스
																	통계보기</a></span>
														</p>
													</td>
												</tr>

											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<h1>등록/수정 신청한 서비스 내역</h1>
							<!-- 여기부터는 WAIT_FES영역 -->
							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th style="background-color: #eeeeee; text-align: center;">서비스아이디</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스명</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스상태</th>
										<th style="background-color: #eeeeee; text-align: center;">등록(수정)신청일시</th>
										<th style="background-color: #eeeeee; text-align: center;">등록(수정)신청정보</th>
										<th style="background-color: #eeeeee; text-align: center;">서비스
											통계보기</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty waitFesList}">
											<tr>
												<td colspan="7">
													<p align="center">
														<b><span>신청된 행사가 없습니다.</span></b>
													</p>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${waitFesList}" var="waitFesList">
												<tr>
													<td>
														<p align="center">
															<span>${waitFesList.SVCID}</span>
														</p>
													</td>
													<td>
														<p align="center">
															<span><a
																href="${path}/front?key=fes&methodName=fesWaitselectBySVCID&SVCID=${waitFesList.SVCID}">${waitFesList.SVCNM}</a></span>
														</p>
													</td>
													<td>
														<p align="center">
															<span>${waitFesList.SVCSTATNM}</span>
														</p>
													</td>

													<td>
														<p align="center">
															<span>${waitFesList.getUpdate_date()}</span>
														</p>
													</td>
													<td>
														<p align="center">
															<span> <c:set var="fesState"
																	value="${waitFesList.getFes_state()}" /> <c:choose>
																	<c:when test="${fesState eq 0}">승인대기</c:when>
																	<c:when test="${fesState eq 1}">승인완료</c:when>
																	<c:when test="${fesState eq 2}">수정신청 승인대기</c:when>
																	<c:when test="${fesState eq 3}">비활성화(삭제)</c:when>

																</c:choose>
															</span>
														</p>
													</td>

													<td>
														<p align="center">
															<span><a
																href="${path}/front?key=fes&methodName=detail&SVCID=${waitFesList.SVCID}">서비스
																	통계보기</a></span>
														</p>
													</td>
												</tr>

											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>

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