package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.SuperAuthService;
import wep.mvc.service.SuperAuthServiceImpl;


public class SuperAuthAjaxController implements RestController {
	
	SuperAuthService service = new SuperAuthServiceImpl();
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = service.selectAll();
		
		//list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
		  Gson gson = new Gson();
		  String jsonArry = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArry);
		 
	}
	
	public void selectById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsersDTO user = new UsersDTO();
		String id = request.getParameter("id");
		user = service.selectById(id);
		
		//list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
		  Gson gson = new Gson();
		  String jsonUser = gson.toJson(user);
		
		PrintWriter out = response.getWriter();
		out.print(jsonUser);
		 
	}
	

}
