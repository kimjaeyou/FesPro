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
	background-image: url("${path}/assets/img/Main_bg.png");
	width: 100%;
	height: 300px;
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
						<form class="form-subscribe" id="contactForm" action="front">
							<div class="row">
								<div class="col" id="searchSelec">
									<input class="form-control form-control-lg" id="search"
										type="text" placeholder="검색" />
									<div id="item" class="searchRES">
										<input type="hidden" name="key" value="main" /> <input
											type="hidden" name="methodName" value="oneSelec" /> <input
											id="selecSVCID" type="hidden" name="sid" value=" " />
										<c:forEach items="${fesList}" var="option" varStatus="status">
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
		<div class="container mt-5">
			<h1>알람 메시지</h1>
			<div id="alarmContainer" class="alert alert-info" role="alert"
				style="display: none;">
				<ul id="alarmList"></ul>
			</div>
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
		document.getElementById('selecSVCID').value = $(this).attr('data-item');
 		document.getElementById("search").value = $(this).text();
	});

	
	
	
	let currentPage = 1;
	const itemsPerPage = 6;
	const items = document.querySelectorAll('.card-item');
	const totalItems = items.length;
	const totalPages = Math.ceil(totalItems / itemsPerPage);
	const paginationNumbers = document.getElementById('pagination-numbers');

	function showPage(page) {
	    const start = (page - 1) * itemsPerPage;
	    const end = start + itemsPerPage;
	    
	    items.forEach((item, index) => {
	        item.style.display = (index >= start && index < end) ? 'block' : 'none';
	    });

	    // 버튼 활성화/비활성화 처리
	    document.getElementById('prevBtn').disabled = (page === 1);
	    document.getElementById('nextBtn').disabled = (page === totalPages);

	    // 페이지 번호 스타일링 업데이트
	    document.querySelectorAll('.pagination-number').forEach((button, index) => {
	        button.classList.toggle('active', index + 1 === page);
	    });
	}

	function createPaginationNumbers() {
	    paginationNumbers.innerHTML = ''; // 기존 페이지 번호 초기화
	    for (let i = 1; i <= totalPages; i++) {
	        const pageNumberButton = document.createElement('button');
	        pageNumberButton.className = 'pagination-number btn btn-outline-dark';
	        pageNumberButton.innerText = i;
	        pageNumberButton.addEventListener('click', function () {
	            currentPage = i;
	            showPage(currentPage);
	        });
	        paginationNumbers.appendChild(pageNumberButton);
	    }
	}

	// 초기 페이지 및 페이징 번호 생성
	createPaginationNumbers();
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
