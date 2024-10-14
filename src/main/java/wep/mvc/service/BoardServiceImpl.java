package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO = new BoardDAOImpl();
	
	
@Override
public int delete(String boardSeq, String user_pw) throws SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
	public List<BoardDTO> select(BoardDTO boardDTO, BoardCategoryDTO boardCategoryDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

@Override
	public int update(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

@Override
	public int write(Integer userSeq, Integer hostSeq, String title, String content, String categoryParam)
			throws SQLException {
		
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setUserSeq(userSeq);
    boardDTO.setHostSeq(hostSeq);
    boardDTO.setSub(title);
    boardDTO.setbContent(content);
    boardDTO.setCategorySeq(Integer.parseInt(categoryParam));
    
    return boardDAO.insert(boardDTO);
	
	}


}
