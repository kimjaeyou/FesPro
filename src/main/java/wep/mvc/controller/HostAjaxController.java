package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.service.HostService;
import wep.mvc.service.HostServiceImpl;


public class HostAjaxController implements RestController {

	private HostService hs = new HostServiceImpl();

	// 아이디 중복체크
	public void idCheck(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		System.out.println(id);
		boolean result = hs.idCheck(id);
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