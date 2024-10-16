package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.Fes_tagDAO;
import wep.mvc.dao.Fes_tagDAOImpl;

public class Fes_tagSereviceImpl implements Fes_tagSerevice {
	private Fes_tagDAO fes_tagDAO = new Fes_tagDAOImpl();
	@Override
	public void insert(String sVCID, String tag_content) throws SQLException {
		int result=fes_tagDAO.insert(sVCID, tag_content);
		if(result==0) throw new SQLException("태그가 등록되지 않았습니다");
	}
	@Override
	public List<String> selectBySVCID(String sVCID) throws SQLException {
		List<String> fes_tag = fes_tagDAO.selectBySVCID(sVCID);
		return fes_tag;
	}
	

}