package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

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


	// 회원가입
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		String age = request.getParameter("age");
		String addr = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email1") + "@"
					+ request.getParameter("email2") ;
		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		String tel = request.getParameter("phone1") + "-"
					+ request.getParameter("phone2") +"-"
					+ request.getParameter("phone3");
		
		UsersDTO dto = new UsersDTO(id, pwd, Integer.parseInt(age), addr, gender, email, name,
				disable, tel);

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
	
	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse resp)
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
	public Object idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		String id = request.getParameter("id");
		boolean result = us.idCheck(id);
		
		JsonObject obj = new JsonObject();

		if(result) obj.addProperty("info", "중복입니다.");
		else obj.addProperty("info","사용가능합니다.");
		
		return obj;
	}

	// 로그아웃
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = request.getParameter("");
		String pwd = request.getParameter("");

		UsersDTO dto = new UsersDTO(userId, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("index.jps", null);

		return new ModelAndView("index.jsp", true);
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
		String pwd = request.getParameter("pw");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		String gender = request.getParameter("gender");

		String email = request.getParameter("email1") + "@"
					+ request.getParameter("email2") ;

		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		
		String tel = request.getParameter("tel1") + "-"
					+ request.getParameter("tel2") +"-"
					+ request.getParameter("tel3");
		String id = request.getParameter("id");

		UsersDTO dto = new UsersDTO(id, pwd, Integer.parseInt(age), addr, gender, email, name,
				disable, tel);

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
