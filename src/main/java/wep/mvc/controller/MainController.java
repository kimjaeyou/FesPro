package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.dto.row;

public class MainController implements Controller {

	public ModelAndView send(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
	
	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app= req.getServletContext();
		ListPublicReservationCulture list= (ListPublicReservationCulture)app.getAttribute("fesList");

		req.setAttribute("list", list);
		
		return new ModelAndView("index.jsp");
	}
	
}
