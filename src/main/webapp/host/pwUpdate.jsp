<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/common/header.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<script>
function checkValid(){
	var f = window.document.pwUpdateForm;
	
	if(f.nowPwIn.value == ""){
		alert("기존 비밀번호를 입력하세요");
		return false;
	}
	 
	
	if(f.newPw.value==""){
		alert("새 비밀번호를 입력하세요");
		
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-white"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">주최자</div>
						<a class="nav-link" href="${path}/front?key=fes&methodName=select">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 나의 서비스 내역
						</a> <a class="nav-link"
							href="${path}/front?key=fes&methodName=myPage2">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 회원 정보 변경
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
					<h1 class="mt-4">나의 정보 내역</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">비밀번호 변경하기</li>
					</ol>
					<div class="container">
						<div class="row">

							<form name="pwUpdateForm" method=post action="${path}/front">
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<thead>
										<tr>
											<th style="background-color: #eeeeee; text-align: center;"
												colspan="2">비밀번호 변경하기</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><p align="center">
													<span>기존 비밀번호 입력하기</span>
												</p></td>
											<td><p align="center">
													<span><b><input type="password" name="nowPwIn"
															id="nowPwIn"
															placeholder="맞는 비밀번호를 입력하고 엔터를 누르면 변경하기 버튼이 생깁니다."
															style="width: 500px" onkeyup="enterKey();"></b></span>
												</p></td>
										</tr>
										<tr>
											<td><p align="center">
													<span>새 비밀번호 입력하기</span>
												</p></td>
											<td><p align="center">
													<span><b><input type="password" name="newPw"
															id="newPw" style="width: 500px"></b></span>
												</p></td>
										</tr>

										<tr>

											<td width="450" height="20" colspan="2" align="center">
												<input type=hidden name="host_seq"
												value="${hostDTO.host_seq}"> <input type=hidden
												name="key" value="fes"> <input type=hidden
												name="methodName" value="pwUpdateForm22">

												<div id="btn">
													<!-- <input type=button
												value="비밀번호 수정하기" onClick="checkValid()"> -->
												</div>
											</td>

										</tr>
									</tbody>
								</table>
							</form>

						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/My_scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script>
function enterKey(){
	console.log("여긴 오니")
	if(window.event.keyCode==13){
		<%String nowPw = (String) request.getAttribute("nowPw");%>
		let nowPw = '<%=nowPw%>';

				//console.log(nowPwIn.value);

				if (nowPw == nowPwIn.value) {

					let btn = document.getElementById("btn");
					btn.innerHTML = "<input type='submit' value='비밀번호 수정하기' onClick='return checkValid()'>"
				}else{
					alert('기존 비밀번호가 틀렸습니다');
				}
			}
		}
	</script>
</body>
</html>
