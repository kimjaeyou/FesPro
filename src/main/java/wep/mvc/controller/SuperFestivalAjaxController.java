package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
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
	
	
	public void waitAcceptSelectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("재구 / selectAll() Call");

		List<FesDTO> festivalList = service.dashFesSelectAll();
		int fesListNum = festivalList.size();
		System.out.println(fesListNum);

		PrintWriter out = resp.getWriter(); // out.print("형우 / selectAll 로직");
		out.print(String.valueOf(fesListNum));

	}
	
	public void waitUpdateSelectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("재구 / selectAll() Call");

		List<FesDTO> festivalList = service.dashFesWaitFesSelectAll();
		int fesListNum = festivalList.size();
		System.out.println(fesListNum);

		PrintWriter out = resp.getWriter(); // out.print("형우 / selectAll 로직");
		out.print(String.valueOf(fesListNum));

	}
	
	public void getPendingCancelCount(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("재구 / selectAll() Call");

		List<FesDTO> festivalList = service.dashFesCancleWaitFesSelectAll();
		int fesListNum = festivalList.size();
		System.out.println(fesListNum);

		PrintWriter out = resp.getWriter(); // out.print("형우 / selectAll 로직");
		out.print(String.valueOf(fesListNum));

	}
	 
	

}