package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.NotificationWebSocket;

public class MessageAndAlramController implements Controller {

	public ModelAndView mMove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("message/messagePage.jsp");
	}

	 public void sendAlarm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String message = req.getParameter("message");
	        NotificationWebSocket.broadcast(message); // 웹소켓을 통해 알림 전송
	        resp.getWriter().write("Alarm sent: " + message);
	    }
}