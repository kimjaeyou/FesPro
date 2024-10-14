package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.dto.row;
import wep.mvc.service.MainSereviceImpl;

public class MainController implements Controller {
	MainSereviceImpl mainService = new MainSereviceImpl();


	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app = req.getServletContext();

		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		req.setAttribute("list", list);

		return new ModelAndView("index.jsp");
	}

	public ModelAndView oneSelec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String sid = req.getParameter("sid");
		
		ServletContext app = req.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		
		FesDTO fes = mainService.selecOne(sid,list);
		if(fes!=null)
			req.setAttribute("fes", fes);

		return new ModelAndView("detail.jsp");
	}
	
	
	public ModelAndView setLike(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String sid = req.getParameter("sid");
		String user =(String)req.getSession().getAttribute("loginUser");
		if(user!=null)
			mainService.setLike(sid);
		else
			System.out.println();

		return new ModelAndView("detail.jsp");
	}

}
