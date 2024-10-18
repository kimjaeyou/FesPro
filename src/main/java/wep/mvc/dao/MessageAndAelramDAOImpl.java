package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.MESSAGE;
import wep.mvc.util.DbUtil;

public class MessageAndAelramDAOImpl implements MessageAndAlramDAO {

	@Override
	public List<MESSAGE> select(int uSeq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<MESSAGE> list = new ArrayList<MESSAGE>();
		
		String sql = "select * from MESSAGE where USER_SEQ=?";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, uSeq);
			rs=ps.executeQuery();
			System.out.println("비상!!!!");
			while(rs.next()) {
				System.out.println("rs.getInt(1)"+rs.getInt(1));
				MESSAGE m = new MESSAGE(rs.getInt(1), rs.getInt(6), rs.getInt(2),
									    rs.getString(3), rs.getString(4), rs.getString(5));
				
				list.add(m);
				System.out.println("ㅋㅋㅂ");
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
}
