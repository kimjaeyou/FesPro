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
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String name = request.getParameter("name");
		String disable = request.getParameter("hindrance");
		String tel = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-"
				+ request.getParameter("phone3");

		UsersDTO dto = new UsersDTO(id, pwd, Integer.parseInt(age), addr, gender, email, name, disable, tel);

		int result;
		try {
			result = us.insert(dto);
			if (result == 1) { //성공 메세지 = 회원가입 성공
				ModelAndView mv = new ModelAndView();
				mv.setViewName("front?key=main&methodName=read");
			    mv.setRedirect(true);
				return mv;
			} else {
				// 에러페이지 = 정보를 다시 입력하세요.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		String userId = request.getParameter("member-id");
		String userPw = request.getParameter("member-password");
		UsersDTO dbDTO = us.login(new UsersDTO(userId, userPw));
		try {
			if (dbDTO == null) {
				// 오류메세지 = 아이디 또는 비밀번호를 다시 입력하세요.
			    return new ModelAndView("login.jsp", true);
			}
			
			if (dbDTO.getUser_ben_check() == 0) {
				// 오류메세지 = 정지된 아이디 입니다.
			    return new ModelAndView("login.jsp", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", new UsersDTO(dbDTO.getUser_id(),dbDTO.getUser_name(), dbDTO.getUser_seq(), dbDTO.getEmail()));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=main&methodName=read");
	    mv.setRedirect(true);
		return mv;
	}	
	
	// 회원수정 데이터 꺼내기
	public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse resp) throws Exception {
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("loginUserId"); // 세션에서 ID 가져오기
	    String userName = (String) session.getAttribute("loginUserName"); // 세션에서 이름 가져오기
	    UsersDTO dbDTO = us.selectUser(new UsersDTO(userId, userName));
	    System.out.println(dbDTO);
	    try {
	        if (dbDTO == null) {
	            // 오류 메시지 처리
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    request.setAttribute("user", dbDTO);
	    return new ModelAndView("update.jsp", true);
	}
	// 아이디 중복체크
	public Object idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("username");
		boolean result = us.idCheck(id);
		JsonObject obj = new JsonObject();
		if (result)
			obj.addProperty("info", "중복입니다.");
		else
			obj.addProperty("info", "사용가능합니다.");

		return obj;
	}
	// 로그아웃
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = request.getParameter("");
		String pwd = request.getParameter("");

		UsersDTO dto = new UsersDTO(userId, pwd);
		// 가능하면 로그아웃 되었다는 메세지 출력해주고 싶다
		HttpSession session = request.getSession();
		session.invalidate(); // 세션정보 무효화 시키기
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=main&methodName=read");
	    mv.setRedirect(true);
	    return mv;

	}

	// 회원탈퇴
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			int result = us.delete(id);
			if (result == 1) { // 성공메세지 = 회원탈퇴 되었습니다.
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
	public ModelAndView update(HttpServletRequest request, HttpServletResponse resp)
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
			int result = us.update(dto);
			if (result == 1) {
				return new ModelAndView("update.jsp", true);
			} else {
				// 에러창
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
