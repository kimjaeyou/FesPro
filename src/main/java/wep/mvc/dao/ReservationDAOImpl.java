package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.util.DbUtil;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public int insert(ReservationDTO reservation) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		int result = 0;
		
		String sql= "insert into RESERVATION values(RESERV_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
		// insert into RESERVATION values(RESERV_SEQ.NEXTVAL(), ?, ?, SYSDATE, ?, ?, ?, ?, ?)
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reservation.getUserSeq());
			ps.setString(2, reservation.getSVCID());
			ps.setString(3, reservation.getSvcDate());
			ps.setString(4, reservation.getSvcTime());
			ps.setInt(5, reservation.getResvPeo());
			ps.setInt(6, reservation.getResvPrice());
			ps.setInt(7, reservation.getResvCheck());
			
			result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("성공");
			}
		
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public ReservationDTO selectByUserSeq(int userSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where user_seq = ? 
		String sql = "select * from reservation where user_seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectByResvSeq(int resvSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where resv_Seq = ? 
		String sql = "select * from reservation where reserv_Seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resvSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectBySVCID(String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where SVCID = ? 
		String sql = "select * from reservation where SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, SVCID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectByUserSeqAndSVCID(int userSeq, String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where user_seq = ? and SVCID = ? 
		String sql = "select * from reservation where user_seq = ? and SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			ps.setString(2, SVCID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

}
