package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wep.mvc.dto.UsersDTO;
import wep.mvc.util.DbUtil;

public class UsersDAOImpl implements UsersDAO {

	// 로그인
	@Override
	public UsersDTO login(UsersDTO usersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO dbDTO = null;

		String sql = "select * from users where user_id=? and user_pw=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDTO.getUser_id());
			ps.setString(2, usersDTO.getUser_pw());

			rs = ps.executeQuery();
			if (rs.next()) {
				dbDTO = new UsersDTO(rs.getInt("user_seq"), 
									 rs.getString("user_id"), 
									 rs.getString("user_pw"), 
									 rs.getInt("age"), 
									 rs.getString("addr"),
									 rs.getString("gender"), 
									 rs.getString("email"), 
									 rs.getString("user_name"), 
									 rs.getString("disable"), 
									 rs.getString("user_tel"));
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

	
	// 회원수정 할때 데이터 넣기위해 DB 자료 꺼내기
	@Override
	public UsersDTO selectUser(UsersDTO usersDTO)  throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO dbDTO = null;

		String sql = "select * from users where user_id=? and user_name=?";
		
		rs = ps.executeQuery();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDTO.getUser_id());
			ps.setString(2, usersDTO.getUser_name());
			rs = ps.executeQuery();
			
		if (rs.next()) {
			dbDTO = new UsersDTO(rs.getInt("user_seq"), 
								 rs.getString("user_id"), 
								 rs.getString("user_pw"), 
								 rs.getInt("age"), 
								 rs.getString("addr"),
								 rs.getString("gender"), 
								 rs.getString("email"), 
								 rs.getString("user_name"), 
								 rs.getString("disable"), 
								 rs.getString("user_tel"));
		}
		
	} finally {
		DbUtil.dbClose(con, ps, rs);
	}
		
		return dbDTO;
	}



	// 회원가입
	@Override
	public int insert(UsersDTO usersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("INSERT INTO Users VALUES(user_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, 1)");

			ps.setString(1, usersDTO.getUser_id());
			ps.setString(2, usersDTO.getUser_pw());
			ps.setInt(3, usersDTO.getAge());
			ps.setString(4, usersDTO.getAddr());
			ps.setString(5, usersDTO.getEmail());
			ps.setString(6, usersDTO.getUser_name());
			ps.setString(7, usersDTO.getUser_tel());
			ps.setString(8, usersDTO.getGender());
			ps.setString(9, usersDTO.getDisable());
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
			ps = con.prepareStatement("select user_id from users where user_id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	// 회원탈퇴
	@Override
	public int delete(String id) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update users set user_ben_check = 0 where user_id = ?");
			ps.setString(1, id);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 회원수정
	@Override
	public int update(UsersDTO usersDTO) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"update users	set user_pw=?, age=?, addr=?, gender=?, email=?, user_name=?, disable=?, user_tel=? where user_id=?");

			ps.setString(1, usersDTO.getUser_pw());
			ps.setInt(2, usersDTO.getAge());
			ps.setString(3, usersDTO.getAddr());
			ps.setString(4, usersDTO.getGender());
			ps.setString(5, usersDTO.getEmail());
			ps.setString(6, usersDTO.getUser_name());
			ps.setString(7, usersDTO.getDisable());
			ps.setString(8, usersDTO.getUser_tel());
			ps.setString(9, usersDTO.getUser_id());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}