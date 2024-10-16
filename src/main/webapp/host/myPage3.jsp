<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<!-- jquery -->
     <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<!-- 차트js  -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- 차트 만들어논 js 파일-->
    <script type="text/javascript" src="${path}/super/festival/chart.js"></script>
    <!-- 부트스트랩 컴포넌트 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/My_styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<script>
   	/* 캔버스엘리먼트 이름으로 찾기 */
    const getCanvas = function(canvasName){
   		return document.getElementById(canvasName).getContext('2d');
    };

    /* 리퀘스트 데이터 - 유저 */
   	const userList = ${requestScope.userList};
   	//console.log(userList);
   		
	/* 리퀘스트 데이터 - 리뷰 */
  	const reviewFunc= function(){
		const reviewList = ${reviewList};
	   	if(reviewList.length===0) return;
	   	
	   	const avg = reviewList.reduce((sum, review) => sum + review.SCORE, 0) / reviewList.length;
	   	//console.log("평균" + avg.toFixed(2));
	   	let data = "";
	   	data += "<h4>";
	   	data += "리뷰 평균 : ";
	   	data += avg.toFixed(2);
	   	data +="</h4>";
	   	
	   	 $("#reviewAvgScore").html(data);
	};
	  	
  	/* 리퀘스트 데이터 - 리뷰쓴 유저 */
	const reviewUserList = ${requestScope.reviewUserList};
  	//console.log(reviewUserList);
	   	 
    	$(function(){
    		reviewFunc();
    		
    		//형우님이 카톡 주시면 여기에 넣기

    		//형
    		
    		/* 차트 Call ============*/
    		//연령, 성별 통계
    		ageGender(getCanvas('ageGender'),userList);
    		//성별 비율
    		genderRatio(getCanvas('genderRatio'),userList);
    		//연령별 비율
    		ageRatio(getCanvas('ageRatio'),userList);
    		
    		//성별별 평균 평점
    		genderReviewAvg(getCanvas('genderReviewAvg'),reviewUserList);
    		
    		//연령별 평균 평점
    		ageReviewAvg(getCanvas('ageReviewAvg'),reviewUserList);
    		
    		
    		/* 등록상태 라디오 */
    	/* 	const fesState = ${fes.getFes_state()};
    		//console.log("등록상태 : " + fesState);
    		if (fesState === 0) {
		    $("#radio_1").prop("checked", true); //승인대기
		} else if (fesState === 2) { //수정대기
		    $("#radio_2").prop("checked", true);
		} else if (fesState === 1) {
		    $("#radio_3").prop("checked", true); //승인완료
		} else if (fesState === 3) {
		    $("#radio_4").prop("checked", true); //비활성화
		} */
    		
    	});
    </script>
</head>
<body>
<div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-white" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">주최자</div>
                            <a class="nav-link" href="${path}/front?key=fes&methodName=select">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                나의 서비스 내역
                            </a>
                            <a class="nav-link" href="${path}/front?key=fes&methodName=myPage2">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                회원 정보 변경
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">나의 서비스 통계</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">내가 주최한 서비스 통계</li>
                        </ol>
                        <!--  
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Primary Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Warning Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Success Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Danger Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        -->
                        <!-- 게시판 영역 -->
                        <%
                        	//세션에서 id 가져오는 일 합니다.
                        %>
                        <div class="container">
                        	<div class="row">


<!-- 캐러셀 -->

			<div id="carouselExample" class="carousel carousel-dark slide">
			  <div class="carousel-inner">
			  
			<div class="carousel-item active">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령, 성별 통계
					</div>
					<div class="card-body">
						<canvas id="ageGender" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>

			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 남녀 비율
					</div>
					<div class="card-body">
						<canvas id="genderRatio" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>

			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 연령대 별 비율
					</div>
					<div class="card-body">
						<canvas id="ageRatio" width="100%" height="40"></canvas>
					</div>
				</div>
			</div>
			
			<div class="carousel-item">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> 성별 별 평균 평점
					</div>
					<div class="card-body">
						<canvas id="genderReviewAvg" width="100%" height="40" ></canvas>
					</div>
				</div>
			</div>
			
			<div class="carousel-item">
				<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i> 연령대 별 평균 평점
						</div>
						<div class="card-body">
							<canvas id="ageReviewAvg" width="100%" height="40"></canvas>
						</div>
					</div>
			</div>
		</div>
			  
			  <!-- 전환 버튼 -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
<!-- 캐러셀 끝 -->
		<h1>리뷰 통계</h1>
		<h4 id="reviewAvgScore"></h4>
		<h4>총 리뷰 수 : ${reviewLength}</h4> </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/My_scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>