package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.MainSereviceImpl;
import wep.mvc.service.SuperFestivalService;
import wep.mvc.service.SuperFestivalServiceImpl;

public class MainController implements Controller {
	MainSereviceImpl mainService = new MainSereviceImpl();

	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app = req.getServletContext();

		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");

		UsersDTO user = (UsersDTO) req.getSession().getAttribute("loginUser");
		req.setAttribute("list", list);
		
		List<FesDTO> likeList =new ArrayList<>();
		
		if (user != null) {
			int user_seq = user.getUser_seq();
			likeList = mainService.selecLike(user_seq, list);
		}else {
			likeList = mainService.selecMost();
		}
		
		req.setAttribute("listLike", likeList);

		return new ModelAndView("index.jsp");
	}

	public ModelAndView oneSelec(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String sid = req.getParameter("sid");

		ServletContext app = req.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");

		FesDTO fes = mainService.selecOne(sid, list);
		if (fes != null)
			req.setAttribute("fes", fes);
		
		/* 차트 데이터 가져오기 */
		SuperFestivalService festivalService = new SuperFestivalServiceImpl();
		
		// 행사에 등록한 유저들 리스트 보내기
		List<UsersDTO> userList = festivalService.selectUser(fes);
		// System.out.println(userList);
		Gson g = new Gson();
		String data = g.toJson(userList);
		req.setAttribute("chartUserList", data);
		
		// 리뷰 쓴 유저 정보 보내기
		List<UsersDTO> reviewUserList = festivalService.selectReviewUser(fes);
		data = g.toJson(reviewUserList);
		//System.out.println(data);
		req.setAttribute("reviewUserList", data);

	

		return new ModelAndView("detail.jsp");
	}
	
	public ModelAndView searchPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String search = req.getParameter("search");

		ServletContext app = req.getServletContext();
		List<FesDTO> list = (List<FesDTO>) app.getAttribute("fesList");
		
		if(!search.equals("all")) {
			list = mainService.searchList(search, list);
		}
		req.setAttribute("searchList", list);
		
		return new ModelAndView("list.jsp");
	}
	
	
	

	public ModelAndView review(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		return new ModelAndView("detail.jsp");
	}

}