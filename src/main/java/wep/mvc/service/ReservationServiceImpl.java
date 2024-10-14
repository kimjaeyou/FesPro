package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dao.ReservationDAO;
import wep.mvc.dao.ReservationDAOImpl;
import wep.mvc.dto.ReservationDTO;

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
	public ReservationDTO selectByUserSeq(int userSeq) throws SQLException {
		ReservationDTO resvDTO = dao.selectByUserSeq(userSeq);
		return resvDTO;
	}

	@Override
	public ReservationDTO selectByResvSeq(int resvSeq) throws SQLException {
		ReservationDTO resvDTO = dao.selectByResvSeq(resvSeq);
		return resvDTO;
	}

	@Override
	public ReservationDTO selectBySVCID(String SVCID) throws SQLException {
		ReservationDTO resvDTO = dao.selectBySVCID(SVCID);
		return resvDTO;
	}

	@Override
	public ReservationDTO selectByUserSeqAndSVCID(int userSeq, String SVCID) throws SQLException {
		ReservationDTO resvDTO = dao.selectByUserSeqAndSVCID(userSeq, SVCID); 
		return resvDTO;
	}
	
	

}
