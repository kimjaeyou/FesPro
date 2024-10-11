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

a {
	text-decoration-line: none;
	color: black;
	font: bold;
	border-bottom: 1px black solid;
	border-top: 1px black solid;
}

img {
	width: 80px;
	height: 80px;
}
</style>
</head>
<body>
	<div id="messageContainner">
		<img alt="Logo" src="assets/img/FesProLogo_bg.png">
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">MY메세지</a>
		</div>
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">MY페이지</a>
		</div>
		<div id="yo1">
			<a href="${path}/front?key=messageAndAlram&methodName=mMove">Q&A</a>
		</div>
	</div>
</body>
</html>