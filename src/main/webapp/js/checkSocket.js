let socket = new WebSocket("ws://localhost:8081/FesPro/websocket");

// 연결이 열렸을 때
socket.onopen = function() {
	console.log("WebSocket connection opened.");
};

// 메시지를 받았을 때
socket.onmessage = function(event) {
	console.log("Message received: " + event.data);
	showNotification(event.data);  // 받은 메시지를 표시하는 함수 호출
};

// 연결이 닫혔을 때
socket.onclose = function() {
	console.log("WebSocket connection closed.");
};

// 알림을 표시하는 함수
function showNotification(message) {
	// 메시지 내용을 알림 영역에 추가
	document.getElementById("messageContent").textContent = message;
	// 알림 영역을 표시
	document.getElementById("notifications").style.display = "block";
}

// 알림 영역을 숨기는 함수
function hideNotification() {
	document.getElementById("notifications").style.display = "none";
}