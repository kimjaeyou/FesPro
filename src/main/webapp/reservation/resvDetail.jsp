<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        
<style>
    table {
        width: 65%;
        padding: 20px;
        border-top: solid black 2px;
        border-bottom: solid black 2px;
        border-right: none;
        border-left: none;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 50px;
    }

    th {
        text-align: center;
        background-color: rgba(0, 123, 255, 0.17);
        width: 20%;
    }

    th,
    td {
        padding: 15px;
        border-bottom: solid rgba(199, 199, 199, 0.5) 1px;
    }
    
    caption {
	  	caption-side: top;
	  	text-align: left;
	  	font-size: large;
        font-weight: bold;
	}

    [data-img] {
        float: left;
        margin-left: 17vw;
        margin-top: 80px;
        width: 28%;
        height: 32%;
    }
    
    .resv_data {
    	float: right;
    	width: 35%;
        margin-right: 18vw;
        margin-top: 20px;
    }
    
    .moveBtn {
    	text-align: left; margin-bottom: 50px;
        margin-left: 18%;
        margin-bottom: auto;
    }
    
    .btn btn-primary {
    	align-items: center;
        width: 100px;
    }

    h3 {
        text-align: left;
        margin-left: 18%;
    }

</style>

<script>
    $(function () {
        const getFesInfo = ()=>{
            $.ajax({
             url :"ajax" , //서버요청주소
             type:"post", //요청방식(method방식 : get | post | put | delete )
             dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
             data: {key:"fes" , methodName : "selectAll"}, //서버에게 보낼 데이터정보(parameter정보)
             success :function(result){
                 console.log(result);
                 
                 let str="";
                 $.each(result, function(index, item){

               });
                 
                 
             } , //성공했을때 실행할 함수 
             error : function(err){  
                 alert(err+"에러 발생했어요.");
             }  //실팽했을때 실행할 함수 
         });//ajax끝
        }//selectAll 함수끝
    })

</script>
        
</head>
<body>
    <h3>행사명</h3>
    <img alt="행사 이미지" src="https://picsum.photos/1000/1000" data-img="svcImg">
	<table class = "resv_data">
        <caption>행사명</caption>
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