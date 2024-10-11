package wep.mvc.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardSerevice{

/** 카테고리별 게시글 작성 */
	

	
	public int insertByCtg(BoardDTO boardDTO) throws SQLException {
		
		return 0;
	}

	
	public int update(BoardDTO boardDTO) throws SQLException {
	
		return 0;
	}

	
	public int delete(String boardSeq, String user_pw) {
	
		return 0;
	}

	
	public List<BoardDTO> selectByCtg(BoardDTO boardDTO, BoardCategoryDTO boardCategoryDTO) {
	
		return null;
	}
	
	
	public BoardDTO select (int userSeq) {
	
		return null;
	}

}
