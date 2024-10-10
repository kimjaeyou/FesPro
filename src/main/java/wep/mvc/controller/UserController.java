package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController implements Controller {

	// 로그인
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	// 로그아웃
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
	
	// 회원가입
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		return new ModelAndView("index.jsp", true);
	}
	
	// 회원탈퇴
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		return new ModelAndView("index.jsp", true);
	}
	
	
}
