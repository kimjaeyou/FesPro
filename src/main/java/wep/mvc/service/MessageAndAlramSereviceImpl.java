package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MessageAndAelramDAOImpl;
import wep.mvc.dao.MessageAndAlramDAO;
import wep.mvc.dto.MESSAGE;

public class MessageAndAlramSereviceImpl implements MessageAndAlramSerevice{
	private MessageAndAlramDAO mDAO = new MessageAndAelramDAOImpl();
	@Override
	public List<MESSAGE> select(int uSeq) throws SQLException {
		List<MESSAGE> list = mDAO.select(uSeq);
		return list;
	}

}
