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
		sendAlarm(request,response,"선호 행사와 비슷한 행사가 등록되었어요");
	}
	
	//로그인 사용자 전체 알림
	public void allRecomand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		sendAlarm(request,response,"공지사항 추가");
	}
	
	
	
	public static void sendAlarm(HttpServletRequest req, HttpServletResponse resp,String message) throws ServletException, IOException {
		NotificationWebSocket.broadcast(message); // 웹소켓을 통해 알림 전송
		resp.getWriter().write(message);
	}

}