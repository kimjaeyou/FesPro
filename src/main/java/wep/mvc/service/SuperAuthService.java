package wep.mvc.service;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperAuthService{
	
	public List<UsersDTO> selectAll();

	UsersDTO select(UsersDTO userDto);

	int update(UsersDTO user, int benCheck);

	int update(UsersDTO user);

	public List<HostDTO> hostSelectAll();

	HostDTO hostSelect(HostDTO HostDto);

	public int hostUpdate(HostDTO host);

	public List<FesDTO> sessionLocationAll(int sessionSeq);

	public List<HostDTO> hostWaitSelectAll();

	/*
	 * UsersDTO selectById(String id);
	 * 
	 * int update(UsersDTO user);
	 */

}