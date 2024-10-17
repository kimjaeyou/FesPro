<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Notification Example</title>
</head>
<body>
    <h1>Real-time Notifications</h1>
    <div id="notifications"></div>

    <script>
        const socket = new WebSocket("ws://localhost:8080/your-app/notification");

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
    </script>
</body>
</html>
