package wep.mvc.service;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperFestivalService{
	/**
	 * 모든행사 조회
	 */
	public List<FesDTO> selectAll();
	
	/**
	 * 행사 조회
	 */
	public FesDTO select(FesDTO festivalDto);
	
	/**
	 * 	행사에 등록한 유저 조회
	 */
	public List<UsersDTO> selectUser(FesDTO festivalDto);
	
	/**
	 * 행사 수정
	 */
	public int update(FesDTO festivalDto, int state);
	
	/**
	 * 행사 
	 */
}
