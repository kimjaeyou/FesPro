<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/common/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>예약 페이지</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${path}/assets/img/FesProLogo_bg.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />


        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">
    
        
        <link rel="stylesheet" href="${path}/reservation/fonts/icomoon/style.css">
    
        <link rel="stylesheet" href="${path}/reservation/css/rome.css">
        
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <!-- Style -->
        <link rel="stylesheet" href="${path}/reservation/css/style2.css">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/css/datepicker.min.css">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <style>
            .num {text-align: right;}
            .chk {text-align: right; display: flex; justify-content: flex-end;}
            .chkAll {text-align: center; display: flex; justify-content: center;}
            #chk {margin-right: 5px; zoom: 1.5;}
            #chkAll {margin-right: 5px; zoom: 2.0;}
            .chkLabel {margin: 0;}

            table {
                width: 100%;
                padding: 20px;
                border-top: solid black 2px;
                border-bottom: solid black 2px;
                border-right: none;
                border-left: none;
            }

            th { text-align: center; background-color: rgba(204, 204, 204, 0.2); width: 20%;}

            th, td { padding: 15px; border-bottom: solid rgba(199, 199, 199, 0.7) 1px;}

            .bi-caret-right-fill { margin-bottom: 3px;}

            [data-form] {color:blue}

            #datepicker_input {
                text-align: center;
                align-items: center;
                margin-bottom: 100px;
                font-size: 1.5rem;
            }
            
            .content {
            	margin-bottom: 100px;
            }
            
            .form-floating {
            	text-align: center;
                align-items: center;
                place-content: center;
            }
            
            #datepicker {
            	display: flex;
            	justify-content: center;
            }
            
           

        </style>
		
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/datepicker-full.min.js"></script>
		
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css">
 		<link rel="stylesheet" href="/resources/demos/style.css">
 
  		<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.js"></script>
		
		<script type="text/javascript">
			// 사이드바에 선택한 값 입력
			$(document).on("click", ".rd-day-body", function() {
				let stringDate1 = $("#result").val();
			       //console.log(stringDate);
			    
			    let date1 = new Date(stringDate1);
			    let dateFormat1 = date1.getFullYear() +
				'-' + ( (date1.getMonth()+1) < 10 ? "0" + (date1.getMonth()+1) : (date1.getMonth()+1) )+
				'-' + ( (date1.getDate()) < 10 ? "0" + (date1.getDate()) : (date1.getDate()) );
			       
				$("[data-form=date]").html(dateFormat1);
				
				//date2 = new Date(stringDate);
				console.log(date1);
				let cancleDate1 = new Date(date1);
				cancleDate1.setDate(date1.getDate()-1); // 취소기간 기준일 받아와서 넣기
				console.log(cancleDate1);
				
				//console.log(new Date());
				let dateFormat2 = cancleDate1.getFullYear() +
				'-' + ( (cancleDate1.getMonth()+1) < 10 ? "0" + (cancleDate1.getMonth()+1) : (cancleDate1.getMonth()+1) )+
				'-' + ( (cancleDate1.getDate()) < 10 ? "0" + (cancleDate1.getDate()) : (cancleDate1.getDate()) );
			
				$("[data-form=canclePeriod]").html(dateFormat2);
				
			})
	
			   $(document).on("click", ".datepicker-cell", function() {
				let stringDate2 = $("#datepicker1").val();
				$("[data-form=date]").html(stringDate2);
				
				let date2 = new Date(stringDate2);
				let cancleDate2 = new Date(date2);
				cancleDate2.setDate(date2.getDate()-1);
				
				console.log(cancleDate2);
				let dateFormat3 = cancleDate2.getFullYear() +
				'-' + ( (cancleDate2.getMonth()+1) < 10 ? "0" + (cancleDate2.getMonth()+1) : (cancleDate2.getMonth()+1) )+
				'-' + ( (cancleDate2.getDate()) < 10 ? "0" + (cancleDate2.getDate()) : (cancleDate2.getDate()) );
				//let canclePeriod = date-1; // 취소기간 기준일 받아와서 넣기
				$("[data-form=canclePeriod]").html(dateFormat3);
			})
			
			   $(document).on("click", "#datepicker", function() {
				let stringDate3 = $("#datepicker").val();
				$("[data-form=date]").html(stringDate3);
				console.log(stringDate3);
				
				let date3 = new Date(stringDate3);
				let cancleDate3 = new Date(date3);
				cancleDate3.setDate(date3.getDate()-1);
				
				console.log(cancleDate3);
				let dateFormat4 = cancleDate3.getFullYear() +
				'-' + ( (cancleDate3.getMonth()+1) < 10 ? "0" + (cancleDate3.getMonth()+1) : (cancleDate3.getMonth()+1) )+
				'-' + ( (cancleDate3.getDate()) < 10 ? "0" + (cancleDate3.getDate()) : (cancleDate3.getDate()) );
				//let canclePeriod = date-1; // 취소기간 기준일 받아와서 넣기
				$("[data-form=canclePeriod]").html(dateFormat4);
			})
	
			$(document).on("click", ".time", function() {
				let time = $(this).text();
				$("[data-form=time]").html(time);
			})
	
		   $(document).on("click", "#button-search", function(){
		       let peopleNum = $("#people-num").html();
		       $("[data-form=peopleNum]").html(peopleNum);
		       let price = 0;
		       price = ${fes.PRICE};
		       console.log(price);
		       $("[data-form=fee]").text(price*peopleNum+"원");
			})
			
			// 인원수에 따른 금액 계산
/* 			$(document).on("click", "#button-search", function(){
				let price = ${fes.PRICE};
				let num = $("#people-num").text();
				console.log(price);
				console.log(num);
				
				$("[data-form=fee]").text = price*num;
			}); */
			
		</script>
		
		<script type="text/javascript">
			onload = () => {
				// 인원수 제어
	            let plus = document.querySelector(".plus");
	            let minus = document.querySelector(".minus");
	            let result = document.getElementById("people-num");
	            let i = 0;
	            
	            plus.addEventListener("click", ()=>{
	                i++;
	                result.innerHTML = i;
	            })
	
	            minus.addEventListener("click", () => {
	                if(i>0){
	                    i--;
	                    result.innerHTML = i;
	                } else {
	                    i=0;
	                    result.innerHTML = i;
	                }
	            })
	            
	            // date picker 
	            const getDatePickerTitle = elem => {
	                // From the label or the aria-label
	                const label = elem.nextElementSibling;
	                let titleText = '';
	                if (label && label.tagName === 'LABEL') {
	                titleText = label.textContent;
	                } else {
	                titleText = elem.getAttribute('aria-label') || '';
	                }
	                return titleText;
	            }
	            
	            const elems = document.querySelectorAll('.datepicker_input');
	            let edDateStr = new Date("${fes.SVCOPNENDDT}");
	            let stDateStr = new Date("${fes.SVCOPNBGNDT}");
	            //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            
	            //String edDate = format.format(edDateStr);
	            //String stDate = format.format(stDateStr);
	            
	            console.log(edDateStr);
	            console.log(stDateStr);
	            
	            for (const elem of elems) {
	                const datepicker = new Datepicker(elem, {
	                // 'format': 'dd/mm/yyyy', // UK format
	                'format': 'yyyy-mm-dd', // UK format
	                //maxDate: "2024-10-25",
	                maxDate: edDateStr,
				    minDate: stDateStr,
	                title: getDatePickerTitle(elem)
	                });
	            }
	           	
	            // 17 cal
/* 	            const datep = $("#inline_cal");
	            let dateFormat = "yyyy-mm-dd"
	            
	            for (const date of datep) {
	                const datepicker1 = new Datepicker1(elem, {
	                // 'format': 'dd/mm/yyyy', // UK format
	                'format': 'yyyy-mm-dd', // UK format
	                maxDate: new Date(2024, 9, 25),
				    minDate: new Date(2024, 9, 1),
	                title: getDatePickerTitle(date)
	                });
	            } */
 	            /* $("#result").datepicker({
					
					maxDate: new Date(2024, 9, 25),
				    minDate: new Date(2024, 9, 1),
					dateFormat: dateFormat
				}) */
				
	           
				
        }	 // onload 끝
      
		</script>

		
    </head>
    <body>
        <!-- Responsive navbar-->

        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                <c:choose>
                	<c:when test="${fes.PRICE eq 0}">
                    <div>
                        <i class="bi bi-1-circle" style="font-size:2rem; color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-2-circle" style="font-size:2rem; color: rgb(138, 138, 138);"></i>                        
                    </div>
                    예약 정보 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 예약 완료 <br><br>
                    </c:when>
                    <c:when test="${fes.PRICE ne 0}">
                    <div>
                        <i class="bi bi-1-circle" style="font-size:2rem; color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(0, 123, 255);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-2-circle" style="font-size:2rem; color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-caret-right-fill" style="color: rgb(138, 138, 138);"></i>
                        <i class="bi bi-3-circle" style="font-size:2rem; color: rgb(138, 138, 138);"></i>
                    </div>
                    예약 정보 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예약 결제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 예약
                    완료 <br><br>
                    </c:when>
                  </c:choose>
                    
                    <h1 class="fw-bolder">${SVCNM}</h1>
                    <p class="lead mb-0"></p>
                    
                </div>
            </div>
        </header>
        <!-- Page content-->
        <div class="container">

            <div class="row">
            
                <!-- Blog entries-->
                <div class="col-lg-8">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <div class="content">
                            
                            <div class="container text-left">
                              
                              <div class="row justify-content-center">
                                <div class="col-md-10 text-center">
                                  <h2 class="mb-5 text-center">예약날짜 / 회차 선택</h2>
                                  <!-- calendar 17 -->
                                  <!-- <input type="text" class="form-control w-30 mx-auto mb-3" id="result" placeholder="Select date" disabled="">
                                  <form action="#" class="row">
                                    <div class="col-md-12">
                                      <div id="inline_cal"></div>
                                    </div>
                                  </form>

                                  <!-- vanilla js-date picker -->
	                                 <div class="form-floating mb-4 d-flex">
	                                 <form>
	                                  
	                                  <div class="form-floating">
	                                  	
	                                  <input type = "text" 
	                                  		
	                                         class="datepicker_input form-control w-30 mx-auto mb-3"
	                                         id="datepicker1"
	                                        
                                      >
                                              <label for="datepicker1">날짜 선택</label>
                                             </div>
                                       
	                                  
	                                  
	                                </div> 
	                                </form>
	                                
	                                <!-- <input type = "text" id="datepicker"> -->
 	                                <!-- <input type="text" class="form-control w-30 mx-auto mb-3" id="result" placeholder="Select date" >
	                                <div id="datepicker"> -->
	                                
                                </div>
                              </div>
                                  
                            </div>
                          </div>
                    </div>
                    <!-- Nested row for non-featured blog posts-->
                    <div class="row">
                        <div class="col-lg-15">
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">회차</h2>
                                    <ul>
                                        <li><a href="#!" class="time">1회</a></li>
                                        <li><a href="#!" class="time">2회</a></li>
                                        <li><a href="#!" class="time">3회</a></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-15">
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">이용인원</h2>
                                    <span >일반 / 제한없음</span>
                                    <div class="num">
                                        
                                        <button class="btn btn-primary minus" id="button-search" type="button" style="width: 10%;">-</button>
                                        <span id="people-num" style="padding: 30px;" name="peopleCount">0</span>
                                        <button class="btn btn-primary plus" id="button-search" type="button" style="width: 10%;">+</button>
                                    </div>

                                </div>
                            </div>
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">신청자 정보</h2>
                                    <hr>
                                    <!-- <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p> -->
                                    <!-- 신청자 정보 가져오기 -->
                                     <table>
                                        <tr>
                                        	<th>이름</td><td name="applicantName">${loginUser.user_name}</td>
                                        </tr>
                                        <tr>
                                        	<th>전화</td><td name="applicantTel">${loginUser.user_tel}</td>
                                        </tr>
                                        <tr>
                                        	<th>이메일</td><td name="applicantMail">${loginUser.email}</td>
                                        </tr>

                                     </table>
                                    <!-- <p>이름 : <input type = "text" id="name" name="name"/></p>
                                    <p>전화 : <input type = "text" id="phone" name="phone"/></p> 
                                    <p>이메일 : <input type = "email" id="email" name="email"/></p>   -->
                                    <!-- <a class="btn btn-primary" href="#!">Read more →</a> -->
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-15">
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">동의절차</h2>
                                    <p class="card-text">개인정보 수집 및 이용안내 (필수)</p>
                                    <!-- <a class="btn btn-primary" href="#!">동의합니다</a> -->
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <div class="chk"><input type="checkbox" id="chk1" name = "agreement"><label for="chk1" class="chkLabel">동의합니다</label></div>
                                </div>
                            </div>
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="small text-muted">개인정보 제 3자 제공 (필수)</div>
                                    <h2 class="card-title h4">Post Title</h2>
                                    <p class="card-text">개인정보 제 3자 제공 (필수)</p>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <div class="chk"><input type="checkbox" id="chk2" name="agreement"><label for="chk2" class="chkLabel">동의합니다</label></div>
                                    <!-- <a class="btn btn-primary" href="#!" style="width: 100%;">예약하기</a> -->
                                </div>
                            </div>
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="chkAll">
                                        <input type="checkbox" id="chkAll"><label for="chkAll" class="chkLabel">전체동의</label>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        </div>
                    </div>
                    
                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <form name = "resvForm" method = "post" action = "${path}/front">
			        <input type = "hidden" name = "key" value = "reservation"/>
			        <input type = "hidden" name = "methodName" value = "insert"/>
			        <input type = "hidden" name = "date"/>
			        <input type = "hidden" name = "time"/>
			        <input type = "hidden" name = "peopleNum"/>
			        <input type = "hidden" name = "fee"/>
			        <input type = "hidden" name = "cancleDate"/>
			        <input type = "hidden" name = "SVCID" value = "${SVCID}">
			        <input type = "hidden" name = "SVCNM" value = "${SVCNM}">
                    <div class="card mb-4">
                        <div class="card-header" style="font-weight: bold; font-size: x-large;">나의 예약 정보</div>
                        <div class="card-body" style="background-color: rgb(247, 247, 247);"><h4>행사명</h4>
                        <p>${SVCNM}</p>
                            <p>이용일자</p><p data-form="date" name = "date"></p>
                            <p>이용회차<p class = "selectTime" data-form="time" name = "time"></p>
                            <p>취소기간<p data-form="canclePeriod" name="canclePeriod"></p>
                            <p>취소수수료<p data-form="cancleFee">없음</p>
                            <p>
                            <div style="border: 1px solid white; border-radius: 5%; padding: 15px; background-color: white;">
                                <h5>결제금액</h5><hr>
                                <p>이용인원</p><p data-form="peopleNum" name="peopleNum"></p>
                                <p>이용요금</p><p data-form="fee" name = "fee">0원</p> <!-- 요금 * 인원수 -->
                                <p>할인/할증</p><p data-form="discount">-</p>
                            </div>
                        </div>
                        <div class="card-body" style="background-color: rgb(247, 247, 247);">
                            <div class="input-group">
                                
                                <button class="btn btn-primary" id="button-search" style="width: 100%;" type="button" onClick="sendInsert()">예약하기</button>
                                
                            </div>
                        </div>
                    </div>
                    </form>
                    
                </div>
            </div>
            
        </div>
        <!-- Footer-->
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="${path}/reservation/js/scripts.js"></script>

       <%--  <script src="${path}/reservation/js/jquery-3.3.1.min.js"></script> --%>
       
        <script src="${path}/reservation/js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="${path}/reservation/js/rome.js"></script>
    
        <script src="${path}/reservation/js/main.js"></script>
		
		<script src="${path}/js/reservation.js"></script>
		
		<script type="text/javascript">
			document.querySelector("#chkAll").addEventListener("click", (e) => {
			    document.querySelectorAll("[name=agreement]").forEach((item, index)=>{
			        item.checked = e.target.checked;
			    })
			});
	
			// 등록버튼
			// 유효성 검사 : 날짜 회차 인원
			function sendInsert() {
			    let date = $("[data-form=date]").text().trim();
			    let time = $(".selectTime").text().trim();
			    let peopleNum = $("[data-form=peopleNum]").text();
			    let feeString = $("[data-form=fee]").text();
			    
                let regex = /[^0-9]/g;
                let fee = feeString.replace(regex, "");
			    
			    let cancleDate = $("[data-form=canclePeriod]").text();
                let agreement1 = $("#chk1").is(":checked");
                let agreement2 = $("#chk2").is(":checked");
			    console.log(date);
			    console.log(time);
			    console.log(peopleNum);
			    console.log(fee);
			    console.log(cancleDate);
			    if (date === "") {
                    alert("이용일자를 선택해주세요");
                    return false;
                } else if (time === ""){
                    alert("회차를 선택해주세요");
                    return false;
                } else if (peopleNum === "") {
                    alert("이용인원을 입력해주세요");
                    return false;
                } else if ($("#chk1").is(":checked") !== true) {
                    alert("개인정보 수집 동의가 필요합니다");
                    return false;
                } else if (!agreement2) {
                    alert("개인정보 제 3자 제공 동의가 필요합니다");
                    return false;
                }

                else {
                    document.resvForm.date.value = date;
                    document.resvForm.time.value = time;
                    document.resvForm.peopleNum.value = peopleNum;
                    document.resvForm.fee.value = fee.trim();
                    document.resvForm.cancleDate.value = cancleDate;
                    
                    document.resvForm.submit();
                }
			}
			
		</script>
		<script type="text/javascript">
 		   /* $(function(){
			   let edDateStr = new Date("${fes.SVCOPNENDDT}");
            	let stDateStr = new Date("${fes.SVCOPNBGNDT}");
			   $('#datepicker').datepicker({
				   minDate: stDateStr,
				   maxDate: edDateStr,
				   onSelect: function(){
					   let pickerDate = $.datepicker.formatDate("yy-mm-dd", $("#datepicker").datepicker("getDate"));
					   console.log(pickerDate);
					   $("#result").val(pickerDate);

					   $("[data-form=date]").text(pickerDate);
					   
					   let pickerDate2 = new Date($("#datepicker").datepicker("getDate"));
					   pickerDate2.setDate(pickerDate2.getDate()-1);
					   
					   let formattedDate2 = $.datepicker.formatDate("yy-mm-dd", pickerDate2)
					   $("[data-form=canclePeriod]").html(formattedDate2);
				   }
			   
			   }).datepicker();
			   
/* 			   $("#datepicker").datepicker({
				   minDate: stDateStr,
				   maxDate: edDateStr
			   }).datepicker(); */
			   
			   $('.ui-datepicker').css('font-size', '1.5rem');
			   
		   }) */
		   
		</script>
		

    </body>
</html>