<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="UTF-8">
<jsp:include page="/common/header.jsp" />
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Landing Page - Start Bootstrap Theme</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<style type="text/css">
img {
	width: 40%;
	height: 100%;
}
/*배경 이미지 설정 스타일 */
#head {
	background-image: url("assets/img/Main_bg.png");
	width: 100%;
	height: 32%;
	background-size: cover;
	background-position: 50% 50%;
}

#card_main {
	width: 30%;
	height: 400px;
}

#card_img {
	width: 100%;
	height: 30%;
}

.searchRES {
	position: absolute;
	width: 95%;
	border: 1px solid gray;
	background-color: white;
	display: none;
	z-index: 10000;
}

.searchRES div {
	display: none;
	color: black;
	font: 20px;
}

#serach {
	color: black;
}

#likeArea {
	position: relative;
}

.con_table {
	display: table;
}

.con_row {
	display: table-row;
}

.con_row img {
	width: 350px;
	height: 200px;
}

.con_cell {
	border: 1px solid #DCEBE6;
	border-radius: 20px;
	align-content: center;
	text-align: center;
	align-items: center;
	display: table-cell;
	width: 40%;
	font-size: 20px;
	font: bold;
	font-family: Roboto;
	color: black;
}

#con_name span {
	margin-bottom: 5px;
	font-size: 30px;
	color: #371AFC;
}

#con_name {
	background-color: #A2DE96;
}

#con_p_name {
	font-size: 25px;
}

#con_p_name span {
	margin-bottom: 5px;
	font-size: 20px;
	color: #371AFC;
}

.container {
	padding: 2px;
}
</style>

</head>
<body>
	<jsp:include page="/common/alarm.jsp" />
	<!-- Masthead-->
	<header class="masthead" id="head">
		<div class="container position-relative">
			<div class="row justify-content-center">
				<div class="col-xl-6">
					<div class="text-center text-white">
						<!-- Page heading-->
						<h1 class="mb-5">-</h1>
						<form class="form-subscribe" id="contactForm" action="front">
							<div class="row">
								<div class="col" id="searchSelec">
									<input class="form-control form-control-lg" id="search"
										type="text" placeholder="검색" />
									<div id="item" class="searchRES">
										<input type="hidden" name="key" value="main" /> <input
											type="hidden" name="methodName" value="oneSelec" /> <input
											id="selecSVCID" type="hidden" name="sid" value=" " />
										<c:forEach items="${list}" var="option" varStatus="status">
											<div id="selectSearch" class="item"
												data-item="${option.SVCID}">${option.SVCNM}</div>
										</c:forEach>
									</div>
								</div>
								<div class="col-auto">
									<button class="btn btn-primary btn-lg" id="submitButton">검색</button>
								</div>
								<div></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Icons Grid-->
	<section class="features-icons bg-light text-center">
		<div class="container">
			<div class="container px-4 px-lg-5 mt-5">
				<h1>행사 목록</h1>
				<br>
				<c:if test="${not empty list}">
					<div id="cardContent" class="container position-relative">
						<!-- Cards container for pagination -->
						<div id="card-container"
							class="row gx-4 gx-lg-5 justify-content-center">
							<c:forEach items="${list}" var="option" varStatus="status">
								<!-- Ensure the columns take equal width and display horizontally -->
								<div class="col-md-3 mb-5 card-item" id="card_main">
									<div class="card h-100">
										<!-- Product image-->
										<img id="card_img" class="card-img-top" src="${option.IMGURL}"
											alt="..." />
										<!-- Product details-->
										<div class="card-body p-4">
											<div class="text-center">
												<!-- Product name-->
												<h5 class="fw-bolder">${option.SVCNM}</h5>
												<!-- Product price-->
												${option.MINCLASSNM}
											</div>
										</div>
										<!-- Product actions-->
										<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
											<div class="text-center">
												<form action="${path}/front" method="post">
													<input type="hidden" name="key" value="main" /> <input
														type="hidden" name="methodName" value="oneSelec" /> <input
														value="${option.SVCID}" name="sid" type="hidden">
													<input class="btn btn-outline-dark mt-auto" type="submit"
														name="View options" value="더보기">
												</form>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

						<!-- Pagination controls: previous and next -->
						<button id="direcBtn"
							class="btn btn-dark position-absolute start-0 top-50 translate-middle-y"
							onclick="prevPage()">이전</button>
						<button id="direcBtn"
							class="btn btn-dark position-absolute end-0 top-50 translate-middle-y"
							onclick="nextPage()">다음</button>
					</div>
				</c:if>

			</div>

		</div>
	</section>
	<!-- 추천 목록 -->
	<section class="features-icons bg-light text-center" id=likeArea>
		<div class="container">
			<div class="container px-4 px-lg-5 mt-5">
				<h1>추천 목록</h1>
				<br>
				<div class="con_table">
					<c:if test="${not empty listLike}">
						<c:forEach items="${listLike}" var="option" varStatus="status">
							<div class="con_row" id="${option.SVCID}">
								<img src="${option.IMGURL}" class="con_cell">
								<div class="con_cell" id="con_name">
									<span>${option.MINCLASSNM}</span><br>${option.SVCNM}</div>
								<div class="con_cell" id="con_p_name">${option.PLACENM}<br>
									<span>${option.RCPTBGNDT}~</span>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>

				<!-- Like List Pagination Controls -->
				<div class="pagination-controls-like">
					<button id="prevLikeBtn"
						class="btn btn-dark position-absolute start-0 top-50 translate-middle-y"
						style="margin-left: 15%;" onclick="prevLikePage()">이전</button>
					<button id="nextLikeBtn"
						class="btn btn-dark position-absolute end-0 top-50 translate-middle-y"
						style="margin-right: 15%;" onclick="nextLikePage()">다음</button>
				</div>
			</div>
		</div>

	</section>


	<!-- Testimonials-->
	<section class="testimonials text-center bg-light">
		<div class="container">
			<br>
			<h1>공지사항</h1>
			<br>
			<div class="content">
            <div class="row">
                <table style="text-align: center; border: 2px solid #dddddd !important; background-color: white">
                    <thead>
                        <tr>
                            <th style="background-color: #eeeeee; text-align: center;">번호</th>
                            <th style="background-color: #eeeeee; text-align: center;">제목</th>
                            <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="post" items="${noti}">
                            <tr>
                                <td>${post.boardSeq}</td>
                                <td><a href="${path}/front?key=board&methodName=select">${post.sub}</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty post.userSeq}">
                                            ${post.userSeq}
                                        </c:when>
                                        <c:when test="${not empty post.hostSeq}">
                                            ${post.hostSeq}
                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
		</div>
	</section>


	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<!-- <script src="js/scripts.js"></script> -->

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>



	<script type="text/javascript">
   $('.con_row').click(function(){
      let SVCid=$(this).attr('id');
      location.replace('front?key=main&methodName=oneSelec&sid='+SVCid);
   })
   
   let value, name, item, i;
   
   $('#search').keyup(function(){
      value = document.getElementById("search").value;
        item = document.getElementsByClassName("item");
        document.getElementById("item").style.display="block";
        for(i=0;i<item.length;i++){
            item[i].style.display = "none";
        }

        for(i=0;i<item.length;i++){
         if(item[i].innerText.indexOf(value)!=-1 && value !== ""){
            
            item[i].style.display = "block";
         }
          
        }

	})
	
	$('#search').blur(function(){
		document.getElementById("item").style.display="none";
	});
	
	$(document).on('mouseover', '.item', function() {
		let str=$(this).text();
		document.getElementById('selecSVCID').value = $(this).attr('data-item');
		document.getElementById("search").value ="";
 		document.getElementById("search").value = str;
	});
   
   let currentPage = 1;
   const itemsPerPage = 3;
   const items = document.querySelectorAll('.card-item');
   const totalItems = items.length;
   const totalPages = Math.ceil(totalItems / itemsPerPage);

   function showPage(page) {
       const start = (page - 1) * itemsPerPage;
       const end = start + itemsPerPage;
       
       items.forEach((item, index) => {
           item.style.display = (index >= start && index < end) ? 'block' : 'none';
       });

   }

   // 초기 페이지 로드
   showPage(currentPage);

   function nextPage() {
       if (currentPage < totalPages) {
           currentPage++;
           showPage(currentPage);
       }
   }

   function prevPage() {
       if (currentPage > 1) {
           currentPage--;
           showPage(currentPage);
       }
   }
   
   
   
   $(document).ready(function() {
       const itemsPerPageLike = 3;  // 한 페이지에 보여줄 아이템 수 (Like 리스트)
       let currentPageLike = 1;     // 현재 Like 리스트 페이지 번호
       const itemsLike = $('.con_row'); // 모든 con_row_like 요소들을 가져옴
       const totalItemsLike = itemsLike.length; // 총 Like 리스트 아이템 수
       const totalPagesLike = Math.ceil(totalItemsLike / itemsPerPageLike); // 전체 Like 리스트 페이지 수 계산

       // 초기 페이지 로드
       showLikePage(currentPageLike);

       // 페이지에 해당하는 콘텐츠만 보여주는 함수 (Like 리스트 전용)
       function showLikePage(page) {
           const start = (page - 1) * itemsPerPageLike;
           const end = start + itemsPerPageLike;

           itemsLike.hide(); // 모든 Like 리스트 콘텐츠 숨기기
           itemsLike.slice(start, end).show(); // 현재 페이지의 콘텐츠만 표시

           // Like 리스트 버튼 활성화/비활성화 처리
           $('#prevLikeBtn').prop('disabled', page === 1);
           $('#nextLikeBtn').prop('disabled', page === totalPagesLike);
       }

       // 다음 페이지로 이동하는 함수 (Like 리스트 전용)
       function nextLikePage() {
           if (currentPageLike < totalPagesLike) {
               currentPageLike++;
               showLikePage(currentPageLike);
           }
       }

       // 이전 페이지로 이동하는 함수 (Like 리스트 전용)
       function prevLikePage() {
           if (currentPageLike > 1) {
               currentPageLike--;
               showLikePage(currentPageLike);
           }
       }

       // 버튼 클릭 시 함수 연결 (Like 리스트 전용)
       $('#nextLikeBtn').click(nextLikePage);
       $('#prevLikeBtn').click(prevLikePage);
   });

   
   </script>



</body>
</html>