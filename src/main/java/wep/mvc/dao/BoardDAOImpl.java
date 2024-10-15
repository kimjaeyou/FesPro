package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	private Connection conn;
	private ResultSet rs;

	@Override
	public int insert(BoardDTO boardDTO) throws SQLException {

		// 게시글 삽입 쿼리 작성 및 실행
		String sql = "INSERT INTO board (sub, B_content, category_Seq, user_Seq, host_Seq) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, boardDTO.getSub());
			pstmt.setString(2, boardDTO.getbContent());
			pstmt.setInt(3, boardDTO.getCategorySeq());
			pstmt.setInt(4, boardDTO.getUserSeq());
			pstmt.setInt(5, boardDTO.getHostSeq());
			pstmt.executeUpdate();
		}
		return 0;
	}

	

	@Override
	public int update(BoardDTO boardDTO) throws SQLException {

		return 0;
	}

	@Override
	public int delete(int boardSeq, int userSeq, int hostSeq) throws SQLException {
		
		String sql = "DELETE FROM board WHERE board_seq = ? AND (user_seq = ? OR host_seq = ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            
	            pstmt.setInt(1, boardSeq);
	            pstmt.setInt(2, userSeq);
	            pstmt.setInt(3, hostSeq);
	            pstmt.executeUpdate();
	            
		}        

		return 0;
	}
		

	@Override
	public List<BoardDTO> selectByCtg(BoardDTO boardDTO, BoardCategoryDTO boardCategoryDTO) throws SQLException {
	   
	    String sql = "SELECT board_seq, sub, category_seq FROM board WHERE category_seq = ?";

	    
	    List<BoardDTO> boardList = new ArrayList<>();

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	       
	        pstmt.setInt(1, boardCategoryDTO.getCategorySeq());

	        try (ResultSet rs = pstmt.executeQuery()) {
	        
	            while (rs.next()) {
	                BoardDTO bDTO = new BoardDTO();
	                bDTO.setBoardSeq(rs.getInt("board_seq"));
	                bDTO.setCategorySeq(rs.getInt("category_seq"));
	                bDTO.setSub(rs.getString("sub"));
	             
	                boardList.add(bDTO);
	            }
	        }
	    }

	    // 조회된 게시글 리스트 반환
	    return boardList;
	}


	@Override
	public BoardDTO select(int postUserSeq) throws SQLException {
		String query = "SELECT * FROM board WHERE user_seq = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, postUserSeq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					// 게시글 정보 가져오기
					BoardDTO boardDTO = new BoardDTO();
					boardDTO.setBoardSeq(rs.getInt("board_seq"));
					boardDTO.setCategorySeq(rs.getInt("category_seq"));
					boardDTO.setUserSeq(rs.getInt("user_seq"));
					boardDTO.setSub(rs.getString("sub"));
					boardDTO.setbContent(rs.getString("b_content"));
					boardDTO.setHostSeq(rs.getInt("host_seq"));
					return boardDTO; // 게시글 정보를 반환
				}
			}
		}
		return null;
	}
}
