package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SuperFestivalAjaxController implements RestController {

	public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("selectAll() Call");
		
        return null;
	}
	

}
