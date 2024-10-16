package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.MainSereviceImpl;

public class MainController implements Controller {
	MainSereviceImpl mainService = new MainSereviceImpl();

	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app = req.getServletContext();

		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");

		UsersDTO user = (UsersDTO) req.getSession().getAttribute("loginUser");
		req.setAttribute("list", list);
		
		if (user != null) {
			int user_seq = user.getUser_seq();
			List<FesDTO> likeList = mainService.selecLike(user_seq, list);
			req.setAttribute("listLike", likeList);
		}

		return new ModelAndView("index.jsp");
	}

	public ModelAndView oneSelec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String sid = req.getParameter("sid");

		ServletContext app = req.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");

		FesDTO fes = mainService.selecOne(sid, list);
		if (fes != null)
			req.setAttribute("fes", fes);

		return new ModelAndView("detail.jsp");
	}

	public ModelAndView review(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		return new ModelAndView("detail.jsp");
	}

}