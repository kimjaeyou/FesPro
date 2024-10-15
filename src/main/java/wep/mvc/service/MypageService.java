package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;

public interface MypageService {

	// 예약내역 전체검색
	List<ReservationDTO2> resSelectAll(int seq) throws SQLException;

	// 예약내역 부분검색
	List<ReservationDTO2> resSelect(ReservationDTO dto) throws SQLException;

	// 예약내역 삭제
	void resDelete(ReservationDTO dto) throws SQLException;

	// 리뷰 전체검색
	List<ReviewDTO> reviewSelectAll(int seq) throws SQLException;

	// 리뷰 부분검색
	List<ReviewDTO> reviewSelect(ReviewDTO dto) throws SQLException;

	// 리뷰 삭제
	void reviewDelete(ReviewDTO dto) throws SQLException;

	// 즐겨찾기 전체검색
	List<USER_LIKE> likeSelectAll(int seq) throws SQLException;

	// 즐겨찾기 부분검색
	List<USER_LIKE> likeSelect(USER_LIKE dto) throws SQLException;

	// 즐겨찾기 삭제
	void likeDelete(USER_LIKE dto) throws SQLException;

}
