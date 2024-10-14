package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperAuthDAO;
import wep.mvc.dao.SuperAuthDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;

public class SuperAuthServiceImpl implements SuperAuthService {
	
	SuperAuthDAO dao = new SuperAuthDAOImpl();
	@Override
	public List<UsersDTO> selectAll() {
		System.out.println("셀렉트올 서비스");
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = dao.selectAll();
		System.out.println("서비스에서 list = "+list);
		return list;
		
	}
	
	@Override
	public UsersDTO select(UsersDTO userDto) {
		UsersDTO result = null;
		
		result =dao.select(userDto);
				
		return result;
	}
	
	@Override
	public int update(UsersDTO user) {
		System.out.println("업데이트 서비스");
		int result=0;
		
		result = dao.update(user);
		
		return result;
	}

	@Override
	public int update(UsersDTO user, int benCheck) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HostDTO> hostSelectAll() {
		System.out.println("셀렉트올 서비스");
		List<HostDTO> list = new ArrayList<HostDTO>();
		list = dao.hostSelectAll();
		System.out.println("서비스에서 list = "+list);
		return list;
	}
	
	@Override
	public HostDTO hostSelect(HostDTO HostDto) {
		HostDTO result = null;
		
		result =dao.hostSelect(HostDto);
				
		return result;
	}
	
	@Override
	public int hostUpdate(HostDTO host) {
		System.out.println("업데이트 서비스");
		int result=0;
		
		result = dao.hostUpdate(host);
		
		return result;
	}

	@Override
	public List<FesDTO> sessionLocationAll(int sessionSeq) {
		System.out.println("Fes로케이션 서비스");
		List<FesDTO> list = new ArrayList<FesDTO>();
		list = dao.sessionLocationAll(sessionSeq);
		System.out.println("Fes로케이션 서비스 list = "+list);
		return list;
	
	}
	
	/*
	 * @Override public UsersDTO selectById(String id) { UsersDTO user = new
	 * UsersDTO(); user = dao.selectById(id); return user; }
	 * 
	 * @Override public int update(UsersDTO user) { UsersDTO userdto = new
	 * UsersDTO(); int result = dao.update(user); return result; }
	 */

}
