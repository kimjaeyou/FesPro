<%@page import="wep.mvc.dto.UsersDTO"%>
<%@page import="wep.mvc.dto.WALLET"%>
<%@page import="wep.mvc.dto.ReservationDTO2"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>나의 예약내역</title>
    <link href="${path}/css/My_styles.css" rel="stylesheet" />
    <link href="${path}/css/Wallet.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/mySide.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <div class="balance-container">
                    <!-- <h2 class="mt-4">돈을 벌고싶니?</h2>               
                    <h2 class="mt-4">부자가 되고싶니?</h2>
                    <h3>───────────────────────────────────────────────</h3> -->
                    <h4 class="mt-4">${sessionScope.loginUser.user_name}님의 잔액은 ${requestScope.money.MONEY}원 있습니다.</h4>                    
                </div>
                    <form action="${path}/front" method="post">
                        <input type="hidden" name="key" value="mypage">
                        <input type="hidden" name="methodName" value="balancePlus">
                        <div class="section">
                            <h3>충전하기</h3>
                            <input type="text" id="plus-amount" name="plus-amount" placeholder="충전할 금액을 입력하세요." />
                            <input type="password" id="plus-password" name="plus-password" placeholder="비밀번호를 입력하세요." />
                            <button type="submit">충전하기</button>
                        </div>
                    </form>
                </div>
        </main>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../js/Wallet.js"></script>
</body>
</html>
