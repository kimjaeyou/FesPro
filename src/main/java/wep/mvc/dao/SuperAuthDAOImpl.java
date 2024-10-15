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
		 System.out.println("셀렉트올 다오");
		  Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  List<UsersDTO> list = new ArrayList<UsersDTO>();
		  try {
		   con = DbUtil.getConnection();
		   ps = con.prepareStatement("SELECT * FROM USERS ORDER BY USER_SEQ");
		   rs  = ps.executeQuery();
		   while(rs.next()){
		    list.add(new UsersDTO(
		    		rs.getInt("USER_SEQ"),
		    		rs.getString("USER_ID"),
		    		rs.getString("USER_PW"), 
		    		rs.getInt("AGE"), 
		    		rs.getString("ADDR"),
		    		rs.getString("GENDER"),
		    		rs.getString("EMAIL"),
		    		rs.getString("USER_NAME"),
		    		rs.getString("DISABLE"),
		    		rs.getString("USER_TEL"),
		    		rs.getInt("USER_BEN_CHECK")));
		   }

		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   DbUtil.dbClose(con, ps, rs);
		  }
		  return list;
		 }
	 
			/*
			 * @Override public UsersDTO selectById(String id){ Connection con = null;
			 * PreparedStatement ps = null; ResultSet rs = null; UsersDTO user = null;
			 * String sql = "SELECT * FROM USERS WHERE USER_ID=?"; try {
			 * con=DbUtil.getConnection(); ps=con.prepareStatement(sql); ps.setString(1,
			 * id); rs=ps.executeQuery();
			 * 
			 * if(rs.next()) { user = new
			 * UsersDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.
			 * getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.
			 * getString(10)); }
			 * 
			 * }catch (SQLException e) { e.printStackTrace(); } finally {
			 * DbUtil.dbClose(con, ps, rs);; }
			 * 
			 * 
			 * return user; }
			 * 
			 * @Override public int update(UsersDTO user) { PreparedStatement ps = null;
			 * Connection con =null; int result=0; try { con = DbUtil.getConnection(); ps =
			 * con.
			 * prepareStatement("update USERS set user_seq=?,user_id=?,user_pw=?,age=?,addr=?,gender=?,email=?,user_name=?,disable=?,user_tel=? where user_id=?"
			 * );
			 * 
			 * ps.setInt(1, user.getUser_seq()); ps.setString(2, user.getUser_id());
			 * ps.setString(3, user.getUser_pw()); ps.setInt(4, user.getAge());
			 * ps.setString(5, user.getAddr()); ps.setInt(6, user.getGender());
			 * ps.setString(7, user.getEmail()); ps.setString(8, user.getUser_name());
			 * ps.setInt(9, user.getDisable()); ps.setString(10, user.getUser_tel());
			 * ps.setString(11, user.getUser_id());
			 * 
			 * result = ps.executeUpdate(); } catch (SQLException e) { e.printStackTrace();
			 * } finally { DbUtil.dbClose( con , ps); } return result; }
			 */
	 
}
