package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.HostDTO;
import wep.mvc.service.HostService;
import wep.mvc.service.HostServiceImpl;

public class HostController implements Controller {
	private HostService hs = new HostServiceImpl();

	// 회원가입
		public ModelAndView insert(HttpServletRequest request, HttpServletResponse resp)
				throws ServletException, IOException {

			String id = request.getParameter("company-id");
			String pass = request.getParameter("company-pw");
			String tel = request.getParameter("com-phone1") + "-"
						+ request.getParameter("com-phone2") +"-"
						+ request.getParameter("com-phone3");
			String hostName = request.getParameter("host-name");
			String repName = request.getParameter("rep-name");
			String comName = request.getParameter("comname");
			
			HostDTO dto = new HostDTO(id,comName,pass,tel,hostName,0,repName,1);
			System.out.println(dto);

			int result;
			try {
				result = hs.insert(dto);
				if (result == 1) {//성공 메세지 = 회원가입 성공
					ModelAndView mv = new ModelAndView();
					mv.setViewName("front?key=main&methodName=read");
				    mv.setRedirect(true);
					return mv;
				} else {
					// 에러페이지 = 정보를 다시 입력하세요.
				 //   return new ModelAndView("comUser.jsp", true);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// 로그인
		public ModelAndView login(HttpServletRequest request, HttpServletResponse resp)
		        throws ServletException, IOException, SQLException {

		    String userId = request.getParameter("corporate-id");
		    String userpw = request.getParameter("corporate-pw");
		  
		    System.out.println(userId+" "+userpw);
		    HostDTO dbDTO = hs.login( new HostDTO(userId,userpw) );
		    System.out.println(dbDTO);
		    try {
				if (dbDTO == null) {
					// 오류메세지 = 아이디 또는 비밀번호를 다시 입력하세요.
				  //  return new ModelAndView("login.jsp", true);
				}
				if (dbDTO.getHost_ben_check() == 0) {
					// 오류메세지 = 정지된 아이디 입니다.
				 //   return new ModelAndView("login.jsp", true);
						}
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("loginCom",new HostDTO( dbDTO.getHost_id(),dbDTO.getHost_name(),dbDTO.getHost_seq()));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("front?key=main&methodName=read");
		    mv.setRedirect(true);
			return mv;
		}

	// 아이디 중복체크
	public Object idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		String id = request.getParameter("company-id");
		boolean result = hs.idCheck(id);
		
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

		HostDTO dto = new HostDTO(userId, pwd);
		// 가능하면 로그아웃 되었다는 메세지 출력해주고 싶다

		HttpSession session = request.getSession();
		session.invalidate(); // 세션정보 무효화 시키기

		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=main&methodName=read");
	    mv.setRedirect(true);
		return mv;
	}
}
