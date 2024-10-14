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
	public ReservationDTO selectByUserSeq (int userSeq) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectByResvSeq 메소드 호출
	 */
	public ReservationDTO selectByResvSeq (int resvSeq) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectBySVCID 메소드 호출
	 */
	public ReservationDTO selectBySVCID (String SVCID) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectByUserSeqAndSVCID 메소드 호출
	 */
	public ReservationDTO selectByUserSeqAndSVCID (int userSeq, String SVCID) throws SQLException;
}
