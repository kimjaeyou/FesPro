package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dto.ReservationDTO;

public interface ReservationService {
	
	/**
	 * ReservationDAOImpl insert 메소드 호출
	 */
	public int insert (ReservationDTO reservation) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectByUserSeq 메소드 호출
	 */
	public ReservationDTO selectByUserSeq (int userSeq);
}
