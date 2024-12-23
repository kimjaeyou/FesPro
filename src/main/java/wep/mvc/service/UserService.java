package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dto.UsersDTO;

public interface UserService {

	// 로그인
	UsersDTO login(UsersDTO usersDTO) throws Exception;

	// 아이디 중복체크
	boolean idCheck(String id) throws SQLException;

	// 회원가입
	int insert(UsersDTO usersDTO) throws SQLException;

}
