package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	private Connection conn;
	private ResultSet rs;

	@Override
	public int insert(BoardDTO boardDTO) throws SQLException {
		
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws SQLException {
	
		return 0;
	}

	@Override
	public int delete(String boardSeq, String user_pw) {
	
		return 0;
	}

	@Override
	public List<BoardDTO> selectByCtg(BoardDTO boardDTO, BoardCategoryDTO boardCategoryDTO) {
	
		return null;
	}
	
	@Override
	public BoardDTO select (int userSeq) {
		String SQL = "SELECT * FROM BOARD WHERE USER_SEQ = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, userSeq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				BoardDTO bDTO = new BoardDTO();
				bDTO.setBoardSeq(rs.getInt(1));
				bDTO.setCategorySeq(rs.getInt(2));
				bDTO.setUserSeq(rs.getInt(3));
				bDTO.setSub(rs.getString(4));
				bDTO.setbContent(rs.getString(5));
				bDTO.setHostSeq(rs.getInt(6));
				return bDTO;
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
