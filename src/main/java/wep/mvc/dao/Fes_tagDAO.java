package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FES_TAG;

public interface Fes_tagDAO {
	int insert(String sVCID, String tag_content) throws SQLException;

	List<String> selectBySVCID(String sVCID) throws SQLException;

	//int update(String sVCID, String tag_content) throws SQLException;
}

