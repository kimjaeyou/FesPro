<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="../css/styles.css" rel="stylesheet" />
  <link href="../css/Reservation.css" rel="stylesheet" />
  
</head>
      <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-white" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                      <div class="sb-sidenav-menu-heading">마이페이지</div>
                <a class="nav-link"  href="${path}/front?key=mypage&methodName=resSelectAll">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    나의 예약내역
                </a>
                <a class="nav-link" href="${path}/front?key=user&methodName=selectUser">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    회원정보변경
                </a>
                <a class="nav-link" href="${path}/front?key=mypage&methodName=balanceSelect">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    지갑
                </a>
                <a class="nav-link" href="${path}/front?key=mypage&methodName=reviewSelectAll">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    나의 이용후기
                </a>
                <a class="nav-link" href="${path}/front?key=mypage&methodName=likeSelectAll">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    즐겨찾기 목록
                  </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                       </div> 
	                </nav>
                    </div>
            <div id="layoutSidenav_content">
</body>
</html>