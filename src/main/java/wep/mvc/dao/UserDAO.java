package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.UsersDTO;


public interface UserDAO {

	// 로그인
	UsersDTO loginCheck(UsersDTO usersDTO)throws SQLException;
	
	
	//회원가입
	UsersDTO insert(UsersDTO usersDTO)throws SQLException;
	
	
	//회원탈퇴
	UsersDTO delete(UsersDTO usersDTO)throws SQLException;
	
	
	
}
