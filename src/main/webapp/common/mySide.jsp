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
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            
            <div class="nav">
                <div class="sb-sidenav-menu-heading">마이페이지</div>
                <a class="nav-link" href="Reservation.jsp">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    나의 예약내역
                </a>
                <a class="nav-link" href="${path}/user/update.jsp">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    회원정보변경
                </a>
                <a class="nav-link" href="like.jsp">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    관심정보 설정
                </a>
                <a class="nav-link" href="review.jsp">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    나의 이용후기
                </a>
                <a class="nav-link" href="Bookmark.jsp">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    즐겨찾기 목록
                </a>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">여기에 뭐넣어요?</div>
            프론트는 어려워요
        </div>
    </nav>
</div>
</html>