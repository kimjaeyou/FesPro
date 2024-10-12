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
		
		String sql= "insert into RESERVATION values(RESERV_SEQ.NEXTVAL(), ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
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
	public ReservationDTO selectByUserSeq(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}

}
