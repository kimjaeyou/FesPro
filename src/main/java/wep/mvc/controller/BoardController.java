package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardController implements Controller {
	


	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {

	    // 세션에서 로그인 정보 확인
	    HttpSession session = request.getSession();
	    String userID = (String) session.getAttribute("userID");
	    Integer userSeq = (session.getAttribute("userSeq") != null) ? Integer.parseInt(session.getAttribute("userSeq").toString()) : null;
	    Integer hostSeq = (session.getAttribute("hostSeq") != null) ? Integer.parseInt(session.getAttribute("hostSeq").toString()) : null;

	    // 요청 파라미터 처리
	    String title = request.getParameter("sub");  // 제목
	    String content = request.getParameter("bContent");  // 내용
	    String categoryParam = request.getParameter("category");  // 카테고리 번호 (문자열)

	    // 필수 값 체크
	    if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
	        return new ModelAndView("boardWrite.jsp");
	    }

	    // 카테고리 값 처리 및 카테고리 정보 설정 (0: 공지사항, 1: QA, 2: 자유게시판)
	    int categorySeq;
	    BoardCategoryDTO categoryDTO;
	    try {
	        categorySeq = Integer.parseInt(categoryParam);  // 카테고리 파라미터를 정수로 변환
	        switch (categorySeq) {
	            case 0:
	                categoryDTO = new BoardCategoryDTO(0, "공지사항");
	                break;
	            case 1:
	                categoryDTO = new BoardCategoryDTO(1, "QA 게시판");
	                break;
	            case 2:
	                categoryDTO = new BoardCategoryDTO(2, "자유게시판");
	                break;
	            default:
	                return new ModelAndView("boardWrite.jsp");
	        }
	    } catch (NumberFormatException e) {
	        return new ModelAndView("boardWrite.jsp");
	    }

	    // 카테고리별 권한 확인
	    if (categorySeq == 0 && hostSeq == null) {  // 공지사항 게시판은 호스트만 작성 가능
	        return new ModelAndView("boardWrite.jsp");
	    } else if (categorySeq == 1 && userSeq == null) {  // QA 게시판은 로그인한 사용자만 작성 가능
	        return new ModelAndView("../user/login.jsp", true);
	    }

	    // 자유게시판(categorySeq == 2)은 로그인 여부와 관계없이 누구나 작성 가능

	    try {
	        // 게시글 정보 생성 및 저장
	        BoardDTO boardDTO = new BoardDTO();
	        boardDTO.setSub(title);
	        boardDTO.setbContent(content);
	        boardDTO.setCategorySeq(categoryDTO.getCategorySeq());  // 카테고리 설정

	        // 카테고리에 따른 작성자 설정
	        if (categorySeq == 0) {
	            boardDTO.setHostSeq(hostSeq);  // 공지사항 게시판: 호스트만 작성 가능
	        } else if (categorySeq == 1) {
	            boardDTO.setUserSeq(userSeq);  // QA 게시판: 로그인한 사용자만 작성 가능
	        } else if (categorySeq == 2) {
	            boardDTO.setUserSeq((userSeq != null) ? userSeq : 0);  // 자유게시판: 로그인하지 않은 경우 기본값 0
	        }

	        new BoardDAOImpl().insert(boardDTO);  // 데이터베이스 저장

	        return new ModelAndView("../index.jsp", true);  // 작성 후 메인 페이지로 리다이렉트

	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return new ModelAndView("../board/boardMain.jsp");
	}





	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    
		HttpSession session = request.getSession();
	    String userID = (String) session.getAttribute("userID");

	  
	    if (userID == null) {
	        return new ModelAndView("../user/login.jsp", true); 
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
