package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MypageDAO;
import wep.mvc.dao.MypageDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.ReviewDTO2;
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
	public int resDelete(int reserv_Seq) throws SQLException {
		return md.resDelete(reserv_Seq);
	}

	@Override
	public List<ReviewDTO2> reviewSelectAll(int seq) throws SQLException {
		return md.reviewSelectAll(seq);
	}

	@Override
	public List<ReviewDTO2> reviewSelect(ReviewDTO dto) throws SQLException {
		return md.reviewSelect(dto);
	}

	@Override
	public int reviewDelete(int seq) throws SQLException {
		return md.reviewDelete(seq);
	}

	@Override
	public List<FesDTO> likeSelectAll(int seq) throws SQLException {
		return md.likeSelectAll(seq);
	}

	@Override
	public List<FesDTO> likeSelect(USER_LIKE dto) throws SQLException {
		return md.likeSelect(dto);
	}

	@Override
	public int likeDelete(String seq) throws SQLException {
		return md.likeDelete(seq);
	}

}