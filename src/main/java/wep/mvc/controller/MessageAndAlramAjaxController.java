package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.NotificationWebSocket;


public class MessageAndAlramAjaxController implements RestController {

	//좋아요 수정 발생시
	public static void alarmLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		sendAlarm(request,response,"행사 내용이 변경 되었습니다.");
	}
	
	//좋아요 태그 읽고 같은거 알림
	public void alarmRecomand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Gson gson = new Gson();
		UsersDTO user =(UsersDTO)request.getSession().getAttribute("loginUser"); 
		
		
		String json = gson.toJson("");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	//로그인 사용자 전체 알림
	public void allRecomand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Gson gson = new Gson();
		UsersDTO user =(UsersDTO)request.getSession().getAttribute("loginUser"); 
		
		
		String json = gson.toJson("");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	
	public static void sendAlarm(HttpServletRequest req, HttpServletResponse resp,String message) throws ServletException, IOException {
		NotificationWebSocket.broadcast(message); // 웹소켓을 통해 알림 전송
		resp.getWriter().write(message);
	}

}