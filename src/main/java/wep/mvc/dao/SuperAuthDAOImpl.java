package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
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

	@Override
	public UsersDTO select(UsersDTO user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// List<FesDTO> list = new ArrayList<FesDTO>();
		UsersDTO userDto = null;
		String sql = "SELECT * FROM USERS WHERE USER_ID=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUser_id());
			rs = ps.executeQuery();
			

			if (rs.next()) {
				userDto = new UsersDTO
						(rs.getInt("USER_SEQ"),
					    		rs.getString("USER_ID"),
					    		rs.getString("USER_PW"), 
					    		rs.getInt("AGE"), 
					    		rs.getString("ADDR"),
					    		rs.getString("GENDER"),
					    		rs.getString("EMAIL"),
					    		rs.getString("USER_NAME"),
					    		rs.getString("DISABLE"),
					    		rs.getString("USER_TEL"),
					    		rs.getInt("USER_BEN_CHECK")
								);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return userDto;
	}
	
	@Override
	public int update(UsersDTO user) {
		System.out.println("업데이트 다오");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "UPDATE USERS SET USER_BEN_CHECK = ? WHERE USER_SEQ =?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, user.getUser_ben_check());
			ps.setInt(2, user.getUser_seq());

			result = ps.executeUpdate();
			System.out.println("다오 result: "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int update(UsersDTO user, int benCheck) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HostDTO> hostSelectAll() {
		 System.out.println("셀렉트올 다오");
		  Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  List<HostDTO> list = new ArrayList<HostDTO>();
		  try {
		   con = DbUtil.getConnection();
		   ps = con.prepareStatement("SELECT * FROM HOST ORDER BY HOST_SEQ");
		   rs  = ps.executeQuery();
		   while(rs.next()){
		    list.add(new HostDTO(
		    		rs.getInt("HOST_SEQ"),
		    		rs.getString("HOSTID"),
		    		rs.getString("COM_NAME"), 
		    		rs.getString("HOST_PASSWORD"), 
		    		rs.getString("HOST_TEL"),
		    		rs.getString("HOST_NAME"),
		    		rs.getInt("HOST_CHECK"),
		    		rs.getString("REP_NAME"),
		    		rs.getInt("HOST_BEN_CHECK")));
		   }

		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   DbUtil.dbClose(con, ps, rs);
		  }
		  return list;
		 }
	
	@Override
	public HostDTO hostSelect(HostDTO host) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// List<FesDTO> list = new ArrayList<FesDTO>();
		HostDTO hostDto = null;
		String sql = "SELECT * FROM HOST WHERE HOSTID=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, host.getHost_id());
			rs = ps.executeQuery();
			

			if (rs.next()) {
				hostDto = new HostDTO
						(
					    		rs.getInt("HOST_SEQ"),
					    		rs.getString("HOSTID"),
					    		rs.getString("COM_NAME"), 
					    		rs.getString("HOST_PASSWORD"), 
					    		rs.getString("HOST_TEL"),
					    		rs.getString("HOST_NAME"),
					    		rs.getInt("HOST_CHECK"),
					    		rs.getString("REP_NAME"),
					    		rs.getInt("HOST_BEN_CHECK"));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return hostDto;
	}
	
	@Override
	public int hostUpdate(HostDTO host) {
		System.out.println("업데이트 다오");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		String sql = "UPDATE HOST SET HOST_CHECK = ?,HOST_BEN_CHECK = ?  WHERE HOST_SEQ =?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, host.getHost_check());
			ps.setInt(2, host.getHost_ben_check());
			ps.setInt(3, host.getHost_seq());

			result = ps.executeUpdate();
			System.out.println("다오 result: "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}

		return result;
	}
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
	 

