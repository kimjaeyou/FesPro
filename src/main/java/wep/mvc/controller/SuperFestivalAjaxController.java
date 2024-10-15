package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.SuperFestivalService;
import wep.mvc.service.SuperFestivalServiceImpl;


public class SuperFestivalAjaxController implements RestController {
	SuperFestivalService service = new SuperFestivalServiceImpl();
	
	public SuperFestivalAjaxController() {
		System.out.println("형우 / SuperFestivalAjaxController 생성자 Call");
	}
	
	public void detail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("형우 / detail() Call");
		/*
		 * List<FesDTO> festivalList = service.selectAll(); Gson g = new Gson(); String
		 * data = g.toJson(festivalList);
		 * 
		 * PrintWriter out = resp.getWriter(); //out.print("형우 / selectAll 로직");
		 * out.print(data);
		 */
	}
	

}
