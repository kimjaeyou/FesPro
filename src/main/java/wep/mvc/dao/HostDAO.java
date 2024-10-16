package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.HostDTO;

public interface HostDAO{

	// 로그인
	HostDTO login(HostDTO hostDTO) throws SQLException;

	// 아이디 중복체크
	boolean idCheck(String id) throws SQLException;

	// 회원가입
	int insert(HostDTO hostDTO) throws SQLException;

}