package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.FesDAO;
import wep.mvc.dao.FesDAOImpl;
import wep.mvc.dto.FesDTO;

public class FesSereviceImpl implements FesSerevice{
	private FesDAO fesDAO = new FesDAOImpl();
	
	@Override
	public void insert(FesDTO fesDTO) throws SQLException {
		int result = fesDAO.insert(fesDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다");
	}
	/*
	private FesDAO fesDAO = new FesDAOImpl();
	@Override
	public List<FesDTO> selectAll() throws SQLException {
		List<FesDTO> fesDTOList = fesDAO.selectAll();
		return fesDTOList;
	}
	*/

	@Override
	public List<FesDTO> select(int host_seq) throws SQLException {
		List<FesDTO> list = fesDAO.select(host_seq);
		return list;
	}

	@Override
	public FesDTO selectBySVCID(String sVCID) throws SQLException {
		FesDTO fesDTO = fesDAO.selectBySVCID(sVCID);
		if(fesDTO==null) {
			throw new SQLException("상세보기가 없습니다");
		}
		return fesDTO;
	}

	@Override
	public void update(FesDTO fesDTO) throws SQLException {
		if(fesDAO.update(fesDTO)==0) {
			throw new SQLException("수정 실패");
		}
	}
}
