package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FES_TAG;
import wep.mvc.dto.FesDTO;
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

	public List<FesDTO> selecMost() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "SELECT F.SVCID, F.MAXCLASSNM, F.MINCLASSNM, F.SVCSTATNM, F.SVCNM,"
				+ "F.PAYATNM, F.PLACENM, F.USETGTINFO, F.X, F.Y, F.SVCOPNBGNDT, F.SVCOPNENDDT,"
				+ "F.RCPTBGNDT, F.AREANM, F.IMGURL, F.DTLCONT, F.TELNO, F.V_MAX, F.V_MIN,"
				+ "F.REVSTDDAY, F.REVSTDDAYNM, F.FES_STATE, F.UPDATE_DATE, F.MAXNUM, F.PRICE,"
				+ "F.HOST_SEQ, F.RCPTENDDT, COUNT(R.RESERV_SEQ) AS count FROM  FES F LEFT JOIN "
				+ "reservation R ON F.SVCID = R.SVCID GROUP BY  F.SVCID, F.MAXCLASSNM,"
				+ "F.MINCLASSNM, F.SVCSTATNM, F.SVCNM, F.PAYATNM, F.PLACENM, F.USETGTINFO, F.X,"
				+ "F.Y, F.SVCOPNBGNDT, F.SVCOPNENDDT, F.RCPTBGNDT, F.AREANM, F.IMGURL,"
				+ "F.DTLCONT, F.TELNO, F.V_MAX, F.V_MIN, F.REVSTDDAY, F.REVSTDDAYNM,"
				+ "F.FES_STATE, F.UPDATE_DATE, F.MAXNUM, F.PRICE, F.HOST_SEQ, F.RCPTENDDT";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(28) > 0) {
					FesDTO fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							rs.getString(20), rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
							rs.getInt(25), rs.getInt(26), rs.getString(27));
					list.add(fesDTO);
				}
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}
	
	
	public int insertAlarm(int user,String content) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into ALARM values(ALARM_SEQ.NEXTVAL,?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, user);
			ps.setString(2, content);

			result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
			}

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	
	public List<FES_TAG> selectTag(String sid) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FES_TAG> dto = new ArrayList<>();

		String sql = "select * from FES_TAG where SVCID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sid);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.add(new FES_TAG(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}
	
	
	
	
	
	public int insertTagLike(int user,List<Integer>Tagseq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "insert into TAG_LIKE values(TAG_LIKE_SEQ.NEXTVAL,?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			for(int seq:Tagseq) {
				ps.setInt(1, seq);
				ps.setInt(2, user);

				result = ps.executeUpdate();
				
				if (result == 1) {
					System.out.println("성공");
				}
			}
			

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	public List<FES_TAG> selectTagS() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FES_TAG> dto = new ArrayList<>();

		String sql = "select * from FES_TAG";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.add(new FES_TAG(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}
	
	
	

}