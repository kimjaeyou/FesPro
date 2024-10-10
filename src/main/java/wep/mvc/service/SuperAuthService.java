package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperAuthDAO;
import wep.mvc.dao.SuperAuthDAOImpl;
import wep.mvc.dto.UsersDTO;

public class SuperAuthService{
	SuperAuthDAO dao = new SuperAuthDAOImpl();
	
	public List<UsersDTO> selectAll()
	{
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = dao.selectAll();
		
	}

}
