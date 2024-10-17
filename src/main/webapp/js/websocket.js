const socket = new WebSocket("ws://localhost:8081/FesPro/sendNotification");

socket.onmessage = function(event) {
	const notificationDiv = document.getElementById("notifications");
	const message = document.createElement("p");
	message.textContent = event.data;
	notificationDiv.appendChild(message);
};

socket.onopen = function() {
	console.log("WebSocket connection established.");
};

socket.onclose = function() {
	console.log("WebSocket connection closed.");
};