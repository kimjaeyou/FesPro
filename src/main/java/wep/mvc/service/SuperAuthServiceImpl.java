package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperAuthDAO;
import wep.mvc.dao.SuperAuthDAOImpl;
import wep.mvc.dto.UsersDTO;

public class SuperAuthServiceImpl implements SuperAuthService {
	
	SuperAuthDAO dao = new SuperAuthDAOImpl();
	@Override
	public List<UsersDTO> selectAll() {
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = dao.selectAll();
		return list;
	}

}
