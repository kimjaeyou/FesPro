package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WALLET;

public interface ReservationDAO {
	
	/**
	 * 레코드 삽입
	 */
	int insert (ReservationDTO reservation) throws SQLException;
	
	/**
	 * 유저 seq를 이용해 예약정보 검색
	 */
	ReservationDTO selectByUserSeq (int userSeq) throws SQLException;
	
	/**
	 * 예약 seq를 이용해 예약정보 검색
	 */
	ReservationDTO selectByResvSeq (int resvSeq) throws SQLException;
	
	/**
	 * SVCID를 이용해 예약정보 검색
	 */
	ReservationDTO selectBySVCIDRes (String SVCID) throws SQLException;
	
	/**
	 * SVCID를 이용해 예약정보 검색 (Fes 리턴)
	 */
	FesDTO selectBySVCIDFes (String SVCID) throws SQLException;
	
	/**
	 * 유저 seq와 svcid를 이용해 예약정보 검색
	 */
	ReservationDTO selectByUserSeqAndSVCID (int userSeq, String SVCID) throws SQLException;
	
	/**
	 * svcid로 행사정보 검색
	 */
	FesDTO selectFes (String SVCID) throws SQLException;
	
	/**
	 * userSeq로 유저정보 검색
	 */
	UsersDTO selectUser (int userSeq) throws SQLException;
	
	/**
	 * 결제금액만큼 wallet에서 차감
	 */
	WALLET payment(int userSeq, int fee) throws SQLException;

	
	/**
	 * 예약 상태 변경 : 결제대기 - 예약완료
	 */
	int changeReservation (int resvSeq) throws SQLException;
	
	/**
	 * 예약된 회차 인원 수 가져오기
	 */
	List<Integer> getReservNum (String svcId, String date) throws SQLException;

}