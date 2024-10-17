<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#messageContainner {
	position: fixed;
	left: 90%;
	top: 50%;
	width: 100px;
	height: 400px;
	border-radius: 10px;
	border-color: gray;
	border-style: double;
	align-content: center;
	text-align: center;
	z-index: 1;
	background-color:;
}

#yo1 {
	margin-top: 30%;
	font-size: 20px;
}

#yo1 a {
	text-decoration-line: none;
	color: black;
	font: bold;
}

#messageContainner img {
	width: 100%;
	height: 30%;
}

#messageContainner #messageImg {
	width: 50%;
	height: 10%;
}
</style>
</head>
<body>

	<c:choose>
		<c:when	test="${not empty sessionScope.loginUser && empty sessionScope.loginCom}">
			<div id="messageContainner">
				<img alt="Logo" src="${path}/assets/img/FesProLogo_bg.png">
				<div id="yo1">
					<a href="${path}/front?key=messageAndAlram&methodName=mMove"> <!--  <img id="messageImg" alt="message" src="${path}/assets/img/messageImg/message_0.png"/>-->
						MY메세지
					</a>
				</div>
				<div id="yo1">
					<a href="${path}/front?key=mypage&methodName=resSelectAll">MY페이지</a>
				</div>
				<div id="yo1">
					<a href="${path}/front?key=messageAndAlram&methodName=mMove">Q&A</a>
				</div>
			</div>
		</c:when>
		
		<c:when test="${not empty sessionScope.loginCom && empty sessionScope.loginUser}">
			<div id="messageContainner">
				<img alt="Logo" src="${path}/assets/img/FesProLogo_bg.png">
				<div id="yo1">
					<a href="${path}/front?key=messageAndAlram&methodName=mMove">MY메세지</a>
				</div>
				<div id="yo1">
				<!-- 여기 밑에 있는 두줄은 주석 달면서 사용하시면 됩니다. 지금 좀 에러가 많아서 아무래도 여기서만 바꿔치기 하시면서 사용하셔야 합니다.
					제가 필터 얼른 만들어 보겠습니다..ㅠㅠㅠ 제성합니다 -->
					<!-- <a href="${path}/front?key=fes&methodName=selectAll">MY페이지</a> <!-- 마이페이지 이슈 여기로밖에 안들어가진다. -->
					<a href="${path}/front?key=mypage&methodName=resSelectAll">MY페이지</a>
				</div>
				<div id="yo1">
					<a href="${path}/front?key=messageAndAlram&methodName=mMove">Q&A</a>
				</div>
			</div>
		</c:when>
		<c:when
			test="${empty sessionScope.loginUser && empty sessionScope.loginCom}">
		</c:when>
	</c:choose>
</body>
</html>