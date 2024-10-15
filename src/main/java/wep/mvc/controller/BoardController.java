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

	/**
	 * 공지
	 * */
	public ModelAndView readNoti(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {
		
		
	    List<BoardDTO> selectAll = boardService.selectByCtg();
	    System.out.println("selectAll - noti = " + selectAll);
	    request.setAttribute("noti", filterCtg(selectAll, 0));  
	    System.out.println("filterCtg noti (selectAll, 0) = " + filterCtg(selectAll, 0));
	    return new ModelAndView("/board/boardMain.jsp");
	}

	/**
	 * QA
	 * */
	public ModelAndView readQA(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {
		
		
	    List<BoardDTO> selectAll = boardService.selectByCtg();
	    
	    System.out.println("selectAll - QA = " + selectAll);

	    request.setAttribute("QA", filterCtg(selectAll, 1));
	    
	    System.out.println("filterCtg noti (selectAll, 1) = " + filterCtg(selectAll, 1));
	    
	    return new ModelAndView("/board/boardQA.jsp");
	}

	/**
	 * 자게
	 * */
	public ModelAndView readFree(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {
		
		
	    List<BoardDTO> selectAll = boardService.selectByCtg();

	    System.out.println("selectAll - 자게 = " + selectAll);
	    
	    request.setAttribute("Free", filterCtg(selectAll, 2)); 
	    
	    System.out.println("filterCtg noti (selectAll, 2) = " + filterCtg(selectAll, 2));
	    
	    return new ModelAndView("/board/boardFree.jsp");
	}

	/**
	 * 카테고리필터 -gpt님 도움받음
	 * */
	private List<BoardDTO> filterCtg(List<BoardDTO> posts, int categorySeq) {
	    return posts.stream()
	            .filter(post -> post.getCategorySeq() == categorySeq)
	            .collect(Collectors.toList());
	}


	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("write 호출");

		HttpSession session = request.getSession();
		UsersDTO SessionUsersDTO = (UsersDTO) session.getAttribute("loginUser");
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("logincom");

		System.out.println("SUDTO = " + SessionUsersDTO);
		System.out.println("SHDTO = " + SessionHostDTO);

		int hostSeq = SessionHostDTO.getHost_seq();
		int userSeq = SessionUsersDTO.getUser_seq();

		System.out.println("userSeq: " + userSeq + " , hostSeq: " + hostSeq);

		if (userSeq == 0 && hostSeq == 0) {
			return new ModelAndView("user/login.jsp", true);
		}

		return new ModelAndView("board/boardWrite.jsp");
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("상세보기 메소드 불러왔다");

		HttpSession session = request.getSession();
		UsersDTO SessionUsersDTO = (UsersDTO) session.getAttribute("loginUser");
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("logincom");

		int hostSeq = SessionHostDTO.getHost_seq();
		int userSeq = SessionUsersDTO.getUser_seq();

		System.out.println(hostSeq);
		System.out.println(userSeq);

		int postUserSeq = Integer.parseInt(request.getParameter("loginUser"));

		// 서비스 레이어에서 게시글 조회 및 권한 검증 처리
		BoardDTO boardDTO = boardService.select(postUserSeq, userSeq, hostSeq);
		System.out.println(boardDTO);
		// 게시글이 존재하지 않거나, 권한이 없는 경우 처리
		if (boardDTO == null) {
			return new ModelAndView("board/error.jsp");
		}

		request.setAttribute("list", boardDTO);

		// 게시글을 보여줄 뷰로 이동
		return new ModelAndView("board/MainView.jsp");
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();

		UsersDTO sessionUsersDTO = (UsersDTO) session.getAttribute("loginUser");
		HostDTO sessionHostDTO = (HostDTO) session.getAttribute("loginCom");

		Integer userSeq = sessionUsersDTO != null ? sessionUsersDTO.getUser_seq() : null;
		Integer hostSeq = sessionHostDTO != null ? sessionHostDTO.getHost_seq() : null;

		String boardSeqParam = request.getParameter("boardSeq");
		int boardSeq = 0;
		if (boardSeqParam != null && !boardSeqParam.isEmpty()) {
			boardSeq = Integer.parseInt(boardSeqParam);
		}

		if (userSeq == null && hostSeq == null) {
			throw new SecurityException("사용자 또는 호스트 정보가 없습니다. 삭제 권한이 없습니다.");
		}

		// 서비스에 삭제 요청
		boardService.delete(boardSeq, userSeq, hostSeq);

		return new ModelAndView("front?key=board&methodName=read", true);

	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	public ModelAndView reDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}


}