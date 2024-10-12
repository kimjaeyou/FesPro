package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
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
}
