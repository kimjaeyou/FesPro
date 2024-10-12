package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.util.DbUtil;

public class FesDAOImpl implements FesDAO{
	/*
	@Override
	public List<FesDTO> selectAll() throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<FesDTO> fesDTOList = new ArrayList<FesDTO>();
		
		String sql = "select * from fes"; //select * from fes where host_seq=현재로그인 된 세션의 sequence
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FesDTO fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
										   rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
										   rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
										   rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
										   rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24), rs.getInt(25),
										   rs.getInt(26));
				fesDTOList.add(fesDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return fesDTOList;
	}
	*/
	
}
