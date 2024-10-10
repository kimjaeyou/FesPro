<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Blog Home - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />


        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500&display=swap" rel="stylesheet">
    
        
        <link rel="stylesheet" href="fonts/icomoon/style.css">
    
        <link rel="stylesheet" href="css/rome.css">
        
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <!-- Style -->
        <link rel="stylesheet" href="css/style2.css">

        <style>
            .num {text-align: right;}
            .chk {text-align: right; display: flex; justify-content: flex-end;}
            #chk {margin-right: 5px; zoom: 1.5;}
            .chkLabel {margin: 0;}

        </style>


        <script>
            onload = () => {
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
            }

        </script>


    </head>
    <body>
        <!-- Responsive navbar-->

        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">문화행사 체험 예약 페이지</h1>
                    <p class="lead mb-0">기타내용</p>
                </div>
            </div>
        </header>
        <!-- Page content-->
        <div class="container">
        <form>
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
                                  <input type="text" class="form-control w-30 mx-auto mb-3" id="date" placeholder="Select date" disabled="">
                                  <form action="#" class="row">
                                    <div class="col-md-12">
                                      <div id="inline_cal"></div>
                                    </div>
                                  </form>
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
                                        <li><a href="#!">1회</a></li>
                                        <li><a href="#!">2회</a></li>
                                        <li><a href="#!">3회</a></li>
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
                                        <span id="people-num" style="padding: 30px;" name="peopleNum">0</span>
                                        <button class="btn btn-primary plus" id="button-search" type="button" style="width: 10%;">+</button>
                                    </div>

                                </div>
                            </div>
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">신청자 정보</h2>
                                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla.</p>
                                    <a class="btn btn-primary" href="#!">Read more →</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-15">
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <h2 class="card-title h4">동의절차</h2>
                                    <p class="card-text">개인정보 수집 및 이용안내 (필수)</p>
                                    <a class="btn btn-primary" href="#!">동의합니다</a>
                                    <div class="chk"><input type="checkbox" id="chk"><label for="chk" class="chkLabel">동의합니다</label></div>
                                </div>
                            </div>
                            <!-- Blog post-->
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div class="small text-muted">개인정보 제 3자 제공 (필수)</div>
                                    <h2 class="card-title h4">Post Title</h2>
                                    <p class="card-text">개인정보 제 3자 제공 (필수)</p>
                                    <a class="btn btn-primary" href="#!" style="width: 100%;">예약하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
                        <div class="card-header" style="font-weight: bold; font-size: x-large;">나의 예약 정보</div>
                        <div class="card-body" style="background-color: rgb(247, 247, 247);"><h4>행사명</h4>
                            <p>이용일자</p><p>이용회차<p>취소기간<p>취소수수료<p>
                            <div style="border: 1px solid white; border-radius: 5%; padding: 15px; background-color: white;">
                                <h5>결제금액</h5><hr>
                                <p>이용인원</p>
                                <p>이용요금</p>
                                <p>할인/할증</p>
                            </div>
                        </div>
                        <div class="card-body" style="background-color: rgb(247, 247, 247);">
                            <div class="input-group">
                                
                                <button class="btn btn-primary" id="button-search" type="button" style="width: 100%;">예약하기</button>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            </form>
        </div>
        <!-- Footer-->
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/rome.js"></script>
    
        <script src="js/main.js"></script>
    </body>
</html>
