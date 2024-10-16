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

	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
}