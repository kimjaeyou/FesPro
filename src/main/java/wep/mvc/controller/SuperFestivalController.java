package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.service.SuperFestivalService;
import wep.mvc.service.SuperFestivalServiceImpl;

public class SuperFestivalController implements Controller {
	SuperFestivalService service = new SuperFestivalServiceImpl();
	
	public SuperFestivalController() {
		System.out.println("형우 / SuperFestivalController 생성자 Call");
	}

	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("형우 / selectAll Call");
		
		List<FesDTO> list =  service.selectAll();
		
		req.setAttribute("festivalList", list);
		return new ModelAndView("super/festival/selectAll.jsp");
	}
	
	public ModelAndView allowFestival(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("형우 / allowFestival Call");
		
		List<FesDTO> list =  service.selectAll();
		
		req.setAttribute("festivalList", list);
		
		return new ModelAndView("super/festival/allowFestival.jsp");
	}
	
	
	

}
