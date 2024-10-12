package wep.mvc.dao;

import java.util.List;

import wep.mvc.dto.UsersDTO;

public interface SuperAuthDAO {

	List<UsersDTO> selectAll();

	/*
	 * UsersDTO selectById(String id);
	 * 
	 * int update(UsersDTO user);
	 */

}
