package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WALLET;
import wep.mvc.service.MainSereviceImpl;
import wep.mvc.service.ReservationService;
import wep.mvc.service.ReservationServiceImpl;

public class ReservationController implements Controller {
	ReservationService service = new ReservationServiceImpl();
	MainSereviceImpl mainService = new MainSereviceImpl();
	
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
		String cancleDate = request.getParameter("cancleDate");
		System.out.println(date + " | " + time + " | " + peopelNum + " | " + fee + " | " + cancleDate);
		
		String SVCID = request.getParameter("SVCID");
		String SVCNM = request.getParameter("SVCNM");
		System.out.println(SVCNM);
		
		HttpSession session = request.getSession();
	    UsersDTO userDTO = (UsersDTO)session.getAttribute("loginUser");
		System.out.println(userDTO);
		
		ReservationDTO reservation = null;

		// 예약인원 다 찼는지 체크
		
		
		if(fee == 0) {
			reservation = new ReservationDTO(userDTO.getUser_seq(), SVCID, date, time, peopelNum, fee, 1, cancleDate);
		} else {
			reservation = new ReservationDTO(userDTO.getUser_seq(), SVCID, date, time, peopelNum, fee, 2, cancleDate);
		}
		
		int result = service.insert(reservation);
		//System.out.println(result);
		
	    
		ReservationDTO resvData = service.selectByUserSeqAndSVCID(userDTO.getUser_seq(), SVCID);
		System.out.println("resvDate = " + resvData);
		request.setAttribute("resvData", resvData);
		request.setAttribute("SVCNM", SVCNM);
		
		
		if(result != 0 && fee == 0) {
			return new ModelAndView("reservation/resvSuccess.jsp", false);
		} else if (result != 0 && fee != 0) {
			return new ModelAndView("reservation/resvSuccessPay.jsp", false);
		} else {
			return new ModelAndView("reservation/fail.jsp");
		}
		
	}
	
	/**
	 * 예약 내역 확인 시 유저 seq로 예약 내역을 검색해 가져온다
	 */
	public ModelAndView selectByUserSeq (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//
		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		ReservationDTO resvDTO = service.selectByUserSeq(userSeq);
		request.setAttribute("resvDTO", resvDTO);
		
		// 연결할 페이지
		if (resvDTO != null) {
			return new ModelAndView();
		} else {
			return new ModelAndView();
		}
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
		FesDTO fesDTO = service.selectBySVCIDFes(resvDTO.getSVCID());
		request.setAttribute("fesDTO", fesDTO);
		
		// userSeq로 유저정보 검색해서 유저정보 가져온다
		UsersDTO userDTO = service.selectUser(resvDTO.getUserSeq());
		request.setAttribute("userDTO", userDTO);
		
		// application이 가지고 있는 fes 정보 가져오기
		ServletContext app = request.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		
		FesDTO fes = mainService.selecOne(resvDTO.getSVCID(), list);
		if(fes!=null)
			request.setAttribute("fes", fes);
		
		if(resvDTO != null && fesDTO != null) {
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
		ReservationDTO resvDTO = service.selectBySVCIDRes(svcId);
		if (resvDTO != null) {
			return new ModelAndView();
		} else {
			return new ModelAndView();
		}
	}

	/**
	 * 예약 페이지로 이동시 서비스 이름과 ID 가져가기
	 */
	public ModelAndView revMove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		HttpSession session = request.getSession();
	    UsersDTO userDTO = (UsersDTO)session.getAttribute("loginUser");
	    String path = request.getContextPath();
	    
	    if(userDTO == null) {
	    	request.setAttribute("errMsg", "로그인 후 이용해주세요");
			return new ModelAndView("reservation/needsLogin.jsp");
	    }
		
		String SVCNM = request.getParameter("SVCNM");
		String SVCID = request.getParameter("SVCID");
		String fesDTO = request.getParameter("fes");
		
		FesDTO fes = service.selectFes(SVCID);
		
		request.setAttribute("SVCNM", SVCNM);
		request.setAttribute("SVCID", SVCID);
		request.setAttribute("fes", fes);
		return new ModelAndView("reservation/reservation.jsp", false);

	}
	
	/**
	 * SVCID로 FesDTO 가져오기
	 */
	public ModelAndView selectFes (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String SVCID = request.getParameter("SVCID");
		FesDTO fes = service.selectFes(SVCID);
		
		request.setAttribute("fes", fes);
		
		return new ModelAndView("reservation/reservation.jsp", false);
	}
	
	/**
	 * 결제하기 누르면 지갑에서 차감
	 */
	public ModelAndView payment (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String SVCID = request.getParameter("SVCID");
		String SVCNM = request.getParameter("SVCNM");
		int fee = Integer.parseInt(request.getParameter("fee"));
		int resvSeq = Integer.parseInt(request.getParameter("resvSeq"));
		
		HttpSession session = request.getSession();
	    UsersDTO userDTO = (UsersDTO)session.getAttribute("loginUser");
		System.out.println(userDTO);
		
		WALLET wallet = service.payment(userDTO.getUser_seq(), fee);
		
		System.out.println("결제 후 남은 금액 : " + wallet.getMONEY());
		

		// 예약상태 : 결제 대기 - 예약완료로 변경
		int result = service.changeReservation(resvSeq);
		
		ReservationDTO resvDTO = service.selectByResvSeq(resvSeq);
		request.setAttribute("resvData", resvDTO);
		request.setAttribute("SVCNM", SVCNM);
		
		//request.setAttribute("fes", fes);
		
		if (wallet != null && result != 0) {
			return new ModelAndView("reservation/reservPayComplete.jsp", false);
		} else {
			return new ModelAndView("reservation/fail.jsp");
		}
		
	}
	
	/**
	 * 확인증
	 */
	
	
	/**
	 * 마이 페이지 - 예약 상세
	 */
	public ModelAndView viewDetail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int resvSeq = Integer.parseInt(request.getParameter("reserv_Seq"));
		ReservationDTO resvDTO = service.selectByResvSeq(resvSeq);
		request.setAttribute("resvDTO", resvDTO);
		
		// 예약번호로 검색 후 SVCID를 이용해 Festival 정보 가져온다
		FesDTO fesDTO = service.selectBySVCIDFes(resvDTO.getSVCID());
		request.setAttribute("fesDTO", fesDTO);
		
		HttpSession session = request.getSession();
	    UsersDTO userDTO = (UsersDTO)session.getAttribute("loginUser");
	    request.setAttribute("userDTO", userDTO);
		
		// application이 가지고 있는 fes 정보 가져오기
		ServletContext app = request.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		
		FesDTO fes = mainService.selecOne(resvDTO.getSVCID(), list);
		if(fes!=null)
			request.setAttribute("fes", fes);
		
		if(resvDTO != null && fesDTO != null) {
			return new ModelAndView("user/resvDetail.jsp", false);
		} else {
			request.setAttribute("errMsg", "예약 내역 가져오기 실패");
			return new ModelAndView("reservation/fail.jsp", true);
		}
	}
	
	
}

