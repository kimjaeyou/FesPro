<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <jsp:include page="/common/header.jsp"/> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="${path}/css/My_styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">전체 회원 조회</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">전체 회원의 목록을 출력합니다</li>
			</ol>

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> 전체 회원 테이블
				</div>
				<div class="card-body">

					<!-- 테이블 -->
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>유저 순번</th>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>나이</th>
								<th>주소</th>
								<th>성별</th>
								<th>이메일</th>
								<th>전화번호</th>
								<th>장애여부</th>
								<th>밴 여부</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<!-- 서버에서 전달된 DTO 데이터를 JSTL로 출력 -->
						</tbody>
						<tfoot>
							<tr>
								<th>유저 순번</th>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>나이</th>
								<th>주소</th>
								<th>성별</th>
								<th>이메일</th>
								<th>전화번호</th>
								<th>장애여부</th>
								<th>밴 여부</th>
							</tr>
						</tfoot>
						
					</table>

				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				// 페이지가 로딩되면 유저 데이터를 가져오는 함수 호출
				loadUsers();
			});
		</script>

		<script>
			function loadUsers() {
				$.ajax({
					url : "${path}/ajax", // 데이터를 가져올 URL
					type : "get",
					data : {
						key : "superAuth",
						methodName : "selectAll"
					},
					dataType : "json",
					success : function(result) {
						alert(result);
						var usersTable = $("#tbody");
						usersTable.empty(); // 테이블 초기화

						// 서버에서 받아온 데이터를 테이블에 추가
						$.each(result, function(index, user) {
							usersTable.append("<tr>" + "<td>" + user.user_seq
									+ "</td>" + "<td>" + user.user_id + "</td>"
									+ "<td>" + user.user_pw + "</td>" + "<td>"
									+ user.user_name + "</td>" + "<td>"
									+ user.age + "</td>" + "<td>" + user.addr
									+ "</td>" + "<td>" + user.gender + "</td>"
									+ "<td>" + user.email + "</td>" + "<td>"
									+ user.user_tel + "</td>" + "<td>"
									+ user.disable + "</td>" + "<td>"
									+ user.user_ben_check + "</td>" + "</tr>");
						});
					},
					error : function(xhr, status, error) {
						console.error("데이터를 불러오는 중 오류 발생: " + error);
					}
				});
			}
		</script>

	</main>

</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
	crossorigin="anonymous"></script>
<script src="${path}/js/datatables-simple-demo.js"></script>
</body>
</html>
