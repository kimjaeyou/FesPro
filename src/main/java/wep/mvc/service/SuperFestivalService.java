package wep.mvc.service;

import java.util.List;

import wep.mvc.dto.FesDTO;

public interface SuperFestivalService{
	/**
	 * 모든행사 조회
	 */
	public List<FesDTO> selectAll();

}
