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
	MainSereviceImpl mainService =new MainSereviceImpl();


	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app = req.getServletContext();

		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		List<String> svcnmList = new ArrayList<>();
		
		
		for(FesDTO fes:list) {
			svcnmList.add(fes.getSVCNM());
		}
		
		
		req.setAttribute("list", list);
		req.setAttribute("NameSearch", svcnmList);

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
	
	public void setLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Gson gson = new Gson();
		String sid=request.getParameter("sid");
		UsersDTO user =(UsersDTO)request.getSession().getAttribute("loginUser"); 
		int res=mainService.setLike(sid, user.getUser_seq());
		System.out.println(res);
	}
	
	
	
	
	public ModelAndView review(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		return new ModelAndView("detail.jsp");
	}

}
