package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardDTO;
import wep.mvc.service.BoardService;
import wep.mvc.service.BoardServiceImpl;

public class BoardController implements Controller {

	private BoardService boardService = new BoardServiceImpl();

	public BoardController() {
		System.out.println("BoardController Constructor call");
	}

	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		Integer userSeq = (Integer) session.getAttribute("userSeq");
		Integer hostSeq = (Integer) session.getAttribute("hostSeq");

		if (userSeq == null || hostSeq == null) {
			return new ModelAndView("../user/login.jsp", true);
		}

		String title = request.getParameter("sub");
		String content = request.getParameter("bContent");
		String categoryParam = request.getParameter("category");

		if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
			return new ModelAndView("boardWrite.jsp");
		}

		int result = boardService.write(userSeq, hostSeq, title, content, categoryParam);
		if (result > 0) {
			return new ModelAndView("boardList.jsp", true);
		} else {
			return new ModelAndView("boardWrite.jsp");
		}

	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		Integer userSeq = (session.getAttribute("userSeq") != null)
				? Integer.parseInt(session.getAttribute("userSeq").toString())
				: null;
		Integer hostSeq = (session.getAttribute("hostSeq") != null)
				? Integer.parseInt(session.getAttribute("hostSeq").toString())
				: null;

		// userSeq 파라미터 처리 (게시글의 userSeq)
		int postUserSeq;
		try {
			postUserSeq = Integer.parseInt(request.getParameter("userSeq"));
		} catch (NumberFormatException e) {
			return new ModelAndView("error.jsp"); // 에러 처리
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
			return new ModelAndView("boardView.jsp"); // 게시글 정보를 넘김
		}

		// QA 게시판 (categorySeq == 1)은 로그인한 작성자나 호스트만 상세 보기 가능
		if (categorySeq == 1) {
			// 로그인 확인
			if (userID == null) {
				return new ModelAndView("../user/login.jsp", true); // 로그인 페이지로 리다이렉트
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

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
