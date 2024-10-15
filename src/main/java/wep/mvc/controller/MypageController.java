package wep.mvc.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.service.MypageService;
import wep.mvc.service.MypageServiceImpl;

public class MypageController implements Controller {

	private MypageService ms = new MypageServiceImpl();

	// 예약내역 전체검색
	public ModelAndView resSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession session = request.getSession();
		int seq = (Integer) session.getAttribute("loginUser");
		System.out.println("seq = " + seq); // 데이터 나옴

		List<ReservationDTO> list = ms.resSelectAll(seq);
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
		mv.setViewName("");
		mv.setRedirect(true);
		return mv;
	}

	// 예약내역 부분검색
	public ModelAndView resSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 예약내역 삭제
	public ModelAndView resDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 리뷰 전체검색
	public ModelAndView reviewSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 리뷰 부분검색
	public ModelAndView reviewSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 리뷰 삭제
	public ModelAndView reviewDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 즐겨찾기 전체검색
	public ModelAndView likeSelectAll(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 즐겨찾기 부분검색
	public ModelAndView likeSelect(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

	// 즐겨찾기 삭제
	public ModelAndView likeDelete(HttpServletRequest request, HttpServletResponse resp) throws Exception {

		return new ModelAndView("", true);
	}

}
