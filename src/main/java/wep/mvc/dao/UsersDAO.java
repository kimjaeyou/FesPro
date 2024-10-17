package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.UsersDTO;

public interface UsersDAO {

	// 로그인
	UsersDTO login(UsersDTO usersDTO) throws SQLException;

	// 아이디 중복체크
	boolean idCheck(String id) throws SQLException;

	// 회원가입
	int insert(UsersDTO usersDTO) throws SQLException;

	// 일단 시퀀스를 찾아서
	int selectWallet(String id) throws SQLException;

	// 찾은 시퀀스로 지갑 만들기.
	int insertWallet(int seq) throws SQLException;

}
