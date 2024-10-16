package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.util.DbUtil;

public class MainDAOImpl {

	public int insert(String sid, int user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into USER_LIKE values(USER_LIKE_SEQ.NEXTVAL, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, user);
			ps.setString(2, sid);

			result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			}

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	public List<String> selecLike(int user_seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> dto = new ArrayList<>();

		// select * from reservation where user_seq = ?
		String sql = "select SVCID from user_like where user_seq = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_seq);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.add(rs.getString(1));
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	public List<ReviewDTO> selecReview(String sid) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> dto = new ArrayList<>();

		String sql = "select * from REVIEW where SVCID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sid);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.add(new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

}