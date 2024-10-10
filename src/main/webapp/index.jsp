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
	width: 400px;
	height: 250px;
}
</style>
</head>
<body>
	<!-- Navigation-->

	<!-- Masthead-->
	<header class="masthead">
		<div class="container position-relative">
			<div class="row justify-content-center">
				<div class="col-xl-6">
					<div class="text-center text-white">
						<!-- Page heading-->
						<h1 class="mb-5">문화 체험 행사</h1>
						<!-- Signup form-->
						<!-- * * * * * * * * * * * * * * *-->
						<!-- * * SB Forms Contact Form * *-->
						<!-- * * * * * * * * * * * * * * *-->
						<!-- This form is pre-integrated with SB Forms.-->
						<!-- To make this form functional, sign up at-->
						<!-- https://startbootstrap.com/solution/contact-forms-->
						<!-- to get an API token!-->


						<form class="form-subscribe" id="contactForm"
							data-sb-form-api-token="API_TOKEN">
							<!-- Email address input-->
							<div class="row">
								<div class="col">
									<input class="form-control form-control-lg" id="search"
										type="email" placeholder="검색" />

								</div>
								<div class="col-auto">
									<button class="btn btn-primary btn-lg disabled"
										id="submitButton" type="submit">Submit</button>
								</div>
							</div>
							<!-- Submit success message-->
							<!---->
							<!-- This is what your users will see when the form-->
							<!-- has successfully submitted-->
							<div class="d-none" id="submitSuccessMessage">
								<div class="text-center mb-3">
									<div class="fw-bolder">Form submission successful!</div>
									<p>To activate this form, sign up at</p>
									<a class="text-white"
										href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
								</div>
							</div>
							<!-- Submit error message-->
							<!---->
							<!-- This is what your users will see when there is-->
							<!-- an error submitting the form-->
							<div class="d-none" id="submitErrorMessage">
								<div class="text-center text-danger mb-3">Error sending
									message!</div>
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
				<c:if test="${not empty list}">
					<div class="container">
						<!-- Cards container for pagination -->
						<div id="card-container"
							class="row gx-4 gx-lg-5 justify-content-center">
							<c:forEach items="${list.row}" var="option" varStatus="status">
								<!-- Ensure the columns take equal width and display horizontally -->
								<div class="col-md-3 mb-5 card-item">
									<div class="card h-100">
										<!-- Product image-->
										<img class="card-img-top" src="${option.IMGURL}" alt="..." />
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
												<form action="#" method="POST">
													<input value="${option.SVCID}" name="movieCd" type="hidden">
													<input value="${option.SVCNM}" name="title" type="hidden">
													<input class="btn btn-outline-dark mt-auto" type="submit"
														name="View options" value="더보기">
												</form>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>

					<!-- Pagination controls -->
					<div
						class="pagination-controls d-flex justify-content-between align-items-center mt-3">
						<input type="hidden" id="page-info" class="text-center" value="1">
					</div>
					<button class="btn btn-dark" onclick="prevPage()">이전</button>
					<button class="btn btn-dark" onclick="nextPage()">다음</button>
			</div>
			</c:if>

		</div>




		</div>
	</section>
	<!-- Image Showcases-->
	<section class="showcase">
		<div class="container-fluid p-0"></div>
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
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
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

	    document.getElementById('page-info').textContent = page;
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
