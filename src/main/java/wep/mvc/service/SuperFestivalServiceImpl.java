package wep.mvc.service;

import java.util.List;

import wep.mvc.dao.SuperFestivalDAO;
import wep.mvc.dao.SuperFestivalDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;

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
		FesDTO result = null;
		
		result =dao.select(festivalDto);
				
		return result;
	}

	@Override
	public int update(FesDTO festivalDto,int state) {
		int result=0;
		
		result = dao.update(festivalDto, state);
		
		return result;
	}

	@Override
	public List<UsersDTO> selectUser(FesDTO festivalDto) {
		List<UsersDTO> result = null;
		
		result =dao.selectUser(festivalDto);
		
		return result;
	}

	@Override
	public List<ReviewDTO> selectReview(FesDTO fes) {
		List<ReviewDTO> result = null;
		
		result = dao.selectReview(fes);
		
		return result;
	}

}
