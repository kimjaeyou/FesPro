package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.SuperAuthService;
import wep.mvc.service.SuperAuthServiceImpl;

public class SuperAuthController implements Controller {
	
SuperAuthService service = new SuperAuthServiceImpl();
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("셀렉트올 컨트롤러");
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = service.selectAll();
		System.out.println("컨트롤러에서 list = "+list);
		
		request.setAttribute("userList", list);
		return new ModelAndView("super/auth/userSelectAll.jsp");
		 
	}
	
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("셀렉트올 컨트롤러");
		
		String userid = request.getParameter("user_id");
		System.out.println(userid);
		
		UsersDTO user = new UsersDTO();
		user.setUser_id(userid);
	     
		UsersDTO searchUser = service.select(user);
		
		request.setAttribute("user", searchUser);
		
		return new ModelAndView("super/auth/detail.jsp");
		 
	}
	
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("update Call");
		String user_seq = req.getParameter("user_seq");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String user_name = req.getParameter("user_name");
		String disable = req.getParameter("disable");
		String user_tel = req.getParameter("user_tel");
		String user_ben_check = req.getParameter("authStateOptions");
	
		
		
		UsersDTO user = new UsersDTO();
				user.setUser_seq(Integer.parseInt(user_seq));
				user.setUser_id(user_id);
				user.setUser_pw(user_pw);
				user.setAge(Integer.parseInt(age));
				user.setAddr(addr);
				user.setGender(gender);
				user.setEmail(email);
				user.setUser_name(user_name);
				user.setDisable(disable);
				user.setUser_tel(user_tel);
				user.setUser_ben_check(Integer.parseInt(user_ben_check));
				
			
	 
	   
	    
		
		int result = service.update(user);
		System.out.println(result);
		
		if(result > 0) {
			return new ModelAndView("front?key=superAuth&methodName=selectAll",true);
		}
		else {
			//에러페이지
			System.out.println("회원 업데이트 실패 Controller-update");
			return null;
		}
	}
	
	public ModelAndView hostSelectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("호스트셀렉트올 컨트롤러");
		List<HostDTO> list = new ArrayList<HostDTO>();
		list = service.hostSelectAll();
		System.out.println("컨트롤러에서 호스트list = "+list);
		
		request.setAttribute("hostList", list);
		return new ModelAndView("super/auth/hostSelectAll.jsp");
		 
	}
	
	public ModelAndView hostDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("셀렉트올 컨트롤러");
		
		String hostid = request.getParameter("host_id");
		System.out.println("hostid = "+hostid);
		
		HostDTO Host = new HostDTO();
		Host.setHost_id(hostid);
	     
		HostDTO searchHost = service.hostSelect(Host);
		request.setAttribute("host", searchHost);
		System.out.println(searchHost);
		return new ModelAndView("super/auth/hostDetail.jsp");
		 
	}
	
	public ModelAndView hostUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("update Call");
		String host_seq = req.getParameter("host_seq");
		String host_id = req.getParameter("host_id");
		String com_name = req.getParameter("com_name");
		String host_pw = req.getParameter("host_pw");
		String host_tel = req.getParameter("host_tel");
		String host_name = req.getParameter("host_name");
		String host_check = req.getParameter("hostLoginStateOptions");
		String rep_name = req.getParameter("rep_name");
		String host_ben_check = req.getParameter("hostStateOptions");
		
		HostDTO host = new HostDTO();
		host.setHost_seq(Integer.parseInt(host_seq));
		host.setHost_id(host_id);
		host.setCom_name(com_name);
		host.setHost_pw(host_pw);
		host.setHost_tel(host_tel);
		host.setHost_name(host_name);
		host.setHost_check(Integer.parseInt(host_check));
		host.setRep_name(rep_name);
		host.setHost_ben_check(Integer.parseInt(host_ben_check));
		
		int result = service.hostUpdate(host);
		System.out.println(result);
		
		if(result > 0) {
			return new ModelAndView("front?key=superAuth&methodName=hostSelectAll",true);
		}
		else {
			//에러페이지
			System.out.println("회원 업데이트 실패 Controller-update");
			return null;
		}
	}
	
	public ModelAndView sessionLocationAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Fes로케이션 컨트롤러");
		
		HttpSession session = request.getSession();
		int sessionSeq = (int)session.getAttribute("user_seq");
		
		List<FesDTO> list = new ArrayList<FesDTO>();
		list = service.sessionLocationAll(sessionSeq);
		System.out.println("Fes로케이션 list = "+list);
		
		request.setAttribute("FesList", list);
		return new ModelAndView("super/auth/authChart.js");
		 
	}
}