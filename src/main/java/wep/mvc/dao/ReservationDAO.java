package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;

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

}
