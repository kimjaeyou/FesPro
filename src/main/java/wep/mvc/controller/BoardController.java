package wep.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.BoardCtgDAO;
import wep.mvc.dao.BoardCtgDAOImpl;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardController implements Controller {
	

		public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException, SQLException {

		    // 세션에서 로그인 정보 확인
		    HttpSession session = request.getSession();
		    Integer userSeq = (session.getAttribute("userSeq") != null) ? Integer.parseInt(session.getAttribute("userSeq").toString()) : null;
		    Integer hostSeq = (session.getAttribute("hostSeq") != null) ? Integer.parseInt(session.getAttribute("hostSeq").toString()) : null;

		    // 로그인 확인 (모든 게시판에서 로그인 필요)
		    if (userSeq == null && hostSeq == null) {
		        return new ModelAndView("../user/login.jsp", true);  // 로그인 페이지로 리다이렉트
		    }

		    // 요청 파라미터 처리
		    String title = request.getParameter("sub");  // 제목
		    String content = request.getParameter("bContent");  // 내용
		    String categoryParam = request.getParameter("category");  // 카테고리 번호 (문자열)

		    // 필수 값 체크
		    if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
		        return new ModelAndView("boardWrite.jsp");
		    }

		    // 카테고리 값 처리
		    int categorySeq;
		    BoardCategoryDTO categoryDTO;
		    try {
		        categorySeq = Integer.parseInt(categoryParam);  // 카테고리 파라미터를 정수로 변환

		        Connection conn = null;
				// DB에서 카테고리 정보 가져오기
		        BoardCtgDAO categoryDAO = new BoardCtgDAOImpl(conn);  // DB 연결 객체 필요
		        categoryDTO = categoryDAO.selectCtg(categorySeq);

		        // 카테고리 정보가 없는 경우 처리
		        if (categoryDTO == null) {
		            return new ModelAndView("boardWrite.jsp");
		        }

		    } catch (NumberFormatException e) {
		        return new ModelAndView("boardWrite.jsp");
		    }

		    // 카테고리별 권한 확인
		    if (categorySeq == 0 && hostSeq == null) {  // 공지사항 게시판: 호스트만 작성 가능
		        return new ModelAndView("boardWrite.jsp");
		    } else if (categorySeq == 1 && userSeq == null) {  // QA 게시판: 로그인한 유저만 작성 가능
		        return new ModelAndView("boardWrite.jsp");
		    } else if (categorySeq == 2 && userSeq == null && hostSeq == null) {  // 자유게시판: 유저 또는 호스트만 작성 가능
		        return new ModelAndView("boardWrite.jsp");
		    }
		    try {
		        // 게시글 정보 생성 및 저장
		        BoardDTO boardDTO = new BoardDTO();
		        boardDTO.setSub(title);
		        boardDTO.setbContent(content);
		        boardDTO.setCategorySeq(categoryDTO.getCategorySeq());  // DB에서 가져온 카테고리 설정
		        boardDTO.setUserSeq(userSeq);  // 로그인한 사용자 ID 설정

		        if (categorySeq == 0) {  // 공지사항 게시판: 호스트만 작성 가능
		            boardDTO.setHostSeq(hostSeq);
		        }

		        new BoardDAOImpl().insert(boardDTO);  // 데이터베이스 저장

		        return new ModelAndView("boardMain.jsp", true);  // 작성 후 메인 페이지로 리다이렉트

		    } catch (SQLException e) {
		        e.printStackTrace();
		        return new ModelAndView("error.jsp");
		    }
		}






		public ModelAndView select(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException, SQLException {

		    HttpSession session = request.getSession();
		    String userID = (String) session.getAttribute("userID");
		    Integer userSeq = (session.getAttribute("userSeq") != null) ? Integer.parseInt(session.getAttribute("userSeq").toString()) : null;
		    Integer hostSeq = (session.getAttribute("hostSeq") != null) ? Integer.parseInt(session.getAttribute("hostSeq").toString()) : null;

		    // userSeq 파라미터 처리 (게시글의 userSeq)
		    int postUserSeq;
		    try {
		        postUserSeq = Integer.parseInt(request.getParameter("userSeq"));
		    } catch (NumberFormatException e) {
		        return new ModelAndView("error.jsp");  // 에러 처리
		    }

		    // 데이터베이스에서 게시글 정보 조회
		    BoardDAO boardDAO = new BoardDAOImpl();
		    BoardDTO bDTO = boardDAO.select(postUserSeq);

		    // 게시글이 존재하지 않는 경우 처리
		    if (bDTO == null) {
		        return new ModelAndView("error.jsp");
		    }

		    // 게시글의 카테고리 정보 가져오기 (0: 공지사항, 1: QA 게시판, 2: 자유게시판)
		    int categorySeq = bDTO.getCategorySeq();
		    
		    // 공지사항 및 자유게시판은 로그인 없이도 상세 보기 가능
		    if (categorySeq == 0 || categorySeq == 2) {
		        return new ModelAndView("boardView.jsp");  // 게시글 정보를 넘김
		    }

		    // QA 게시판 (categorySeq == 1)은 로그인한 작성자나 호스트만 상세 보기 가능
		    if (categorySeq == 1) {
		        // 로그인 확인
		        if (userID == null) {
		            return new ModelAndView("../user/login.jsp", true);  // 로그인 페이지로 리다이렉트
		        }

		        // 작성자 또는 호스트 확인
		        if (bDTO.getUserSeq() != userSeq && hostSeq == null) {
		            return new ModelAndView("error.jsp");
		        }

		        // 작성자 또는 호스트일 경우 게시글 보여주기
		        return new ModelAndView("boardView.jsp");
		    }

		    // 기본 처리 (혹시 잘못된 카테고리 번호일 경우)
		    return new ModelAndView("error.jsp");
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
