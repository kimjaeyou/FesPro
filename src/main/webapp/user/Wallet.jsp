<%@page import="wep.mvc.dto.UsersDTO"%>
<%@page import="wep.mvc.dto.ReservationDTO2"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="myPageCheck.jsp"%>
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
    <script>
        $(document).ready(function() {
            $('#charge-amount, #balance').on('input', function() {
                this.value = this.value.replace(/[^0-9]/g, '');
            });
        });
    </script>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <jsp:include page="../common/mySide.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <div class="balance-container">
                    <h2 class="mt-4">돈을 벌고싶니?</h2>               
                    <h2 class="mt-4">부자가 되고싶니?</h2>
                </div>
                <div class="section-container">
                    <form action="${path}/front" method="post">
                        <input type="hidden" name="key" value="mypage">
                        <input type="hidden" name="methodName" value="balancePlus">
                        <div class="section">
                            <h3>충전하기</h3>
                            <input type="text" id="charge-amount" name="charge" placeholder="충전할 금액을 입력하세요." />
                            <input type="password" id="charge-password" name="charge-password" placeholder="비밀번호를 입력하세요." />
                            <button type="submit">충전하기</button>
                        </div>
                    </form>
                    <form action="${path}/front" method="post">
                        <input type="hidden" name="key" value="mypage">
                        <input type="hidden" name="methodName" value="balanceMinus">
                        <div class="section">
                            <h3>출금하기</h3>
                            <input type="text" id="balance" name="balance" placeholder="출금하실 금액을 입력하세요." />
                            <input type="password" id="withdraw-password" name="withdraw-password" placeholder="비밀번호를 입력하세요." />
                            <button type="submit">출금하기</button>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../js/Wallet.js"></script>
</body>
</html>
