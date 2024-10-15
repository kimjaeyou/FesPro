<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/common/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="../css/My_styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
      
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
        <div id="layoutSidenav" >
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-white" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                        <!--마이페이지 추가 (-재구) -->
                       		 <a class="sb-sidenav-menu-heading" href="#" id="myPage" style="text-decoration: none;">마이페이지</a>
                        <!--회원쪽 -->
                        <!-- ============================================================================= -->
                            <div class="sb-sidenav-menu-heading">회원</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts_auth" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                회원 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts_auth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                	<!-- 회원과 주최자 분류해서 조회(-재구)   -->
                                    <a class="nav-link" href="#" id="userSelectAll">전체 회원 조회</a>
                                    <a class="nav-link" href="#" id="hostSelectAll">전체 주최자 조회</a>
                                    <a class="nav-link" href="#" id="accept">주최자 승인</a>
                                </nav>
                            </div>
                            <!-- ============================================================================= -->
                            <!-- 문화행사쪽  -->
                            <!-- ============================================================================= -->
                            <div class="sb-sidenav-menu-heading">문화행사</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts_fes" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                문화행사 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts_fes" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">문화행사 조회</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">문화행사 승인</a>
                                </nav>
                            </div>
                          
                 
                </nav>
            </div>
            <iframe src="dashBoard.jsp" width="100%" height="1000px" style="border:none;" id="iFrame" name="center"></iframe>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/My_scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        
          <script>
          <!-- 회원과 주최자 분류해서 조회(-재구)   -->
           $(function(){
        	   $("#userSelectAll").click(function(){
       			
       			 $("#iFrame").attr("src", "${path}/super/auth/userSelectAll.jsp");
       			//top.center.location.href="auth/selectAll.html"
       		});
           });
           
           $(function(){
        	   $("#hostSelectAll").click(function(){
       			
       			 $("#iFrame").attr("src", "${path}/super/auth/hostSelectAll.jsp");
       			//top.center.location.href="auth/selectAll.html"
       		});
           });
          
           $(function(){
        	   $("#accept").click(function(){
       			
       			 $("#iFrame").attr("src", "${path}/super/auth/accept.jsp");
       			//top.center.location.href="auth/selectAll.html"
       		});
           });
          
           $(function(){
        	   $("#myPage").click(function(){
       			
       			 $("#iFrame").attr("src", "${path}/super/dashBoard.jsp");
       			//top.center.location.href="auth/selectAll.html"
       		});
           });
          
        	
        </script>
    </body>
</html>
