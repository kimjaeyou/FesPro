package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.ReservationDTO;

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
}
