package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.service.FesSerevice;
import wep.mvc.service.FesSereviceImpl;

public class FesController implements Controller {
	//private FesSerevice fesSerevice = new FesSereviceImpl();
	
	//등록 신청(C)
	public ModelAndView send(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}
	//등록 신청을 취소/게시글 삭제(D)
	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
	///////////////////////////////////////////////////////////////////////////////////여기는 건들지 않는다...! //행사 리스트 띄우는 기능
	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app= req.getServletContext();
		ListPublicReservationCulture list= (ListPublicReservationCulture)app.getAttribute("fesList");
		req.setAttribute("list", list);
		return new ModelAndView("fes/list.jsp");
	}
	///////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 전체검색
	 * */
	public ModelAndView select(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//List<FesDTO> fesDTOList = fesSerevice.selectAll();
		ServletContext app = req.getServletContext();
		List<FesDTO> fesDTOList= (List<FesDTO>)app.getAttribute("fesList");
		
		req.setAttribute("fesDTOList", fesDTOList);
		
		//req.setAttribute("fesDTOList", fesDTOList);
		
		System.out.println("여기");
		
		return new ModelAndView("host/myPage1.jsp");
	}
}
