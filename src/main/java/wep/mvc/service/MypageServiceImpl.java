package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MypageDAO;
import wep.mvc.dao.MypageDAOImpl;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;

public class MypageServiceImpl implements MypageService {
	private MypageDAO md = new MypageDAOImpl();

	// 예약내역 전체검색
	@Override
	public List<ReservationDTO2> resSelectAll(int seq) throws SQLException {
		return md.resSelectAll(seq);
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO2> resSelect(ReservationDTO dto) throws SQLException {
		return md.resSelect(dto);
	}

	@Override
	public void resDelete(ReservationDTO dto) throws SQLException {
	}

	@Override
	public List<ReviewDTO> reviewSelectAll(int seq) throws SQLException {
		return md.reviewSelectAll(seq);
	}

	@Override
	public List<ReviewDTO> reviewSelect(ReviewDTO dto) throws SQLException {
		return md.reviewSelect(dto);
	}

	@Override
	public void reviewDelete(ReviewDTO dto) throws SQLException {
	}

	@Override
	public List<USER_LIKE> likeSelectAll(int seq) throws SQLException {
		return md.likeSelectAll(seq);
	}

	@Override
	public List<USER_LIKE> likeSelect(USER_LIKE dto) throws SQLException {
		return md.likeSelect(dto);
	}

	@Override
	public void likeDelete(USER_LIKE dto) throws SQLException {
	}

}