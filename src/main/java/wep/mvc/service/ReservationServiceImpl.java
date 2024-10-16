package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dao.ReservationDAO;
import wep.mvc.dao.ReservationDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WALLET;

public class ReservationServiceImpl implements ReservationService {
	ReservationDAO dao = new ReservationDAOImpl();
	
	/**
	 * 예약 등록
	 */
	public int insert (ReservationDTO reservation) throws SQLException {
		int result = dao.insert(reservation);
		return result;
	}

	@Override
	public ReservationDTO selectByUserSeq(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDTO selectByResvSeq(int resvSeq) throws SQLException {
		ReservationDTO resvDTO = dao.selectByResvSeq(resvSeq);
		return resvDTO;
	}

	@Override
	public ReservationDTO selectBySVCIDRes (String SVCID) throws SQLException {
		ReservationDTO resvDTO = dao.selectBySVCIDRes(SVCID);
		return resvDTO;
	}
	
	@Override
	public FesDTO selectBySVCIDFes(String SVCID) throws SQLException {
		FesDTO fesDTo = dao.selectBySVCIDFes(SVCID);
		return fesDTo;
	}

	@Override
	public ReservationDTO selectByUserSeqAndSVCID(int userSeq, String SVCID) throws SQLException {
		ReservationDTO resvDTO = dao.selectByUserSeqAndSVCID(userSeq, SVCID); 
		return resvDTO;
	}

	@Override
	public FesDTO selectFes(String SVCID) throws SQLException {
		FesDTO fesDTO = dao.selectFes(SVCID);
		return fesDTO;
	}
	
	@Override
	public UsersDTO selectUser(int userSeq) throws SQLException {
		UsersDTO userDTO = dao.selectUser(userSeq);
		return userDTO;
	}

	@Override
	public WALLET payment(int userSeq, int fee) throws SQLException {
		WALLET wallet = dao.payment(userSeq, fee);
		return wallet;
	}

	@Override
	public int changeReservation(int resvSeq) throws SQLException {
		int result = dao.changeReservation(resvSeq);
		return result;
	}
	
}

