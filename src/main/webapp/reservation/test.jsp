<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form name = "resvForm" method = "post" action = "${path}/front">
        <input type = "hidden" name = "key" value = "reservation"/>
        <input type = "hidden" name = "methodName" value = "insert"/>
        <button class="btn btn-primary" id="button-search">예약하기</button>
        <a href="${path}/front?key=reservation&methodName=insert">clicks</a>
        <input type = submit value=제출테스트>
    </form>
	${path}<br>
	${pageContext.request.contextPath}
</body>
</html>