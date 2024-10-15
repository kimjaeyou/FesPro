package wep.mvc.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.MypageService;
import wep.mvc.service.MypageServiceImpl;

public class MypageController implements Controller {

	private MypageService ms = new MypageServiceImpl();

	// 예약내역 전체검색
	public ModelAndView resSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		UsersDTO dto = (UsersDTO) session.getAttribute("loginUser");
		int seq = dto.getUser_seq();
		System.out.println("seq = " + seq); // 데이터 나옴

		List<ReservationDTO2> list = ms.resSelectAll(seq);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("reservation", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Reservation.jsp");
		mv.setRedirect(true);
		return mv;
	}

	// 예약내역 부분검색
	public ModelAndView resSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		ReservationDTO dto = (ReservationDTO) session.getAttribute("loginUser");
		System.out.println("seq = " + dto); // 데이터 나옴

		List<ReservationDTO2> list = ms.resSelect(dto);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("reservation", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Reservation.jsp");
		mv.setRedirect(true);
		return mv;
	}

	// 예약내역 삭제
	public ModelAndView resDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		ReservationDTO dto = (ReservationDTO) session.getAttribute("loginUser");

		ms.resDelete(dto);
		
		return new ModelAndView("user/Reservation.jsp", true);
		}


	// 리뷰 전체검색
	public ModelAndView reviewSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		int seq = (Integer) session.getAttribute("loginUser");
		System.out.println("seq = " + seq); // 데이터 나옴

		List<ReviewDTO> list = ms.reviewSelectAll(seq);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("review", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/review.jsp");
		mv.setRedirect(true);
		return mv;
	}

	// 리뷰 부분검색
	public ModelAndView reviewSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		ReviewDTO dto = (ReviewDTO) session.getAttribute("loginUser");
		System.out.println("seq = " + dto); // 데이터 나옴

		List<ReviewDTO> list = ms.reviewSelect(dto);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("reservation", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/review.jsp");
		mv.setRedirect(true);
		return mv;
	}


	// 리뷰 삭제
	public ModelAndView reviewDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		ReviewDTO dto = (ReviewDTO) session.getAttribute("loginUser");

		ms.reviewDelete(dto);
		
		return new ModelAndView("user/review.jsp", true);
		}

	// 즐겨찾기 전체검색
	public ModelAndView likeSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		int seq = (Integer) session.getAttribute("loginUser");
		System.out.println("seq = " + seq); // 데이터 나옴

		List<USER_LIKE> list = ms.likeSelectAll(seq);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("like", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		mv.setRedirect(true);
		return mv;
	}

	// 즐겨찾기 부분검색
	public ModelAndView likeSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		USER_LIKE dto = (USER_LIKE) session.getAttribute("loginUser");
		System.out.println("seq = " + dto); // 데이터 나옴

		List<USER_LIKE> list = ms.likeSelect(dto);
		System.out.println("list = " + list); // 이것도 나옴

		try {
			if (list == null) {
				// 뭐,, 항목이 없다는? 그런 처리할건데,, 도와줘요ㅠ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("like", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		mv.setRedirect(true);
		return mv;
	}
	// 즐겨찾기 삭제
	public ModelAndView likeDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		USER_LIKE dto = (USER_LIKE) session.getAttribute("loginUser");

		ms.likeSelect(dto);
		
		return new ModelAndView("", true);
		}

}
