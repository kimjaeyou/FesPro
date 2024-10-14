package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.util.DbUtil;

public class MainDAOImpl {

	public int insert(String sid,int user) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		int result = 0;
		
		String sql= "insert into USER_LIKE values(USER_LIKE_SEQ.NEXTVAL, ?, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, user);
			ps.setString(2, sid);
			
			result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("성공");
			}
		
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
}
