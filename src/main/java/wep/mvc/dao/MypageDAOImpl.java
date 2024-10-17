package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.ReviewDTO2;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.dto.UsersDTO;
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

		String sql = "SELECT reserv_seq, svcnm, svc_time, svc_date, resv_date, resv_price, reserv_check,fes.SVCID FROM fes, reservation WHERE fes.svcid= reservation.svcid and user_seq = ? and reserv_check = 1 order by reserv_seq asc";

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
						rs.getInt(7), // resvCheck
						rs.getString(8)); // resvCheck
				list.add(res);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 회원탈퇴
	@Override
	public int delete(String id) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update users set user_ben_check = 0 where user_id = ?");
			ps.setString(1, id);
			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 회원수정
	@Override
	public int update(UsersDTO usersDTO) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"update users	set user_pw=?, age=?, addr=?, gender=?, email=?, user_name=?, disable=?, user_tel=? where user_id=?");

			ps.setString(1, usersDTO.getUser_pw());
			ps.setInt(2, usersDTO.getAge());
			ps.setString(3, usersDTO.getAddr());
			ps.setString(4, usersDTO.getGender());
			ps.setString(5, usersDTO.getEmail());
			ps.setString(6, usersDTO.getUser_name());
			ps.setString(7, usersDTO.getDisable());
			ps.setString(8, usersDTO.getUser_tel());
			ps.setString(9, usersDTO.getUser_id());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	// 회원수정 할때 데이터 넣기위해 DB 자료 꺼내기
	@Override
	public UsersDTO selectUser(String usersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO dbDTO = null;
		String sql = "select * from users where user_id=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usersDTO);
			rs = ps.executeQuery();

			if (rs.next()) {
				dbDTO = new UsersDTO(rs.getInt("user_seq"), rs.getString("user_id"), rs.getString("user_pw"),
						rs.getInt("age"), rs.getString("addr"), rs.getString("gender"), rs.getString("email"),
						rs.getString("user_name"), rs.getString("disable"), rs.getString("user_tel"));

			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO2> resSelect(int seq, String svcnm) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReservationDTO2> list = new ArrayList<ReservationDTO2>();
		String sql = "SELECT reserv_seq, svcnm, svc_time, svc_date, resv_date, resv_price, reserv_check FROM fes, reservation WHERE fes.svcid = reservation.svcid and user_seq = ? and reserv_check = 1 and svcnm like ? order by reserv_seq asc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			ps.setString(2, "%" + svcnm + "%");
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
	public List<ReviewDTO2> reviewSelect(int seq, String svcnm) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO2> list = new ArrayList<ReviewDTO2>();
		String sql = "SELECT review_seq, score, svcnm , rv_content, sysdate FROM fes, review\r\n"
				+ "WHERE fes.svcid= review.svcid and user_seq = ? and svcnm like ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			ps.setString(2, "%" + svcnm + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewDTO2 res = new ReviewDTO2(rs.getInt(1), // reservSeq
						rs.getInt(2), // 서비스명 넣어줘야해여
						rs.getString(3), // svcDate
						rs.getString(4), // resvDate
						rs.getString(5));

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
	public List<FesDTO> likeSelect(int seq, String svcnm) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();
		String sql = "SELECT  u.svcid , svcnm, placenm, RCPTBGNDT, RCPTENDDT, SVCOPNBGNDT, SVCOPNENDDT, V_MAX, V_MIN, price, SVCSTATNM  FROM fes f , user_like u WHERE f.svcid = u.svcid and u.user_seq = ? and svcnm like ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			ps.setString(2, "%" + svcnm + "%");
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

	@Override
	public WALLET balanceSelect(int seq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		WALLET wallet = null;
		String sql = "select MONEY from wallet where user_seq = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();

			while (rs.next()) {
				int money = rs.getInt(1);
				wallet = new WALLET();
				wallet.setMONEY(money);
			}

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return wallet;
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

		} finally {
			DbUtil.dbClose(con, ps);
		}
		return wallet;
	}
	
	public boolean checkReview(int reSeq, int seq) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM REVIEW WHERE REVIEW_SEQ = ? AND USER_SEQ = ?";
	    boolean reviewExists = false; // 리뷰 존재 여부를 저장할 변수

	    try {
	        // DB 연결
	        con = DbUtil.getConnection();
	        // 쿼리 준비
	        ps = con.prepareStatement(sql);
	        // 쿼리 파라미터 설정
	        ps.setInt(1, reSeq); // 예약 시퀀스
	        ps.setInt(2, seq);   // 사용자 시퀀스
	        // 쿼리 실행
	        rs = ps.executeQuery();

	        // 결과가 있으면 리뷰가 존재하는 것
	        if (rs.next()) {
	            reviewExists = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        // 리소스 해제
	        DbUtil.dbClose(con, ps, rs);
	    }

	    // 리뷰 존재 여부 반환
	    return reviewExists;
	}
	

}