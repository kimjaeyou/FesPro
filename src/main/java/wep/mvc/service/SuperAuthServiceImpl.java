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
		System.out.println("셀렉트올 서비스");
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = dao.selectAll();
		System.out.println("서비스에서 list = "+list);
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
