package wep.mvc.dao;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperAuthDAO {

	List<UsersDTO> selectAll();

	UsersDTO select(UsersDTO userDto);

	int update(UsersDTO user, int benCheck);
	
	int update(UsersDTO user);

	List<HostDTO> hostSelectAll();

	HostDTO hostSelect(HostDTO hostDto);

	int hostUpdate(HostDTO host);

	List<FesDTO> sessionLocationAll(int sessionSeq);

	List<HostDTO> hostWaitSelectAll();

	/*
	 * UsersDTO selectById(String id);
	 * 
	 * int update(UsersDTO user);
	 */

}