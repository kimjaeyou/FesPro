package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.SuperAuthService;

public class SuperAuthController implements Controller {
	SuperAuthService service = new SuperAuthService();
	
	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		return new ModelAndView("index.jsp", true);
	}
}
