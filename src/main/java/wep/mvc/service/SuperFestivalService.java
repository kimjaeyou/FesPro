package wep.mvc.service;

import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;

public interface SuperFestivalService {
	/**
	 * 모든행사 조회
	 */
	public List<FesDTO> selectAll();

	/**
	 * 행사 조회
	 * 
	 * @param isWaitFes 대기테이블에서 조회여부
	 */
	public FesDTO select(FesDTO festivalDto, boolean isWaitFes);

	/**
	 * 행사조회
	 */

	/**
	 * 행사에 등록한 유저 조회
	 */
	public List<UsersDTO> selectUser(FesDTO festivalDto);

	/**
	 * 행사에 등록된 리뷰 조회
	 */
	public List<ReviewDTO> selectReview(FesDTO fes);

	/**
	 * 행사 수정
	 */
	public int update(FesDTO festivalDto, int state);

	/**
	 * 행사 수정
	 */
	public int update(FesDTO festivalDto);

	/**
	 * 행사 리뷰쓴 유저조회
	 */
	public List<UsersDTO> selectReviewUser(FesDTO fes);

	public List<FesDTO> dashFesWaitFesSelectAll();

	/**
	 * 관리자용 모든행사 조회
	 */
	public List<FesDTO> selectAllSuper();

	List<FesDTO> dashFesSelectAll();

	public List<FesDTO> dashFesCancleWaitFesSelectAll();
	
	/**
	 * 행사 승인하면 waitfes에서 삭제
	 */
	public int delete(FesDTO fes);

	/**
	 * 행사 FES에서 삭제
	 */
	public int deleteFes(FesDTO fes);

}
