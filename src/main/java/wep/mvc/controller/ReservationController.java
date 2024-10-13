package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.service.ReservationService;
import wep.mvc.service.ReservationServiceImpl;

public class ReservationController implements Controller {
	ReservationService service = new ReservationServiceImpl();
	
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
		
		ReservationDTO reservation = new ReservationDTO(1, null, date, time, peopelNum, fee);
		
		int result = service.insert(reservation);
		System.out.println(result);
		
		if(result != 0) {
			return new ModelAndView("reservation/resvSuccess.jsp");
		} else {
			return new ModelAndView("reservation/fail.jsp");
		}
		
	}
	
	/**
	 * 예약 내역 확인 시 유저 seq로 예약 내역을 검색해 가져온다
	 */
	public ModelAndView selectByUserSeq (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		
		return null;
	}
	
	/**
	 * 예약 직후 내역 확인 시 예약번호로 예약 내역을 검색해 가져온다
	 */
	public ModelAndView selectByResvSeq (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//
		int resvSeq = Integer.parseInt(request.getParameter("resvSeq"));
		ReservationDTO resvDTO = service.selectByResvSeq(resvSeq);
		request.setAttribute("resvDTO", resvDTO);
		
		// 예약번호로 검색 후 SVCID를 이용해 Festival 정보 가져온다
		
		
		if(resvDTO != null) {
			return new ModelAndView("reservation/resvDetail.jsp", false);
		} else {
			return new ModelAndView("reservation/fail.jsp", true);
		}
	}
	
	/**
	 * 예약 데이터 SVCID로 검색
	 */
	public ModelAndView selectBySVCID (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// 정보 담아올 parameter 필요 
		String svcId = request.getParameter(null);
		ReservationDTO resvDTO = service.selectBySVCID(svcId);
		if (resvDTO != null) {
			return new ModelAndView();
		} else {
			return new ModelAndView();
		}
	}
	
}
