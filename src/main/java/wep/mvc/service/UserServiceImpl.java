package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dao.UsersDAO;
import wep.mvc.dao.UsersDAOImpl;
import wep.mvc.dto.UsersDTO;

public class UserServiceImpl implements UserService {
	private UsersDAO user = new UsersDAOImpl();

	// 로그인
	@Override
	public UsersDTO login(UsersDTO usersDTO) throws SQLException {
		UsersDTO dto = user.login(usersDTO);
		return dto;
	}

	// 회원가입
	public int insert(UsersDTO usersDTO) throws SQLException {

		return user.insert(usersDTO);
	}

	// 아이디 중복체크
	@Override
	public boolean idCheck(String id) throws SQLException {
		boolean result = user.idCheck(id);
		return result;

	}

}
