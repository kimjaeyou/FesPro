<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	height: 300px;
	border-radius: 10px;
	border-color: gray;
	border-style: double;
	align-content: center;
	text-align: center;
	z-index: 1;
	background-color: ;
}

#yo1 {
	margin-top: 30%;
	font-size: 20px;
}

#yo1 a {
	text-decoration-line: none;
	color: black;
	font: bold;
	border-bottom: 1px black solid;
	border-top: 1px black solid;
}

#messageContainner img {
	width: 100%;
	height: 30%;
}
</style>
</head>
<body>

		<c:choose>
        <c:when test="${not empty loginUser}">
	<div id="messageContainner">
		<img alt="Logo" src="assets/img/FesProLogo_bg.png">
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">MY메세지</a>
		</div>
		<div id="yo1">
			<a href="${path}/user/Reservation.jsp">MY페이지</a>
		</div>
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">Q&A</a>
		</div>
	</div>
	</c:when>
        <c:when test="${not empty logincom}">
	<div id="messageContainner">
		<img alt="Logo" src="assets/img/FesProLogo_bg.png">
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">MY메세지</a>
		</div>
		<div id="yo1">
			<a href="${path}/user/Reservation.jsp">MY페이지</a>
		</div>
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">Q&A</a>
		</div>
	</div>
	</c:when>
	      <c:when test="${empty loginUser}">
	</c:when>
	      <c:when test="${empty logincom}">
	      
		</c:when>
	</c:choose>
</body>
</html>