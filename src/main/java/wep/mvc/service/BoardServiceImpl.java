package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.BoardCtgDAO;
import wep.mvc.dao.BoardCtgDAOImpl;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO = new BoardDAOImpl();
	private BoardCtgDAO boardCategoryDAO = new BoardCtgDAOImpl();

	@Override
	public int delete(int boardSeq, int userSeq, int hostSeq) throws SQLException {
		System.out.println("service delete ===>");
		int delete = boardDAO.delete(boardSeq, userSeq, hostSeq);

		if (delete == 0) {
			return 0;
		}

		return 0;
	}

	@Override
	public BoardDTO select(int boardSeq) throws SQLException {
		System.out.println("service select 세부 ===>");
		BoardDTO bDTO = boardDAO.select(boardSeq);

		return bDTO;
	}

	@Override
	public int update(BoardDTO boardDTO) throws SQLException {
		System.out.println("service update ===>");		
		return 0;
	}

	@Override
	public int write(BoardDTO boardDTO)
			throws SQLException {
		System.out.println("service write ===>");
	   
		if (boardDTO.getUserSeq() != 0 && boardDTO.getCategorySeq() == 0) {
	        throw new IllegalArgumentException("사용자는 카테고리 0에 글을 쓸 수 없습니다.");
	    }

	    if (boardDTO.getHostSeq() != 0 && boardDTO.getCategorySeq() == 1) {
	        throw new IllegalArgumentException("호스트는 카테고리 1에 글을 쓸 수 없습니다.");
	    }
		return boardDAO.insert(boardDTO);

	}

	@Override
	public List<BoardDTO> selectByCtg() throws SQLException {
		System.out.println("\nservice selectByCtg ===>");
		List<BoardDTO> list = boardDAO.selectByCtg();
		System.out.println("서비스 구현 list 가져오는지 확인하는 출력문 : " + list);
		
		return list;
	}

}