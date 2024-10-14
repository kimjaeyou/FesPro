<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <jsp:include page="/common/header.jsp" />
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


        <style>
            table {
                width: 80%;
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

            .goBtn {text-align: center; margin-bottom: 50px;}

        </style>

        <!-- script -->
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
            $(function () {
                $(document).on("click", "#goMain", function(){
                    location.href="${path}/index.jsp";
                });
                
            }) // function end
            
            function sendSelect () {
				let seq = $("[data-form=resvSeq]").text();
				console.log(seq);
                
                document.goForm.key.value = "reservation";
                document.goForm.methodName.value = "selectByResvSeq";
                document.goForm.resvSeq.value = seq;
                document.goForm.submit();
            }

        </script>


    </head>

    <body>
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <div>
                        <i class="bi bi-1-circle" style="font-size:2rem; color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-2-circle" style="font-size:2rem; color: rgb(0, 123, 255);"></i>
                    </div>
                    예약 정보 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 예약
                    완료 <br><br>
                    <h1 class="fw-bolder">예약 신청이 정상적으로 처리되었습니다.</h1>

                </div>
            </div>
        </header>
        <div class="divTable">
            <table>
                <tr>
                    <th>예약번호</td>
                    <td name="resvNo" data-form="resvSeq">
						<c:if test="${not empty resvData}">
							${resvData.reservSeq}
						</c:if>
					</td>
                    <!-- \${reservSeq} -->
                </tr>
                <tr>
                    <th>서비스명</td>
                    <td name="svcName">${SVCNM}</td>
                </tr>
                <tr>
                    <th>이용일자</td>
                    <td name="svcDate">
						<c:if test="${not empty resvData}">
								${resvData.svcDate}
						</c:if>
					</td>
                </tr>
                <tr>
                    <th>이용인원</td>
                    <td name="resvPeo">
						<c:if test="${not empty resvData}">
						${resvData.resvPeo}
					</c:if>
					</td>
                </tr>
                <tr>
                    <th>이용요금</td>
                    <td name="resvPrice">
                    <td name="resvPeo">
					<c:if test="${not empty resvData}">
						${resvData.resvPrice}
					</c:if>
					</td>
                </tr>
                <tr>
                    <th>예약상태</td>
                    <td name="resvCheck">
                    <c:choose>
                    	<c:when test="${resvData.resvCheck eq 0}">예약확인중</c:when>
                    	<c:otherwise>예약완료</c:otherwise>
                    	
                    </c:choose>
                    </td>
                </tr>

            </table>
        </div>

        <div class="goBtn">
            
            <form name="goForm" method = "post" action = "${path}/front">
	        	<input type = "hidden" name = "key"/>
	        	<input type = "hidden" name = "methodName"/>
	        	<input type = "hidden" name = "resvSeq"/>
	        	<button class="btn btn-outline-primary" id="goMain" style="width: 10%;" type="button">메인페이지 바로가기</button> &nbsp;&nbsp;&nbsp;&nbsp;
	            <button class="btn btn-primary" id="goDetail" style="width: 10%;" type="button" onClick = "sendSelect()">예약 상세 보기</button>
            </form>
        </div>
    </body>

    </html>