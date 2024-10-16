package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.ReviewDTO2;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.dto.WALLET;

public interface MypageDAO {
	// 예약내역 전체검색
	List<ReservationDTO2> resSelectAll(int seq) throws SQLException;

	// 예약내역 부분검색
	List<ReservationDTO2> resSelect(int seq, String svcnm) throws SQLException;

	// 예약내역 삭제
	int resDelete(int reserv_Seq) throws SQLException;

	// 리뷰 전체검색
	List<ReviewDTO2> reviewSelectAll(int seq) throws SQLException;

	// 리뷰 부분검색
	List<ReviewDTO2> reviewSelect(int seq , String svcnm) throws SQLException;

	// 리뷰 삭제
	int reviewDelete(int seq) throws SQLException;

	// 즐겨찾기 전체검색
	List<FesDTO> likeSelectAll(int seq) throws SQLException;

	// 즐겨찾기 부분검색
	List<FesDTO> likeSelect(int seq, String svcnm) throws SQLException;

	// 즐겨찾기 삭제
	int likeDelete(String seq) throws SQLException;

	// 신원 확인
	int balanceCheck(int seq, String password) throws SQLException;

	// 잔액 충전
	WALLET balancePlus(int amount, int seq) throws SQLException;

	// 잔액 조회
	WALLET balanceSelect(int seq)throws SQLException;
}