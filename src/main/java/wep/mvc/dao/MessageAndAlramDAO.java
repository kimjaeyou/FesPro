package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.MESSAGE;

public interface MessageAndAlramDAO {

	List<MESSAGE> select(int uSeq) throws SQLException;

}
