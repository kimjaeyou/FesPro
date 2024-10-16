package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.ReviewDTO2;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.dto.WALLET;
import wep.mvc.util.DbUtil;

public class MypageDAOImpl implements MypageDAO {

	// 예약내역 전체검색
	@Override
	public List<ReservationDTO2> resSelectAll(int seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationDTO2> list = new ArrayList<ReservationDTO2>();
		String sql = "SELECT reserv_seq, svcnm, svc_time, svc_date, resv_date, resv_price, reserv_check FROM fes, reservation WHERE fes.svcid= reservation.svcid and user_seq = ? and reserv_check = 1 order by reserv_seq asc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReservationDTO2 res = new ReservationDTO2(rs.getInt(1), // reservSeq
						rs.getString(2), // 서비스명 넣어줘야해여
						rs.getString(3), // svcDate
						rs.getString(4), // resvDate
						rs.getString(5), rs.getInt(6), // resvPrice
						rs.getInt(7)); // resvCheck

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO2> resSelect(ReservationDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationDTO2> list = new ArrayList<ReservationDTO2>();
		String sql = "select * from reservation where user_seq = ? and 서비스명 = ?;";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setInt(1, dto.getUserSeq());
			// ps.setInt(2, dto.get서비스명());
			while (rs.next()) {
				ReservationDTO2 res = new ReservationDTO2(rs.getInt(1), // reservSeq
						rs.getString(2), // 서비스명 넣어줘야해여
						rs.getString(3), // svcDate
						rs.getString(4), // resvDate
						rs.getString(5), rs.getInt(6), // resvPrice
						rs.getInt(7)); // resvCheck

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 예약내역 삭제
	@Override
	public int resDelete(int reserv_Seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update reservation set reserv_check=0 where reserv_seq=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, reserv_Seq);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 리뷰 전체검색
	@Override
	public List<ReviewDTO2> reviewSelectAll(int seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO2> list = new ArrayList<ReviewDTO2>();
		String sql = "SELECT review_seq, score, svcnm , rv_content, sysdate FROM fes, review\r\n"
				+ "WHERE fes.svcid= review.svcid and user_seq = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewDTO2 res = new ReviewDTO2(rs.getInt(1), // 리뷰시퀀스
						rs.getInt(2), // 별점
						rs.getString(3), // 서비스명
						rs.getString(4), // 내용
						rs.getString(5)); // 작성일자 (sysdate)

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 리뷰 부분검색
	@Override
	public List<ReviewDTO2> reviewSelect(ReviewDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO2> list = new ArrayList<ReviewDTO2>();
		String sql = "select * from review where user_seq=? AND review_seq=?;";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// ps.setInt(1, dto.getUserSeq());
			// ps.setInt(2, dto.get서비스명());
			while (rs.next()) {
				ReviewDTO2 res = new ReviewDTO2(rs.getInt(1), // 리뷰시퀀스
						rs.getInt(2), // 별점
						rs.getString(3), // 서비스명
						rs.getString(4), // 내용
						rs.getString(5)); // 작성일자 (sysdate)

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 리뷰 삭제
	@Override
	public int reviewDelete(int seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from review where review_seq = ?";
		;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, seq);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 즐겨찾기 전체검색
	@Override
	public List<FesDTO> likeSelectAll(int seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();
		String sql = "SELECT  u.svcid , svcnm, placenm, RCPTBGNDT, RCPTENDDT, SVCOPNBGNDT, SVCOPNENDDT, V_MAX, V_MIN, price, SVCSTATNM  FROM fes f , user_like u WHERE f.svcid = u.svcid and u.user_seq = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			while (rs.next()) {
				FesDTO res = new FesDTO(rs.getString(1), // 서비스 아이디
						rs.getString(2), // 서비스명
						rs.getString(3), // 장소명
						rs.getString(4), // 접수 시작 기간
						rs.getString(5), // 접수 시작 기간
						rs.getString(6), // 이용시작기간
						rs.getString(7), //
						rs.getString(8), //
						rs.getString(9), //
						rs.getInt(10), // 이용요금
						rs.getString(11)); // 상태

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 즐겨찾기 부분검색
	@Override
	public List<FesDTO> likeSelect(USER_LIKE dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();
		String sql = ";";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// ps.setInt(1, dto.getUserSeq());
			// ps.setInt(2, dto.get서비스명());
			while (rs.next()) {
				FesDTO res = new FesDTO(rs.getString(1), // 서비스 아이디
						rs.getString(2), // 서비스명
						rs.getString(3), // 장소명
						rs.getString(4), // 접수 시작 기간
						rs.getString(5), // 접수 시작 기간
						rs.getString(6), // 이용시작기간
						rs.getString(7), // 이용기간
						rs.getString(8), // 이용기간
						rs.getString(9), // 이용기간
						rs.getInt(10), // 이용요금
						rs.getString(11)); // 접수상태

				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
		// return list;
	}

	// 즐겨찾기 삭제
	@Override
	public int likeDelete(String seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from user_like where svcid=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, seq);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 이건 먼저 비밀번호 체크 할 곳
	@Override
	public int balanceCheck(int seq, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select count(*) from users where user_seq=? and user_pw =?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 검증이 완료되면 입금을 한다.
	@Override
	public WALLET balancePlus(int amount, int seq) throws SQLException {
		Connection con = null;
		Connection con1 = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		WALLET wallet = null;
		String sql1 = "update wallet set money = money + ? where user_seq=?";
		String sql2 = "select MONEY from wallet where user_seq = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setInt(1, amount);
			ps.setInt(2, seq);

			
			ps.executeUpdate();
			
			
			ps1 = con.prepareStatement(sql2);
			ps1.setInt(1, seq);
			rs = ps1.executeQuery();
			
			
			while (rs.next()) {
				int money = rs.getInt(1);
				wallet = new WALLET();
				wallet.setMONEY(money);
			}
			
		} finally

		{
			DbUtil.dbClose(con, ps);
		}
		return wallet;
	}

}