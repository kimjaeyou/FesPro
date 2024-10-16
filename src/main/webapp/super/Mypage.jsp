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
        <!-- 부트스트랩 공용 css -->
        <link href="${path}/css/My_styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
      <style>
        html, body {
            overflow: hidden; 
            height: 100%;
           // margin: 0;
            //padding: 0;
        }
 	  	</style>
    </head>

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
                                    <a class="nav-link" href="#"  id="selectAllBtn">문화행사 조회</a>
                                </nav>
                            </div>
                          
                 
                </nav>
            </div>
           <iframe src="${path}/super/dashBoard.jsp" name="center" id="iFrame" style="width:100%;  height:75vh;"></iframe>
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
       			
       			 $("#iFrame").attr("src", "${path}/front?key=superAuth&methodName=selectAll");
       			//top.center.location.href="auth/selectAll.html"
       		});
           });
           
           $(function(){
        	   $("#hostSelectAll").click(function(){
       			
       			 $("#iFrame").attr("src", "${path}/front?key=superAuth&methodName=hostSelectAll");
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
        <script>
       $(function(){
         /*   $("#aaa").click(function(){
        	   console.log("승인대기중인 행사 버튼");
        	   top.center.location.href ="${path}/front?key=superfestival&methodName=selectAll;
        	   //top.center.location.href ="${path}/front?key=superfestival&methodName=selectAll&search=searchWaiting";
           }); */
           
           //문화행사 조회
			  $("#selectAllBtn").click(function(){
				  top.center.location.href ="${path}/front?key=superfestival&methodName=selectAll";
			 });
           
           //차트
			  $("#chartBtn").click(function(){
				  //top.center.location.href ="${path}/front?key=superfestival&methodName=allowFestival";
				  
			 });
         });
        </script>
    </body>
</html>