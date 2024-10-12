package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperFestivalDAO;
import wep.mvc.dao.SuperFestivalDAOImpl;
import wep.mvc.dto.FesDTO;

public class SuperFestivalServiceImpl implements SuperFestivalService {
	SuperFestivalDAO dao = new SuperFestivalDAOImpl();
	
	@Override
	public List<FesDTO> selectAll() {
		List<FesDTO> result=null;
		
		result = dao.selectAll();
		
		return result;
	}

	@Override
	public FesDTO select(FesDTO festivalDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
