package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.UsersDTO;
import wep.mvc.util.DbUtil;

public class SuperAuthDAOImpl implements SuperAuthDAO {

	public List<UsersDTO> selectAll()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		
		try {
			con=DbUtil.get
		}
	}
}
