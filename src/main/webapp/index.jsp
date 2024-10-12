<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

#head {
	background-image: url("assets/img/Main_bg.png");
	width: 100%;
	height: 27%;
}
#card_main {
	width: 24%;
	height: 400px;
}

#card_img {
	width: 100%;
	height: 30%;
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
						<h1 class="mb-5">서울컬투</h1>

						<form class="form-subscribe" id="contactForm" action="#">
							<div class="row">
								<div class="col">
									<input class="form-control form-control-lg" id="search"
										type="text" placeholder="검색" />
								</div>

								<div class="col-auto">
									<button class="btn btn-primary btn-lg" id="submitButton">Submit</button>
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
												<form action="${path}/front" method="POST">
													<input value="${option.SVCID}" name="sid" type="hidden">
													<input value="main" name="key" type="hidden">
													<input value="selecOne" name="methodName" type="hidden">
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
	<!-- Image Showcases-->
	<section class="showcase">
		<div class="container">
			<h1>추천</h1>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br>
		</div>
	</section>


	<!-- Testimonials-->
	<section class="testimonials text-center bg-light">
		<div class="container">
			<h1>공지사항</h1>
		</div>
	</section>


	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

	<script type="text/javascript">
	let currentPage = 1;
	const itemsPerPage = 4;
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

	</script>
</body>
</html>
