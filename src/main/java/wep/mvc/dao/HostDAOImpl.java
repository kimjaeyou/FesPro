package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wep.mvc.dto.HostDTO;
import wep.mvc.util.DbUtil;

public class HostDAOImpl implements HostDAO {

	// 로그인
	@Override
	public HostDTO login(HostDTO hostDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HostDTO dbDTO = null;

		String sql = "select * from host where hostid=? and host_password=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, hostDTO.getHost_id());
			ps.setString(2, hostDTO.getHost_pw());

			rs = ps.executeQuery();
			if (rs.next()) {
				dbDTO = new HostDTO(rs.getInt("HOST_SEQ"), 
									rs.getString("HOSTID"),
									rs.getString("COM_NAME"),
									rs.getString("HOST_PASSWORD"), 
									rs.getString("HOST_TEL"), 
									rs.getString("HOST_NAME"), 
									rs.getInt("HOST_CHECK"),
									rs.getString("REP_NAME"), 
									rs.getInt("HOST_BEN_CHECK"));
			}
			

		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

	// 회원가입
	@Override
	public int insert(HostDTO hostDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("INSERT INTO host(HOST_SEQ,HOSTID,HOST_PASSWORD,HOST_TEL,HOST_NAME,REP_NAME,HOST_CHECK,HOST_BEN_CHECK,COM_NAME) "
					+ "VALUES(host_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ? ,?)");

			ps.setString(1, hostDTO.getHost_id());
			ps.setString(2, hostDTO.getHost_pw());
			ps.setString(3, hostDTO.getHost_tel());
			ps.setString(4, hostDTO.getHost_name());
			ps.setString(5, hostDTO.getRep_name());
			ps.setInt(6, hostDTO.getHost_check());
			ps.setInt(7, hostDTO.getHost_ben_check());
			ps.setString(8, hostDTO.getCom_name());
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 아이디 중복체크
	@Override
	public boolean idCheck(String id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		boolean result = false;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select host_id from host where hostid=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}


}