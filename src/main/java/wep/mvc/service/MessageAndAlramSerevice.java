package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.MESSAGE;

public interface MessageAndAlramSerevice{

	public List<MESSAGE> select(int uSeq) throws SQLException;

	

}
