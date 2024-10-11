package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.UsersDTO;
import wep.mvc.util.DbUtil;

public class SuperAuthDAOImpl implements SuperAuthDAO {

	 public List<UsersDTO> selectAll() {
		  Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  List<UsersDTO> list = new ArrayList<UsersDTO>();
		  try {
		   con = DbUtil.getConnection();
		   ps = con.prepareStatement("SELECT * FROM USERS ORDER BY USER_SEQ");
		   rs  = ps.executeQuery();
		   while(rs.next()){
		    list.add(new UsersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
		      rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10)));
		   }

		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   DbUtil.dbClose(con, ps, rs);
		  }
		  return list;
		 }
}
