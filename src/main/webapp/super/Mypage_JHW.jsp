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
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <!-- 부트스트랩 공용 css -->
        <link href="${path}/css/My_styles.css" rel="stylesheet" />
        <!-- 카드 헤더쪽 아이콘들 -->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        
        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <!-- /* 스크롤을 제거하는 스타일 */ -->
       <style>
        html, body {
            overflow: hidden; 
            height: 100%;
           // margin: 0;
            //padding: 0;
        }
 	  	</style>
    </head>
    
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-white" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
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
                                    <a class="nav-link" href="auth/selectAll.jsp">전체 회원 조회</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">주최자 승인</a>
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
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts_chart" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                차트
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                          <!--   <div class="collapse" id="collapseLayouts_chart" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="#"  id="selectAllBtn">성별별 차트</a>
                                </nav>
                            </div> -->
                            <!-- <a id="aaa">승인대기중인 문화행사 보기</a> -->
                </nav>
            </div>
            <!-- iframe -->
            <iframe src="" name="center" style="width:100%;  height:75vh;"></iframe>
        </div>
        
       
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
        <!-- 사이드 바 화살표, 그림 -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        
       <%--  <script src="${path}/js/My_scripts.js"></script> --%>
    	<%--     <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${path}/js/datatables-simple-demo.js"></script> --%>
     
    </body>
</html>
