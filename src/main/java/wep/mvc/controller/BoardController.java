package wep.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardDTO;

public class BoardController implements Controller {
	

	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    HttpSession session = request.getSession();
	    String userID = (String) session.getAttribute("userID");

	  
	    if (userID == null) {
	        return new ModelAndView("idnex.jsp", true); 
	    }

	
	    int userSeq;
	    try {
	        userSeq = Integer.parseInt(request.getParameter("userSeq"));
	    } catch (NumberFormatException e) {
	        userSeq = 0; // 잘못된 파라미터 처리
	    }


	    BoardDAO boardDAO = new BoardDAOImpl();
	    BoardDTO bDTO = boardDAO.select(userSeq);

	
	    if (bDTO == null) {
	        return new ModelAndView("boardMain.jsp"); 
	    }


	    return new ModelAndView("boardView.jsp");
	}



	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}

	public ModelAndView reWrite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}


	public ModelAndView reDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
}
