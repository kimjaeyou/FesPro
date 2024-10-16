package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.MainSereviceImpl;


public class MainAjaxController implements RestController {
	MainSereviceImpl mainService =new MainSereviceImpl();

	public void setLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Gson gson = new Gson();
		String sid=request.getParameter("sid");
		UsersDTO user =(UsersDTO)request.getSession().getAttribute("loginUser"); 
		int res=mainService.setLike(sid, user.getUser_seq());
		String json = gson.toJson(res);
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	public void selecReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Gson gson = new Gson();
		String sid=request.getParameter("sid");
		List<ReviewDTO> res=mainService.selecReview(sid);
		String json = gson.toJson(res);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(json);
	}
	

	

}
