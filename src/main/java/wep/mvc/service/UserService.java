package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dto.UsersDTO;

public interface UserService {

	// 로그인
	UsersDTO login(UsersDTO usersDTO) throws SQLException;

	// 아이디 중복체크
	boolean idCheck(String id) throws SQLException;

	// 회원가입
	int insert(UsersDTO usersDTO) throws SQLException;

	// 회원탈퇴
	int delete(String id) throws SQLException;

	// 회원수정
	int update(UsersDTO usersDTO) throws SQLException;

	// 회원데이터 가져오기 - 수정할때 필요
	UsersDTO selectUser(UsersDTO usersDTO) throws SQLException;

}
