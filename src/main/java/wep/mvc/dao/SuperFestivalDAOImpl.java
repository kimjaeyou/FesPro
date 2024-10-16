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
import wep.mvc.dto.UsersReviewDTO;
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
	public FesDTO select(FesDTO fes, boolean isWaitFes) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// List<FesDTO> list = new ArrayList<FesDTO>();
		System.out.println(fes.getSVCID());
		FesDTO result = null;

		String sql;
		if(isWaitFes) {
			System.out.println("대기상태인 행사  DB조회");
		}
		else {
			System.out.println("완료나 비활성 행사  DB조회");
		}
		
		if(!isWaitFes) sql = "select * from FES where SVCID = ?"; //FES에서 조회
		else sql = "select * from WAIT_FES where SVCID= ?"; //WAIT에서 조회
		

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			rs = ps.executeQuery();

			if (rs.next()) {
				String svcid = rs.getString("SVCID");
				System.out.println("다오에서 찍은 svcid="+svcid);
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
				result.setRCPTENDDT(rs.getString("RCPTENDDT")); //누락된 부분 객체에 넣어주기
				
				//System.out.println("@@@@@@@@@@@@@@@@" +rs.getString("RCPTENDDT"));
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
	
	/**
	 * 행사 수정
	 */
	@Override
	public int update(FesDTO fesDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "UPDATE FES SET "
				+ "MAXCLASSNM =?, "
				+ "MINCLASSNM =?, "
				+ "SVCSTATNM=?, "
				+ "SVCNM =?, "
				+ "PAYATNM=?, "
				+ "PLACENM=?, "
				+ "USETGTINFO =?, "
				+ "X=?, "
				+ "Y=?, "
				+ "SVCOPNBGNDT=?, "
				+ "SVCOPNENDDT=?, "
				+ "RCPTBGNDT=?, "
				+ "AREANM=?, "
				+ "IMGURL=?, "
				+ "DTLCONT=?, "
				+ "TELNO=?, "
				+ "V_MAX=?, "
				+ "V_MIN=?, "
				+ "REVSTDDAY=?, "
				+ "REVSTDDAYNM=?, "
				+ "FES_STATE=?, "
				+ "UPDATE_DATE=?, "
				+ "MAXNUM=?, "
				+ "PRICE=?, "
				//+ "HOST_SEQ =? "
				+ "RCPTENDDT=? "
				+ "WHERE SVCID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, fesDto.getMAXCLASSNM());
		    ps.setString(2, fesDto.getMINCLASSNM());
		    ps.setString(3, fesDto.getSVCSTATNM());
		    ps.setString(4, fesDto.getSVCNM());
		    ps.setString(5, fesDto.getPAYATNM());
		    ps.setString(6, fesDto.getPLACENM());
		    ps.setString(7, fesDto.getUSETGTINFO());
		    ps.setString(8, fesDto.getX());
		    ps.setString(9, fesDto.getY());
		    ps.setString(10, fesDto.getSVCOPNBGNDT());
		    ps.setString(11, fesDto.getSVCOPNENDDT());
		    ps.setString(12, fesDto.getRCPTBGNDT());
		    ps.setString(13, fesDto.getAREANM());
		    ps.setString(14, fesDto.getIMGURL());
		    ps.setString(15, fesDto.getDTLCONT());
		    ps.setString(16, fesDto.getTELNO());
		    ps.setString(17, fesDto.getV_MAX());
		    ps.setString(18, fesDto.getV_MIN());
		    ps.setString(19, fesDto.getREVSTDDAY());
		    ps.setString(20, fesDto.getREVSTDDAYNM());
		    ps.setInt(21, fesDto.getFes_state());
		    ps.setString(22, fesDto.getUpdate_date());
		    ps.setInt(23, fesDto.getMAXNUM());
		    ps.setInt(24, fesDto.getPRICE());
		    ps.setString(25, fesDto.getRCPTENDDT());
		    ps.setString(26, fesDto.getSVCID());

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

	/**
	 * 리뷰 쓴 유저 검색
	 */
	@Override
	public List<UsersDTO> selectReviewUser(FesDTO fes) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsersDTO> list = new ArrayList<UsersDTO>();

		String sql = "SELECT * FROM FES_REVIEW_USER_VIEW";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int age = rs.getInt("AGE");
				String gender = rs.getString("GENDER");
				int userSeq = rs.getInt("USER_SEQ");
				int score = rs.getInt("SCORE");
				 
				UsersReviewDTO user =  new UsersReviewDTO();
				user.setUser_seq(userSeq);
				user.setAge(age);
				user.setGender(gender);
				user.setReviewScore(score);
				
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	public List<FesDTO> dashFesSelectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "select * from WAIT_FES where FES_STATE = 0";

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
	 * 관리자용 모든행사 조회
	 */
	@Override
	public List<FesDTO> selectAllSuper() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "SELECT Null as WAIT_FES_SEQ, f.* FROM fes f WHERE FES_STATE = '1' or FES_STATE = '3' UNION ALL SELECT w.* FROM WAIT_FES w";

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

	@Override
	public List<FesDTO> dashFesWaitFesSelectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "select * from WAIT_FES where FES_STATE = 2";

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
	
	@Override
	public List<FesDTO> dashFesCancleWaitFesSelectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();

		String sql = "select * from FES where FES_STATE = 3";

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
	 * waitfes에서 삭제
	 */
	@Override
	public int delete(FesDTO fes) {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "delete from WAIT_FES WHERE SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			
			result = ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteFes(FesDTO fes) {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "delete from FES WHERE SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, fes.getSVCID());
			
			result = ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	
}
