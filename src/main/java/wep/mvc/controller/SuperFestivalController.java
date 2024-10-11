package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuperFestivalController implements Controller {
	public SuperFestivalController() {
		System.out.println("SuperFestivalController 생성자 Call");
	}

	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("selectAll() Call");
		
        return null;
	}

}
