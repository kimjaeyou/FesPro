package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.UserService;
import wep.mvc.service.UserServiceImpl;

public class UserAjaxController implements RestController {
	private UserService us = new UserServiceImpl();

	// 아이디 중복체크
	public void idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		boolean result = us.idCheck(id);
		System.out.println(result);

		Gson gson = new Gson();
		String jsonArry = null;

		if (result)
			jsonArry = gson.toJson("이미 존재하는 아이디 입니다.");
		else 
			jsonArry = gson.toJson("사용 가능한 아이디 입니다.");

		PrintWriter out = resp.getWriter();
		out.println(jsonArry);
	}

}
