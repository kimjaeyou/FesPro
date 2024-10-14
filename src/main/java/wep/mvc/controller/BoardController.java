package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wep.mvc.dto.BoardDTO;
import wep.mvc.service.BoardService;
import wep.mvc.service.BoardServiceImpl;

public class BoardController implements Controller {

	
	
	private BoardService boardService = new BoardServiceImpl();

	
	

	public BoardController() {
		System.out.println("BoardController 생성자 호출됨 ");
	}

	public ModelAndView write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		
		System.out.println("글쓰기 눌렀다 세션받아올거다");
		
		
		HttpSession session = request.getSession();
		Integer userSeq = (Integer) session.getAttribute("userSeq");
		Integer hostSeq = (Integer) session.getAttribute("hostSeq");

		if (userSeq == null || hostSeq == null) {
			return new ModelAndView("../user/login.jsp", true);
		}
		
		String title = request.getParameter("sub");
		String content = request.getParameter("bContent");
		String categoryParam = request.getParameter("category");
		
		System.out.println("파라미터 겟햇다.");
		
		if (title == null || title.trim().isEmpty() || content == null || content.trim().isEmpty()) {
			return new ModelAndView("boardWrite.jsp");
		}

		int result = boardService.write(userSeq, hostSeq, title, content, categoryParam);
		if (result > 0) {
			System.out.println("성공했다.");
			return new ModelAndView("boardList.jsp", true);
		} else {
			System.out.println("실패했다");
			return new ModelAndView("boardWrite.jsp");
		}

	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
		System.out.println("상세보기 메소드 불러왔다");
        HttpSession session = request.getSession();
        
        Integer userSeq = (session.getAttribute("userSeq") != null)
                ? Integer.parseInt(session.getAttribute("userSeq").toString())
                : null;
        Integer hostSeq = (session.getAttribute("hostSeq") != null)
                ? Integer.parseInt(session.getAttribute("hostSeq").toString())
                : null;
        
        // 요청에서 게시글의 userSystem.out.println();Seq 파라미터 처리
        int postUserSeq;
        try {
            postUserSeq = Integer.parseInt(request.getParameter("userSeq"));
        } catch (NumberFormatException e) {
            return new ModelAndView("error.jsp");
        }

        // 서비스 레이어에서 게시글 조회 및 권한 검증 처리
        BoardDTO boardDTO = boardService.select(postUserSeq, userSeq, hostSeq);

        // 게시글이 존재하지 않거나, 권한이 없는 경우 처리
        if (boardDTO == null) {
            return new ModelAndView("error.jsp");
        }

        // 게시글을 보여줄 뷰로 이동
        return new ModelAndView("boardView.jsp");
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
