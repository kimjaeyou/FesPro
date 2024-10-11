package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperAuthDAO;
import wep.mvc.dao.SuperAuthDAOImpl;
import wep.mvc.dto.UsersDTO;

public interface SuperAuthService{
	
	public List<UsersDTO> selectAll();

}
