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

	
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {

	    System.out.println("write 호출");

	    int categorySeq = Integer.parseInt(request.getParameter("categorySeq"));
	    String sub = request.getParameter("SUB");  
	    String bContent = request.getParameter("B_CONTENT");  
	    
	    
	    HttpSession session = request.getSession();
	    UsersDTO sessionUser = (UsersDTO) session.getAttribute("loginUser");
	    HostDTO sessionHost = (HostDTO) session.getAttribute("logincom");
	    
	    

	    Integer userSeq = sessionUser != null ? sessionUser.getUser_seq() : null;
	    Integer hostSeq = sessionHost != null ? sessionHost.getHost_seq() : null;

	    System.out.println("user세션 = "+ sessionUser);
	    System.out.println("host세션 = "+ sessionHost);
	    
	    
	    if (userSeq == null && hostSeq == null) {
	        return new ModelAndView("/user/login.jsp", true);
	    }

	    BoardDTO boardDTO = new BoardDTO(categorySeq, userSeq, bContent, sub, hostSeq);

	    boardService.write(boardDTO);

	    return new ModelAndView("/board/boardNoti.jsp",true);
	}


	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("상세보기 메소드 불러왔다");

		HttpSession session = request.getSession();
		UsersDTO SessionUsersDTO = (UsersDTO) session.getAttribute("loginUser");
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("logincom");

		Integer userSeq = SessionUsersDTO != null ? SessionUsersDTO.getUser_seq() : null;
	    Integer hostSeq = SessionHostDTO != null ? SessionHostDTO.getHost_seq() : null;


		Integer postUserSeq = Integer.parseInt(request.getParameter("loginUser"));

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
			return new ModelAndView("/board/error.jsp");
		}

		// 서비스에 삭제 요청
		boardService.delete(boardSeq, userSeq, hostSeq);

		return new ModelAndView("front?key=board&methodName=read", true);

	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

}