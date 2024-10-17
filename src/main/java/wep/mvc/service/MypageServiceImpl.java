package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MypageDAO;
import wep.mvc.dao.MypageDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.ReviewDTO2;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.dto.UsersDTO;

public class MypageServiceImpl implements MypageService {
	private MypageDAO md = new MypageDAOImpl();

	// 예약내역 전체검색
	@Override
	public List<ReservationDTO2> resSelectAll(int seq) throws SQLException {
		return md.resSelectAll(seq);
	}

	// 회원탈퇴
	@Override
	public int delete(String id) throws SQLException {

		return md.delete(id);
	}

	// 회원수정
	@Override
	public int update(UsersDTO usersDTO) throws SQLException {

		return md.update(usersDTO);
	}

	@Override
	public UsersDTO selectUser(String usersDTO) throws SQLException {

		return md.selectUser(usersDTO);
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO2> resSelect(int seq, String svcnm) throws SQLException {
		return md.resSelect(seq, svcnm);
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
	public List<ReviewDTO2> reviewSelect(int seq, String svcnm) throws SQLException {
		return md.reviewSelect(seq, svcnm);
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
	public List<FesDTO> likeSelect(int seq, String svcnm) throws SQLException {
		return md.likeSelect(seq, svcnm);
	}

	@Override
	public int likeDelete(String seq) throws SQLException {
		return md.likeDelete(seq);
	}

	@Override
	public int balanceCheck(int seq, String password) throws SQLException {
		return md.balanceCheck(seq, password);
	}

}