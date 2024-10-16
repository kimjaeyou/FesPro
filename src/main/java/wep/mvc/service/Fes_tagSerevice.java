package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

public interface Fes_tagSerevice {

	void insert(String sVCID, String tag_content) throws SQLException;

	List<String> selectBySVCID(String sVCID) throws SQLException;

	//void update(String sVCID, String tag_content) throws SQLException;

}