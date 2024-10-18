package wep.mvc.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.MypageDAO;
import wep.mvc.dao.MypageDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO2;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WALLET;
import wep.mvc.service.MypageService;
import wep.mvc.service.MypageServiceImpl;

public class MypageController implements Controller {

	private MypageService ms = new MypageServiceImpl();
	private MypageDAO md = new MypageDAOImpl();

	// 회원수정 데이터 꺼내기
	public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("loginUserId");
		UsersDTO dbDTO = ms.selectUser(user);
		session.setAttribute("loginUser", new UsersDTO(dbDTO.getUser_id(), dbDTO.getUser_name(), dbDTO.getUser_seq(),
				dbDTO.getEmail(), dbDTO.getUser_tel(), dbDTO.getUser_ben_check()));
		request.setAttribute("users", dbDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/update.jsp");
		return mv;
	}

	// 회원탈퇴
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			int result = ms.delete(id);
			if (result == 1) {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("front?key=main&methodName=read");
				mv.setRedirect(true);
				return mv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원수정
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pwd = request.getParameter("pw");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		String tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-"
				+ request.getParameter("tel3");
		String id = request.getParameter("id");
		UsersDTO dto = new UsersDTO(id, pwd, Integer.parseInt(age), addr, gender, email, name, disable, tel);

		try {
			int result = ms.update(dto);
			if (result == 1) {
				return new ModelAndView("front?key=mypage&methodName=selectUser", true);
			} // 설마 수정이 안될리는 없으니까... 귀찮다...
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 예약내역 전체검색
	public ModelAndView resSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		List<ReservationDTO2> list = ms.resSelectAll(seq);
		request.setAttribute("reservation", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Reservation.jsp");
		return mv;
	}

	// 예약내역 부분검색
	public ModelAndView resSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		String svcnm = request.getParameter("svcnm");
		List<ReservationDTO2> list = ms.resSelect(seq, svcnm);
		request.setAttribute("reservation", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Reservation.jsp");
		return mv;
	}

	// 예약내역 삭제
	public ModelAndView resDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reserv_Seq = request.getParameter("reserv_Seq");
		ms.resDelete(Integer.parseInt(reserv_Seq));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=mypage&methodName=resSelectAll");
		return mv;
	}

	// 리뷰 전체검색
	public ModelAndView reviewSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		List<ReviewDTO2> list = ms.reviewSelectAll(seq);
		request.setAttribute("review", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/review.jsp");
		return mv;
	}

	// 리뷰 부분검색
	public ModelAndView reviewSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		String svcnm = request.getParameter("svcnm");
		System.out.println(seq + " 또는 " + svcnm );
		List<ReviewDTO2> list = ms.reviewSelect(seq, svcnm);
		request.setAttribute("review", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/review.jsp");
		return mv;
	}

	// 리뷰 삭제
	public ModelAndView reviewDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Seq = request.getParameter("review_SEQ");
		ms.reviewDelete(Integer.parseInt(Seq));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=mypage&methodName=reviewSelectAll");
		return mv;
	}

	// 즐겨찾기 전체검색
	public ModelAndView likeSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		List<FesDTO> list = ms.likeSelectAll(seq);
		request.setAttribute("like", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Bookmark.jsp");
		return mv;
	}

	// 즐겨찾기 부분검색
	public ModelAndView likeSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		String svcnm = request.getParameter("svcnm");
		System.out.println(seq + " 또는 " + svcnm);
		List<FesDTO> list = ms.likeSelect(seq, svcnm);
		System.out.println(list);
		request.setAttribute("like", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Bookmark.jsp");
		return mv;
	}

	// 즐겨찾기 삭제
	public ModelAndView likeDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("SVCID");
		int result = ms.likeDelete(seq);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=mypage&methodName=likeSelectAll");
		return mv;
	}

	// 잔액조회
	public ModelAndView balanceSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		WALLET wallet = md.balanceSelect(seq);
		request.setAttribute("money", wallet);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Wallet.jsp");
		return mv;
	}

	// 신원체크 후 잔액 충전하기
	public ModelAndView balancePlus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		String password = request.getParameter("plus-password");
		String amount = request.getParameter("plus-amount");
		int result = ms.balanceCheck(seq, password);
		if (result == 1) {
			WALLET wallet = md.balancePlus(Integer.parseInt(amount), seq);
			request.setAttribute("money", wallet);
		} else {
			// 신원체크 실패
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=mypage&methodName=balanceSelect");
		return mv;
	}

	// 리뷰달기
	public ModelAndView writeReview(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		String reservSeq = request.getParameter("reserv_Seq");
		String svcId = request.getParameter("svc_Id");
		String user_seq = request.getParameter("userSeq");

		int reSeq = Integer.parseInt(reservSeq);
		int seq = dto.getUser_seq();
		int userSeq = Integer.parseInt(user_seq);
		System.out.println("마이페이지 WriteReview 에서 reSeq = " + reSeq + "seq = " + seq);
		boolean reviewExists = ms.checkReview(reSeq, seq);
		System.out.println(reviewExists);

		request.setAttribute("userSeq", user_seq);
		request.setAttribute("svcId", svcId);
		request.setAttribute("reSeq", reSeq);
		request.setAttribute("reviewExists", reviewExists);
		return new ModelAndView("user/reviewWrite.jsp");
	}
}