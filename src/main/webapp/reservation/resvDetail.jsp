<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />

<!-- 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<!-- script -->
      <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        
        
</head>
<body>
    <h3>행사명 : ${fesDTO.SVCNM}</h3>
    <c:choose>
    	<c:when test="${empty fes.IMGURL}">
    		<img alt="행사 이미지" src="https://picsum.photos/1000/1000" data-img="svcImg">
    	</c:when>
    	<c:otherwise>
    		<img src = "${fes.IMGURL}" data-img="fesImg">
    	</c:otherwise>
    </c:choose>
	<table class = "resv_data">
        <caption>${fesDTO.SVCNM}</caption>
        <tr>
            <th>예약번호</th>
            <td>${resvDTO.reservSeq}</td>
        </tr>
        <tr>
            <th>예약현황</th>
            <td>
            	<c:choose>
            		<c:when test="${resvDTO.resvCheck eq 1}">예약완료</c:when>
            		<c:otherwise>예약접수</c:otherwise>
            	</c:choose>
            	
            </td>
        </tr>
        <tr>
            <th>이용일자</th>
            <td>${resvDTO.svcDate}</td>
        </tr>
        <tr>
            <th>회차명</th>
            <td>${resvDTO.svcTime}</td>
        </tr>
        <tr>
            <th>이용인원</th>
            <td>${resvDTO.resvPeo}</td>
        </tr>
        <tr>
            <th>취소기한</th>
            <td>${resvDTO.cancleDate}</td>
        </tr>
    </table>

    <table>
        <caption>서비스 정보</caption> <!-- controller에서 SVCID 이용해서 서비스 정보 담아오기 -->
        <tr>
            <th>장소</th>
            <td>${fesDTO.PLACENM}</td>
        </tr>
        <tr>
            <th>주소</th>
            <td>${fesDTO.AREANM}</td>
        </tr>
        <tr>
            <th>뺄까..</th>
            <td>${fesDTO.REVSTDDAY}</td>
        </tr>
        <tr>
            <th>문의처</th>
            <td>${fesDTO.TELNO}</td>
        </tr>
    </table>
    
    <table>
        <caption>신청자 정보</caption> <!-- 신청자 정보를 reservation 테이블에 추가하거나 user_seq를 이용해서 신청자 정보 담아오기 -->
        <tr>
            <th>신청자 명</th>
            <td>${userDTO.user_name}</td>
        </tr>
        <tr>
            <th>연락처</th>
            <td>${userDTO.user_tel}</td>
        </tr>
    </table>

    <table>
        <caption>결제 정보</caption>
        <tr>
            <th>결제기한</th>
            <td>${resvDTO.svcDate}</td>
        </tr>
        <tr>
            <th>이용인원</th>
            <td>${resvDTO.resvPeo}</td>
        </tr>
        <tr>
            <th>이용요금</th>
            <td>${fesDTO.PRICE}</td>
        </tr>
        <tr>
            <th>할인/할증</th>
            <td></td>
        </tr>
        <tr>
            <th>총 결제금액</th>
            <td>${resvDTO.resvPrice}</td>
        </tr>
    </table>
    <div class="moveBtn">
    	<button class="btn btn-primary" id="cancle"  type="button">예약 취소</button>
    </div>
    </body>

</html>