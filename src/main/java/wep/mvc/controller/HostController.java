package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;
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
			
			
			
			System.out.println(id);
			System.out.println(comName);
			
			HostDTO dto = new HostDTO(id,comName,pass,tel,hostName,0,repName,1);

			int result;
			try {
				result = hs.insert(dto);
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

		    String userId = request.getParameter("corporate-id");
		    String pwd = request.getParameter("corporate-password");
		  
		    //서비스 호출 
		    HostDTO dbDTO = hs.login( new HostDTO(userId, pwd) );
		    System.out.println(dbDTO);
		    
		    if (dbDTO == null || !dbDTO.getHost_id().equals(userId) || !dbDTO.getHost_pw().equals(pwd)) {
		    	// 로그인 실패했을때,,,모르겠닫
			 }
		    
		    HttpSession session = request.getSession();
		    session.setAttribute("logincom", dbDTO);
		    return new ModelAndView("index.jsp", true); 
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

		UsersDTO dto = new UsersDTO(userId, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("index.jps", null);

		return new ModelAndView("index.jsp", true);
	}



}
