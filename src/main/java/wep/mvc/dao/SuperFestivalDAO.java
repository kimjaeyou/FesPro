package wep.mvc.dao;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperFestivalDAO {

	/**
	 * 전체 조회 
	 */
	public List<FesDTO> selectAll();
	
	/**
	 * 검색 
	 */
	public FesDTO select(FesDTO fes);
	
	/**
	 * 유저 검색
	 */
	public List<UsersDTO> selectUser(FesDTO fes);

	/**
	 * 수정
	 */
	public int update(FesDTO festivalDto, int state);
}
