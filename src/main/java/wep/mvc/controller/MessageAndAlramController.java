package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.MESSAGE;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.MessageAndAlramSerevice;
import wep.mvc.service.MessageAndAlramSereviceImpl;

public class MessageAndAlramController implements Controller {
	private MessageAndAlramSerevice mSerevice = new MessageAndAlramSereviceImpl();
	public ModelAndView mMove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		//0.로그인 안했으면 못가
		HttpSession session = req.getSession();

		if (session.getAttribute("loginUser") == null) { // 기업회원으로 로그인 되어있는지 확인
			System.out.println("로그인 안했지롱");
			return new ModelAndView("user/login.jsp"); // 로그인 페이지로 보낼 것
		}
		
		//1.m테이블에서 db 꺼내와
		UsersDTO u = (UsersDTO) session.getAttribute("loginUser");
		int uSeq = u.getUser_seq();
		System.out.println("uSeq="+uSeq);
		List<MESSAGE> mDTOList = mSerevice.select(uSeq);
		System.out.println("mDTOList="+mDTOList);
		req.setAttribute("messageDTOList", mDTOList);
		
		return new ModelAndView("message/messagePage.jsp");
	}

	
}