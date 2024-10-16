package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.SuperAuthService;
import wep.mvc.service.SuperAuthServiceImpl;


public class SuperAuthAjaxController implements RestController {
	SuperAuthService service = new SuperAuthServiceImpl();
	
	public void hostWaitSelectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("호스트셀렉트올 컨트롤러");
		List<HostDTO> list = new ArrayList<HostDTO>();
		list = service.hostWaitSelectAll();
		int listNum = list.size();
		System.out.println("컨트롤러에서 호스트list = "+list);
		
		PrintWriter out = response.getWriter(); // out.print("형우 / selectAll 로직");
		out.print(String.valueOf(listNum));
		 
	}
	
}
