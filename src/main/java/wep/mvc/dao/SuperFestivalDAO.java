package wep.mvc.dao;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperFestivalDAO {

	/**
	 * 전체 조회 
	 */
	public List<FesDTO> selectAll();
	
	/**
	 * 검색 
	 * @param isWaitFes 대기테이블에서 조회하는지 여부
	 */
	public FesDTO select(FesDTO fes, boolean isWaitFes);
	
	/**
	 * 유저 검색
	 */
	public List<UsersDTO> selectUser(FesDTO fes);

	/**
	 * 수정
	 */
	public int update(FesDTO festivalDto, int state);

	/**
	 * 수정
	 */
	public int update(FesDTO festivalDto);
	
	/**
	 * 리뷰 검색 
	 */
	public List<ReviewDTO> selectReview(FesDTO fes);

	/**
	 * 리뷰쓴 유저 검색
	 */
	public List<UsersDTO> selectReviewUser(FesDTO fes);

	public List<FesDTO> dashFesSelectAll();

	/**
	 * 관리자용 모든행사 조회
	 */
	public List<FesDTO> selectAllSuper();

	public List<FesDTO> dashFesWaitFesSelectAll();

	public List<FesDTO> dashFesCancleWaitFesSelectAll();
	/**
	 * 관리자가 waitfes에서 삭제
	 */
	public int delete(FesDTO fes);

	/**
	 * 관리자가 fes에서 삭제
	 */
	public int deleteFes(FesDTO fes);

	
}
