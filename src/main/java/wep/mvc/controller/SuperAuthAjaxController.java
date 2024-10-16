package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.SuperAuthService;
import wep.mvc.service.SuperAuthServiceImpl;


public class SuperAuthAjaxController implements RestController {
	
	SuperAuthService service = new SuperAuthServiceImpl();
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("셀렉트올 컨트롤러");
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = service.selectAll();
		System.out.println("컨트롤러에서 list = "+list);
		//list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
		  Gson gson = new Gson();
		  String jsonArry = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArry);
		 
	}
	
	/*
	 * public void selectById(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * UsersDTO user = new UsersDTO(); String id = request.getParameter("id"); user
	 * = service.selectById(id);
	 * 
	 * //list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다. Gson gson = new Gson(); String
	 * jsonUser = gson.toJson(user);
	 * 
	 * PrintWriter out = response.getWriter(); out.print(jsonUser);
	 * 
	 * }
	 * 
	 * public void update(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * 
	 * UsersDTO user = new UsersDTO(); String user_seq =
	 * request.getParameter("user_seq"); String user_id =
	 * request.getParameter("user_id"); String user_pw =
	 * request.getParameter("user_pw"); String user_name =
	 * request.getParameter("user_name"); String age = request.getParameter("age");
	 * String addr = request.getParameter("addr"); String gender =
	 * request.getParameter("gender"); String email = request.getParameter("email");
	 * String user_tel = request.getParameter("user_tel"); String disable =
	 * request.getParameter("disable");
	 * 
	 * 
	 * 
	 * UsersDTO userId = new UsersDTO(Integer.parseInt(user_seq),user_id,user_pw,
	 * Integer.parseInt(age),addr,Integer.parseInt(gender),email,user_name,Integer.
	 * parseInt(disable),user_tel); int result = service.update(user);
	 * 
	 * //list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
	 * 
	 * if(result != 0) { PrintWriter out = response.getWriter();
	 * out.print("등록이 완료되었습니다."); } else { PrintWriter out = response.getWriter();
	 * out.print("등록 실패"); } }
	 */
	

}
