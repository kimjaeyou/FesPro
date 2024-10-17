package wep.mvc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.ReservationService;
import wep.mvc.service.ReservationServiceImpl;


public class ReservationAjaxController implements RestController {
	ReservationService service = new ReservationServiceImpl();
	public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	/**
	 * 예약된 회차 인원 수 가져오기
	 */
	public void getReservNum (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("ReservationAjaxController - getReservNum call");
		
		String svcId = request.getParameter("svcId");
		String svcDate = request.getParameter("svcDate");
		List<Integer> list = service.getReservNum(svcId, svcDate);
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(list);
		System.out.println("jsonArr = " + jsonArr);
		
		// 응답
	   	PrintWriter out = response.getWriter();
		out.println(jsonArr);
	}
	

}
