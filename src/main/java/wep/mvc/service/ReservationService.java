package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;

public interface ReservationService {
	
	/**
	 * ReservationDAOImpl insert 메소드 호출
	 */
	public int insert (ReservationDTO reservation) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectByUserSeq 메소드 호출
	 */
	public ReservationDTO selectByUserSeq (int userSeq);
	
	/**
	 * ReservationDAOImpl selectByResvSeq 메소드 호출
	 */
	public ReservationDTO selectByResvSeq (int resvSeq) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectBySVCID 메소드 호출
	 */
	public ReservationDTO selectBySVCIDRes (String SVCID) throws SQLException;
	
	/**
	 * 
	 */
	public FesDTO selectBySVCIDFes (String SVCID) throws SQLException;
	
	/**
	 * ReservationDAOImpl selectByUserSeqAndSVCID 메소드 호출
	 */
	public ReservationDTO selectByUserSeqAndSVCID (int userSeq, String SVCID) throws SQLException;
	
	/**
	 * SVCID로 행사정보 가져오는 selectFes 메소드 호출
	 */
	public FesDTO selectFes(String SVCID) throws SQLException;
	
	/**
	 * userSeq로 유저정보 가져오는 selectUser 메소드 호출
	 */
	public UsersDTO selectUser(int userSeq) throws SQLException;

}