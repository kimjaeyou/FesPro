package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public interface BoardService {
	
	public int write(Integer userSeq, Integer hostSeq, String title, String content, String categoryParam)
            throws SQLException;

	
	public int update(BoardDTO boardDTO) throws SQLException;

	
	public int delete(String boardSeq, String user_pw) throws SQLException;


	BoardDTO select(int postUserSeq, Integer userSeq, Integer hostSeq) throws SQLException;
	
	
}
