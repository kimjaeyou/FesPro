package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MessageAndAlramController implements Controller {

	public ModelAndView mMove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("message/messagePage.jsp", true);
	}

	public void sendAlarm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 좋아요 행사 수정 알림
		
		// 태그 추가 알림
		
		// 사태 변경 알림
		
		// 전체 알림
		
	}
}