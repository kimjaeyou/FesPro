package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.service.ReservationServiceImpl;

public class ReservationController implements Controller {
	ReservationServiceImpl service = new ReservationServiceImpl();
	
	public ReservationController () {
		System.out.println("ReservationController 생성됨..");
	}

	public ModelAndView resv(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 예약 폼에서 입력한 값을 받아 DB에 넣는다
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//
		System.out.println("데이터 이동");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int peopelNum = Integer.parseInt(request.getParameter("peopleNum"));
		int fee = Integer.parseInt(request.getParameter("fee"));
		System.out.println(date + " | " + time + " | " + peopelNum + " | " + fee);
		
		ReservationDTO reservation = new ReservationDTO(1, "1", date, time, peopelNum, fee);
		
		//int result = service.insert(reservation);
		//System.out.println(result);
		
		return new ModelAndView("reservation/resvSuccess.jsp");
	}
	
	/**
	 * 예약 내역 확인 시 유저 seq로 예약 내역을 검색해 가져온다
	 */
	public ModelAndView selectByUserSeq (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		
		return null;
	}
}
