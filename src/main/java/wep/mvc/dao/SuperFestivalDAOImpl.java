package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.util.DbUtil;

public class SuperFestivalDAOImpl implements SuperFestivalDAO {

	/**
	 * 모든행사 조회
	 */
	public List<FesDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "select * from FES";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String svcid = rs.getString("SVCID");
				String MaxClassNm = rs.getString("MAXCLASSNM");
				String MinClassNm = rs.getString("MINCLASSNM");
				String svcStateNm = rs.getString("SVCSTATNM");
				String svcNm = rs.getString("SVCNM");
				String payAtNm = rs.getString("PAYATNM");
				String placeNm = rs.getString("PLACENM");
				String useTgtInfo = rs.getString("USETGTINFO");
				String x = rs.getString("X");
				String y = rs.getString("Y");
				String svcOpnbgndt = rs.getString("SVCOPNBGNDT");
				String svcOpnenddt = rs.getString("SVCOPNENDDT");
				String rcptdgndt = rs.getString("RCPTBGNDT");
				String areaNm = rs.getString("AREANM");
				String imgUrl = rs.getString("IMGURL");
				String dtlCont = rs.getString("DTLCONT");
				String telNo = rs.getString("TELNO");
				String vMax = rs.getString("V_MAX");
				String vMin = rs.getString("V_MIN");
				String revStdDay = rs.getString("REVSTDDAY");
				String revStdDayNm = rs.getString("REVSTDDAYNM");
				int fesState = rs.getInt("FES_STATE");
				String updateDate = rs.getString("UPDATE_DATE");
				int maxNum = rs.getInt("MAXNUM");
				int price = rs.getInt("PRICE");
				int hostSeq = rs.getInt("HOST_SEQ");

				FesDTO fes = new FesDTO(svcid, MaxClassNm, MinClassNm, svcStateNm, svcNm, payAtNm, placeNm, useTgtInfo,
						x, y, svcOpnbgndt, svcOpnenddt, rcptdgndt, areaNm, imgUrl, dtlCont, telNo, vMax, vMin,
						revStdDay, revStdDayNm, fesState, updateDate, maxNum, price, hostSeq);
				list.add(fes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 행사 조회
	 */
	@Override
	public FesDTO select(FesDTO fes) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// List<FesDTO> list = new ArrayList<FesDTO>();
		FesDTO result = null;

		String sql = "select * from FES where SVCID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			rs = ps.executeQuery();

			if (rs.next()) {
				String svcid = rs.getString("SVCID");
				String MaxClassNm = rs.getString("MAXCLASSNM");
				String MinClassNm = rs.getString("MINCLASSNM");
				String svcStateNm = rs.getString("SVCSTATNM");
				String svcNm = rs.getString("SVCNM");
				String payAtNm = rs.getString("PAYATNM");
				String placeNm = rs.getString("PLACENM");
				String useTgtInfo = rs.getString("USETGTINFO");
				String x = rs.getString("X");
				String y = rs.getString("Y");
				String svcOpnbgndt = rs.getString("SVCOPNBGNDT");
				String svcOpnenddt = rs.getString("SVCOPNENDDT");
				String rcptdgndt = rs.getString("RCPTBGNDT");
				String areaNm = rs.getString("AREANM");
				String imgUrl = rs.getString("IMGURL");
				String dtlCont = rs.getString("DTLCONT");
				String telNo = rs.getString("TELNO");
				String vMax = rs.getString("V_MAX");
				String vMin = rs.getString("V_MIN");
				String revStdDay = rs.getString("REVSTDDAY");
				String revStdDayNm = rs.getString("REVSTDDAYNM");
				int fesState = rs.getInt("FES_STATE");
				String updateDate = rs.getString("UPDATE_DATE");
				int maxNum = rs.getInt("MAXNUM");
				int price = rs.getInt("PRICE");
				int hostSeq = rs.getInt("HOST_SEQ");

				result = new FesDTO(svcid, MaxClassNm, MinClassNm, svcStateNm, svcNm, payAtNm, placeNm, useTgtInfo, x,
						y, svcOpnbgndt, svcOpnenddt, rcptdgndt, areaNm, imgUrl, dtlCont, telNo, vMax, vMin, revStdDay,
						revStdDayNm, fesState, updateDate, maxNum, price, hostSeq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	/**
	 * 행사 수정
	 */
	@Override
	public int update(FesDTO festivalDto, int state) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "UPDATE FES SET FES_STATE = ? WHERE SVCID =?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, state);
			ps.setString(2, festivalDto.getSVCID());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public List<UsersDTO> selectUser(FesDTO fes) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsersDTO> list = new ArrayList<UsersDTO>();

		String sql = "SELECT * FROM FES_RESERV_USER_VIEW WHERE SVCID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			
			rs = ps.executeQuery();

			while (rs.next()) {
				String userSeq = rs.getString("USER_SEQ");
				String userId = rs.getString("USER_ID");
				String userPw = rs.getString("USER_PW");
				int age =rs.getInt("AGE");
				String addr = rs.getString("ADDR");
				String email = rs.getString("EMAIL");
				String userName= rs.getString("USER_NAME");
				String tel = rs.getString("USER_TEL");
				String gender = rs.getString("GENDER");
				String disable = rs.getString("DISABLE");
				int ban = rs.getInt("USER_BEN_CHECK");
				
				UsersDTO user =new UsersDTO(userId, userPw, age, addr, gender, email, userName, disable,tel);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<ReviewDTO> selectReview(FesDTO fes) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		String sql = "SELECT * FROM REVIEW WHERE SVCID=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int reviewSeq = rs.getInt("REVIEW_SEQ");
				int userSeq = rs.getInt("USER_SEQ");
				String svcId = rs.getString("SVCID");
				String rvContent = rs.getString("RV_CONTENT");
				int score = rs.getInt("SCORE");
				
				ReviewDTO reviewDto = new ReviewDTO(reviewSeq, userSeq, svcId, rvContent, score);
				list.add(reviewDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}
