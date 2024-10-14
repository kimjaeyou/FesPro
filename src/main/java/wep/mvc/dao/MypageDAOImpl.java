package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;

public class MypageDAOImpl implements MypageDAO {
	/**
	 * 예약 내역 조회
	select 예약번호, 서비스명, 이용날짜, 신청일, 이용요금, 예약현황 from fes where svcid = 
	(select svcid from reservation where user_seq=?);

	예약 내역 삭제
	delete from reservation where user_seq=? and reserv_seq=?;

	리뷰 검색
	select 리뷰번호 , 점수 , 서비스명 , 작성일자, 내용 from review where user_seq=?;

	리뷰 삭제
	delete from review where user_seq = ? and review_seq;

	즐겨찾기 검색
	select 서비스명, 장소명, 기간, 요금, 접수상태, 신청방법, 예약방법 from fes
	where svcid = (select svcid from like where user_seq = ?);

	즐겨찾기 삭제
	delete from review where user_seq = ? and like_seq = ?;
	 */
	// 예약내역 전체검색
	@Override
	public List<ReservationDTO> resSelectAll(int seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReservationDTO> list = new ArrayList<ReservationDTO>();
		String sql= "select 예약번호, 서비스명, 이용날짜, 신청일, 이용요금, 예약현황 from fes where svcid = \r\n"
				+ "	(select svcid from reservation where user_seq=?);";
		try {
			con = wep.mvc.util.DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				/*ReservationDTO res = new ReservationDTO(
						rs.getString(1), 
						rs.getString(2), 
						rs.getInt(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getString(8), 
						rs.getInt(9));
				
			   list.add(electonics);*/
			}
		}finally {
			wep.mvc.util.DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO> resSelect(int seq) throws SQLException {
		return null;
	}

	// 예약내역 삭제
	@Override
	public void resDelete() throws SQLException {
	}
	
	// 리뷰 전체검색
	@Override
	public ReviewDTO reviewSelectAll() throws SQLException {
		return null;
	}
	
	// 리뷰 부분검색
	@Override
	public ReviewDTO reviewSelect() throws SQLException {
		return null;
	}
	
	// 리뷰 삭제
	@Override
	public void reviewDelete() throws SQLException {
	}
	
	// 즐겨찾기 전체검색
	@Override
	public USER_LIKE likeSelectAll() throws SQLException {
		return null;
	}
	
	// 즐겨찾기 부분검색
	@Override
	public USER_LIKE likeSelect() throws SQLException {
		return null;
	}
	
	// 즐겨찾기 삭제
	@Override
	public void likeDelete() throws SQLException {
	}
}