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
		  
		  try {
		   con = DbUtil.getConnection();
		   ps = con.prepareStatement("select * from customer order by id");
		   rs  = ps.executeQuery();
		   while(rs.next()){
		    FesDTO fes = new FesDTO(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0);
		    list.add(fes);
		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   DbUtil.dbClose(con,ps,rs);
		  }
		  return list;
	}
}
