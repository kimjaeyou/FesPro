package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MypageDAO;
import wep.mvc.dao.MypageDAOImpl;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;

public class MypageServiceImpl implements MypageService {
	private MypageDAO md = new MypageDAOImpl();

	// 예약내역 전체검색
	@Override
	public List<ReservationDTO> resSelectAll(int seq) throws SQLException {
		return md.resSelectAll(seq);
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO> resSelect(int seq) throws SQLException {
		return md.resSelect(seq);
	}

	// 예약내역 삭제
	@Override
	public void resDelete() throws SQLException {
	}
	
	// 리뷰 전체검색
	@Override
	public ReviewDTO reviewSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 리뷰 부분검색
	@Override
	public ReviewDTO reviewSelect() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 리뷰 삭제
	@Override
	public void reviewDelete() throws SQLException {
		// TODO Auto-generated method stub

	}
	
	// 즐겨찾기 전체검색
	@Override
	public USER_LIKE likeSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 즐겨찾기 부분검색
	@Override
	public USER_LIKE likeSelect() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 즐겨찾기 삭제
	@Override
	public void likeDelete() throws SQLException {
		// TODO Auto-generated method stub

	}
}