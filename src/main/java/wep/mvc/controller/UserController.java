package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.UsersDAO;
import wep.mvc.dao.UsersDAOImpl;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.UserService;
import wep.mvc.service.UserServiceImpl;

public class UserController implements Controller {

	private UserService us = new UserServiceImpl();
	private UsersDAO ud = new UsersDAOImpl();

	// 회원가입
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		String age = request.getParameter("age");
		String addr = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		String tel = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-"
				+ request.getParameter("phone3");

		UsersDTO dto = new UsersDTO(id, pwd, Integer.parseInt(age), addr, gender, email, name, disable, tel);

		int result;
		try {
			result = us.insert(dto);
			if (result == 1) { // 성공 메세지 = 회원가입 성공
				int seq = ud.selectWallet(id);
				int count = ud.insertWallet(seq);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("front?key=main&methodName=read");
				mv.setRedirect(true);
				return mv;
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원가입 실패했습니다.'); history.go(-1);</script>");
				out.flush();
				response.flushBuffer();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("member-id");
		String userPw = request.getParameter("member-password");
		UsersDTO dbDTO = null;
		try {
			dbDTO = us.login(new UsersDTO(userId, userPw));
			if (dbDTO == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디 또는 비밀번호 오류 입니다.'); history.go(-1);</script>");
				out.flush();
				response.flushBuffer();
				out.close();
			} else if (dbDTO.getUser_ben_check() == 1) {
				System.out.println(dbDTO.getUser_ben_check());
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 되었습니다.')"
						+ "	location.href='main.jsp';</script>");
				out.flush();
				response.flushBuffer();
				out.close();
			} else if (dbDTO.getUser_ben_check() != 1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('정지된 계정 입니다.'); history.go(-1);</script>");
				out.flush();
				response.flushBuffer();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", new UsersDTO(dbDTO.getUser_id(), dbDTO.getUser_name(), dbDTO.getUser_seq(),
				dbDTO.getEmail(), dbDTO.getUser_tel(), dbDTO.getUser_ben_check()));
		session.setAttribute("loginUserId", dbDTO.getUser_id());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=main&methodName=read");
		mv.setRedirect(true);
		return mv;
	}

	// 로그아웃
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // 세션정보 무효화 시키기
		// 가능하면 로그아웃 되었다는 메세지 출력해주고 싶다
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 되었습니다.');"
				+ "	location.href='main.jsp'; </script>");
		out.flush();
		response.flushBuffer();
		out.close();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=main&methodName=read");
		return mv;
	}

}
