package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dto.HostDTO;

public interface HostService {

	// 회원가입
	int insert(HostDTO dto)throws SQLException;
	
	// 로그인
	HostDTO login(HostDTO usersDTO) throws SQLException;

	// 아이디 중복체크
	boolean idCheck(String id) throws SQLException;

}