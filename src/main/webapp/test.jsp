<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Notification Page</title>
</head>
<body>
	<h1>Notification: ${param.message}</h1>
</body>

<script type="text/javascript">
	//WebSocket 연결 코드 (JSP 파일 내 script 영역)
	let socket = new WebSocket("ws://localhost:8081/FesPro/websocket");

	socket.onopen = function() {
		console.log("WebSocket connection opened.");
	};

	socket.onmessage = function(event) {
		console.log("Message received: " + event.data);
		// 여기서 알림 UI를 업데이트하는 코드를 작성하면 됩니다.
	};

	socket.onclose = function() {
		console.log("WebSocket connection closed.");
	};
</script>
</html>
