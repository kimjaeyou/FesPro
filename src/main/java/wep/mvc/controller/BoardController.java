package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.BoardDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.BoardService;
import wep.mvc.service.BoardServiceImpl;

public class BoardController implements Controller {

	private BoardService boardService = new BoardServiceImpl();

	public BoardController() {
		System.out.println("BoardController 생성자 호출됨 ");

	}
	
	public ModelAndView moveWritePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		
		return new ModelAndView("board/boardWrite.jsp");
		
	}
	
	public ModelAndView moveWritePageFree (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		
		return new ModelAndView("board/boardWriteFree.jsp");
		
	}
	

	/**
	 * 공지
	 */
	public ModelAndView readNoti(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<BoardDTO> selectAll = boardService.selectByCtg();

		request.setAttribute("noti", filterCtg(selectAll, 0));

		return new ModelAndView("/board/boardMain.jsp");
	}

	/**
	 * QA
	 */
	public ModelAndView readQA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<BoardDTO> selectAll = boardService.selectByCtg();

		request.setAttribute("QA", filterCtg(selectAll, 1));

		return new ModelAndView("/board/boardQA.jsp");
	}

	/**
	 * 자게
	 */
	public ModelAndView readFree(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<BoardDTO> selectAll = boardService.selectByCtg();

		request.setAttribute("Free", filterCtg(selectAll, 2));

		return new ModelAndView("/board/boardFree.jsp");
	}

	/**
	 * 카테고리필터 메소드
	 */
	private List<BoardDTO> filterCtg(List<BoardDTO> posts, int categorySeq) {
		return posts.stream().filter(post -> post.getCategorySeq() == categorySeq).collect(Collectors.toList());
	}

	/** 	
	 * 글쓰기
	 */
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("write 호출");

		String categorySe = request.getParameter("categorySeq");
		int categorySeq =0;	
		if (categorySe ==null) {
			categorySeq =0;
		}else {
			categorySeq = Integer.parseInt(categorySe);
		}
		String sub = request.getParameter("bbsTitle");
		String bContent = request.getParameter("bbsContent");

		HttpSession session = request.getSession();
		UsersDTO sessionUser = (UsersDTO) session.getAttribute("loginUser");
		HostDTO sessionHost = (HostDTO) session.getAttribute("logincom");
		
		if(sessionHost==null) {
			sessionHost = new HostDTO(0);
		}
		if(sessionUser==null) {
			sessionUser = new UsersDTO(0);
		}

		int userSeq = 0;
		//userSeq = sessionUser != null ? sessionUser.getUser_seq() : null;
		// Integer hostSeq = sessionHost != null ? sessionHost.getHost_seq() : null;
		int hostSeq = 0;
		hostSeq = sessionHost.getHost_seq();
		userSeq =sessionUser.getUser_seq();
		/*
		 * if (userSeq == 0 && hostSeq == 0) { return new
		 * ModelAndView("/user/login.jsp", true); }
		 */
		if (userSeq != 0) {
			hostSeq = 0;
		}
		if (hostSeq != 0) {
			userSeq = 0;
		}
		BoardDTO boardDTO = new BoardDTO(categorySeq, userSeq, sub, bContent, hostSeq);

		boardService.write(boardDTO);

		return new ModelAndView("front?key=board&methodName=readNoti", true);
	}

	/**
	 * 상세보기 메소드
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("상세보기 메소드 불러왔다");
		
		String boardSeq = request.getParameter("boardSeq");
	
	   

		BoardDTO boardDTO = boardService.select(Integer.parseInt(boardSeq));
		System.out.println(boardDTO);

		if (boardDTO == null) {
	      
	        return new ModelAndView("board/error.jsp");
	    }

		request.setAttribute("list", boardDTO);
		return new ModelAndView("board/boardView.jsp");
	}

	/**
	 * 삭제 메소드
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		
		HttpSession session = request.getSession();
		UsersDTO sessionUser = (UsersDTO) session.getAttribute("loginUser");
		HostDTO sessionHost = (HostDTO) session.getAttribute("logincom");
		
		if(sessionHost==null) {
			sessionHost = new HostDTO(0);
		}
		if(sessionUser==null) {
			sessionUser = new UsersDTO(0);
		}


		String boardSeqParam = request.getParameter("boardSeq");

		return new ModelAndView("front?key=board&methodName=read", true);

	}

	/**
	 * 수정 메소드
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

}