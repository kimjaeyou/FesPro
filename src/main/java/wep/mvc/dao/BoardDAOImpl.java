package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.BoardDTO;
import wep.mvc.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result = 0;

	/**
	 * 게시글 등록
	 */
	@Override
	public int insert(BoardDTO boardDTO) throws SQLException {
		System.out.println("=====>  DAOImpl insert ");
		String sql = "INSERT INTO ADMIN . BOARD (BOARD_SEQ, CATEGORY_SEQ, USER_SEQ, SUB, B_CONTENT, HOST_SEQ) VALUES (board_seq.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardDTO.getCategorySeq());
			ps.setInt(2, boardDTO.getUserSeq());
			ps.setString(3, boardDTO.getSub());
			ps.setString(4, boardDTO.getbContent());
			ps.setInt(5, boardDTO.getHostSeq());

			result = ps.executeUpdate();
			con.commit();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 게시글 수정
	 */
	@Override
	public int update(BoardDTO boardDTO) throws SQLException {
		System.out.println("=====>  DAOImpl update ");
		String sql = "UPDATE board SET SUB = ?, B_CONTENT = ? WHERE board_seq = ? AND (user_seq = ? OR host_seq = ?)";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			con.commit();
			ps.setString(1, boardDTO.getSub());
			ps.setString(2, boardDTO.getbContent());
			ps.setInt(3, boardDTO.getBoardSeq());
			ps.setInt(3, boardDTO.getUserSeq());
			ps.setInt(4, boardDTO.getHostSeq());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	/**
	 * 게시글 삭제
	 */
	@Override
	public int delete(int boardSeq, int userSeq, int hostSeq) throws SQLException {
		System.out.println("=====>  DAOImpl delete ");
		String sql = "DELETE FROM ADMIN . BOARD WHERE board_seq = ? AND (user_seq = ? OR host_seq = ?)";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);

			result = ps.executeUpdate();
			con.commit();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 모든 게시글 불러오기
	 */
	@Override
	public List<BoardDTO> selectByCtg() throws SQLException {

		List<BoardDTO> list = new ArrayList<>();

		String sql = "SELECT BOARD_SEQ, CATEGORY_SEQ, SUB, USER_SEQ, HOST_SEQ FROM ADMIN.BOARD";

		try {
			con = DbUtil.getConnection();

			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			con.commit();
			
			while (rs.next()) {
					BoardDTO board = new BoardDTO(rs.getInt("BOARD_SEQ"), rs.getInt("CATEGORY_SEQ"),
							rs.getString("SUB"), rs.getInt("USER_SEQ"), rs.getInt("HOST_SEQ"));
					list.add(board);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	/**
	 * 상세보기
	 */
	@Override
	public BoardDTO select(int userSeq) throws SQLException {
		System.out.println("=====>  DAOImpl select ");
		BoardDTO board = null;

		String sql = "SELECT * FROM board WHERE user_seq = ?";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);

			rs = ps.executeQuery();
			con.commit();
			if (rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				return board; // 게시글 정보를 반환
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return board;
	}
}
