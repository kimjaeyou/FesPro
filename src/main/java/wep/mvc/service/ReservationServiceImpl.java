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
	public int insert (ReservationDTO reservation) throws SQLException  {
		int result = dao.insert(reservation);
		
		
		return result;
	}

	@Override
	public ReservationDTO selectByUserSeq(int userSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
