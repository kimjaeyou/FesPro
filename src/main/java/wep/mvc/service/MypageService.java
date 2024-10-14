package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;

public interface MypageService {

	// 예약내역 전체검색
	List<ReservationDTO> resSelectAll(int seq) throws SQLException;

	// 예약내역 부분검색
	List<ReservationDTO> resSelect(int seq) throws SQLException;

	// 예약내역 삭제
	void resDelete() throws SQLException;

	// 리뷰 전체검색
	ReviewDTO reviewSelectAll() throws SQLException;

	// 리뷰 부분검색
	ReviewDTO reviewSelect() throws SQLException;

	// 리뷰 삭제
	void reviewDelete() throws SQLException;

	// 즐겨찾기 전체검색
	USER_LIKE likeSelectAll() throws SQLException;

	// 즐겨찾기 부분검색
	USER_LIKE likeSelect() throws SQLException;

	// 즐겨찾기 삭제
	void likeDelete() throws SQLException;

}
