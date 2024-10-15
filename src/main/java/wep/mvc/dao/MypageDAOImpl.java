package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.ReservationDTO2;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.USER_LIKE;
import wep.mvc.util.DbUtil;

public class MypageDAOImpl implements MypageDAO {
	/**
	예약 내역 삭제
	delete from reservation where user_seq=? and reserv_seq=?;

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
	public List<ReservationDTO2> resSelectAll(int seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReservationDTO2> list = new ArrayList<ReservationDTO2>();
		String sql= "SELECT reserv_seq, svcnm, svc_time, svc_date, resv_date, resv_price, reserv_check FROM fes, reservation"
			    +" WHERE fes.svcid= reservation.svcid and user_seq = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,seq);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationDTO2 res = new ReservationDTO2(
						rs.getInt(1), //reservSeq
						rs.getString(2), // 서비스명 넣어줘야해여
						rs.getString(3), //svcDate
						rs.getString(4), //resvDate
						rs.getString(5),
						rs.getInt(6),  //resvPrice
						rs.getInt(7)); // resvCheck
				
			   list.add(res);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 예약내역 부분검색
	@Override
	public List<ReservationDTO2> resSelect(ReservationDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReservationDTO2> list = new ArrayList<ReservationDTO2>();
		String sql= "select * from reservation where user_seq = ? and 서비스명 = ?;";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setInt(1, dto.getUserSeq());
			//ps.setInt(2, dto.get서비스명());
			while(rs.next()) {
				ReservationDTO2 res = new ReservationDTO2(
						rs.getInt(1), //reservSeq
						rs.getString(2), // 서비스명 넣어줘야해여
						rs.getString(3), //svcDate
						rs.getString(4), //resvDate
						rs.getString(5),
						rs.getInt(6),  //resvPrice
						rs.getInt(7)); // resvCheck
				
			   list.add(res);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	// 예약내역 삭제
	@Override
	public void resDelete(ReservationDTO dto) throws SQLException {
	}
	
	// 리뷰 전체검색
	@Override
	public List<ReviewDTO> reviewSelectAll(int seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql= "select * from review where user_seq=?;";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,seq);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO res = new ReviewDTO(
						rs.getInt(1), // 리뷰시퀀스
						rs.getInt(2), // 별점
						rs.getString(3), // 서비스명
						rs.getString(4), // 내용
						rs.getInt(5));  // 작성일자 (sysdate)
				
			   list.add(res);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	// 리뷰 부분검색
	@Override
	public List<ReviewDTO> reviewSelect(ReviewDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql= "select * from review where user_seq=? AND review_seq=?;";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//ps.setInt(1, dto.getUserSeq());
			//ps.setInt(2, dto.get서비스명());
			while(rs.next()) {
				ReviewDTO res = new ReviewDTO(
						rs.getInt(1), // 리뷰시퀀스
						rs.getInt(2), // 별점
						rs.getString(3), // 서비스명
						rs.getString(4), // 내용
						rs.getInt(5));  // 작성일자 (sysdate)
				
			   list.add(res);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	// 리뷰 삭제
	@Override
	public void reviewDelete(ReviewDTO dto) throws SQLException {
	}
	
	// 즐겨찾기 전체검색
	@Override
	public List<USER_LIKE> likeSelectAll(int seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<USER_LIKE> list = new ArrayList<USER_LIKE>();
		String sql= ";";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,seq);
			rs = ps.executeQuery();
			while(rs.next()) {
				/*USER_LIKE res = new USER_LIKE(
						rs.getInt(1), // 리뷰시퀀스
						rs.getString(2), //  
						rs.getString(3), //
						rs.getString(4), //
						rs.getInt(5),  //
						rs.getInt(6)); // 
				
			   list.add(res);
			*/}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	// 즐겨찾기 부분검색
	@Override
	public List<USER_LIKE> likeSelect(USER_LIKE dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReservationDTO> list = new ArrayList<ReservationDTO>();
		String sql= ";";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//ps.setInt(1, dto.getUserSeq());
			//ps.setInt(2, dto.get서비스명());
			while(rs.next()) {/*
				USER_LIKE res = new USER_LIKE(
						rs.getInt(1), //reservSeq
						rs.getString(2), // 서비스명 넣어줘야해여
						rs.getString(3), //svcDate
						rs.getString(4), //resvDate
						rs.getInt(5),  //resvPrice
						rs.getInt(6)); // resvCheck
				
			   list.add(res);
			*/}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
		//return list;
	}
	
	// 즐겨찾기 삭제
	@Override
	public void likeDelete(USER_LIKE dto) throws SQLException {
	}
}