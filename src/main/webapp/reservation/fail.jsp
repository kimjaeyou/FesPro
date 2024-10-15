<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	alert("${requestScope.errMsg}");
	location.href="${path}/user/login.jsp";
</script>
</head>
<body>
	${errMsg}
</body>
</html>