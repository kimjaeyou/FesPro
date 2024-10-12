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

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException , SQLException {

		HttpSession session = request.getSession();
		
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}

		// userSeq 파라미터 처리
		int userSeq = 0;
		if (request.getParameter("userSeq") != null) {
			try {
				userSeq = Integer.parseInt(request.getParameter("userSeq"));
			} catch (NumberFormatException e) {
				// 파라미터가 숫자가 아닌 경우
				userSeq = 0;
			}
		}

	        // 데이터베이스에서 해당 글 정보 가져오기
	        BoardDAO boardDAO = new BoardDAOImpl();
	        BoardDTO bDTO = boardDAO.select(userSeq); 
	        
	        // 게시글이 존재하지 않는 경우 처리
	        if (bDTO == null) {
	            PrintWriter script = response.getWriter();
	            script.println("<script>");
	            script.println("alert('존재하지 않는 글입니다.')");
	            script.println("location.href = 'boardMain.jsp';");
	            script.println("</script>");
	        }
		
		return new ModelAndView("view.jsp", true);
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
