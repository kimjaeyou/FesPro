package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dao.HostDAO;
import wep.mvc.dao.HostDAOImpl;
import wep.mvc.dto.HostDTO;

public class HostServiceImpl implements HostService{
	private HostDAO host = new HostDAOImpl();

	@Override
	public HostDTO login(HostDTO hostDTO) throws SQLException {
		HostDTO dto = host.login(hostDTO);
		if(dto == null) { 
			throw new NullPointerException("정보를 다시 확인하세요");
		} 
		return dto;
	}

	// 회원가입
	public int insert(HostDTO hostDTO) throws SQLException {

		return host.insert(hostDTO);
	}

	// 아이디 중복체크
	@Override
	public boolean idCheck(String id) throws SQLException {

		return host.idCheck(id);

	}

}