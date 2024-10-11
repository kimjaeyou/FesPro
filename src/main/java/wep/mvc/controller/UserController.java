package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.UserService;
import wep.mvc.service.UserServiceImpl;

public class UserController implements Controller {

	private UserService us = new UserServiceImpl();

	// 로그인
	public Object login(HttpServletRequest request, HttpServletResponse resp)
	        throws ServletException, IOException, SQLException {

	    String userId = request.getParameter("member-id");
	    String pwd = request.getParameter("member-password");
	  
	    //서비스 호출 
	    UsersDTO dbDTO = us.login( new UsersDTO(userId, pwd) );
	    System.out.println(dbDTO);
	    
	    if (dbDTO == null || !dbDTO.getUser_id().equals(userId) || !dbDTO.getUser_pw().equals(pwd)) {
	    	// 로그인 실패했을때,,,모르겠닫
		 }
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("loginUser", dbDTO);
	    return new ModelAndView("index.jsp", true); 
	}

	// 아이디 중복체크
	public ModelAndView idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		try {
			boolean result = us.idCheck(id);
			PrintWriter out = resp.getWriter();
			
			if(result) out.print("중복입니다.");
			else out.print("사용가능합니다.");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return new ModelAndView("index.jsp", true);
	}

	// 로그아웃
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = request.getParameter("");
		String pwd = request.getParameter("");

		UsersDTO dto = new UsersDTO(userId, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", null);

		return new ModelAndView("index.jsp", true);
	}

	// 회원가입
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		LocalDate date = LocalDate.now();
		int year = date.getYear();

		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		String age = request.getParameter("year");
		String addr = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		String email = request.getParameter("email1") + "@"
					+ request.getParameter("email2") ;
		
		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		
		String tel = request.getParameter("phone1") + "-"
					+ request.getParameter("phone2") +"-"
					+ request.getParameter("phone3");

		UsersDTO dto = new UsersDTO(id, pwd, year-Integer.parseInt(age), addr, Integer.parseInt(gender), email, name,
				Integer.parseInt(disable), tel);

		int result;
		try {
			result = us.insert(dto);
			if (result == 1) {
				return new ModelAndView("index.jsp", true);
			} else {
				// 에러페이지
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원탈퇴
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		try {
			int result = us.delete(id);
			if (result == 1) {
				return new ModelAndView("index.jsp", true);

			} else {
				// 에러페이지
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 회원수정
	public ModelAndView update(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		LocalDate date = LocalDate.now();
		int year = date.getYear();

		String pwd = request.getParameter("password");
		String age = request.getParameter("year");
		String addr = request.getParameter("address");
		String gender = request.getParameter("gender");

		String email = request.getParameter("email1") + "@"
					+ request.getParameter("email2") ;

		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		
		String tel = request.getParameter("phone1") + "-"
					+ request.getParameter("phone2") +"-"
					+ request.getParameter("phone3");

		UsersDTO dto = new UsersDTO( pwd, year-Integer.parseInt(age), addr, Integer.parseInt(gender), email, name,
				Integer.parseInt(disable), tel);


		try {
			int result = us.update(dto);
			if (result == 1) {
				return new ModelAndView("index.jsp", true);
			} else {
				// 에러창
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
