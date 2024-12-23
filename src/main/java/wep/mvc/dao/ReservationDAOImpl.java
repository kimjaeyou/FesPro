package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReservationDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WALLET;
import wep.mvc.util.DbUtil;

public class ReservationDAOImpl implements ReservationDAO {

	@Override
	public int insert(ReservationDTO reservation) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		int result = 0;
		int reservPeo = 0;
		
		int num = 0;
		
		
		
		String sql= "insert into RESERVATION values(RESERV_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		// insert into RESERVATION values(RESERV_SEQ.NEXTVAL(), ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			num = this.getReservNumForInsert (reservation, con); 
			
			
			
			System.out.println("getReservNumForInsert 호출합니다~~~");
			
			
			if (num >= 10) {
				con.rollback(); throw new SQLException("예약인원 초과"); 
			}
			 
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, reservation.getUserSeq());
			ps.setString(2, reservation.getSVCID());
			ps.setString(3, reservation.getSvcDate());
			ps.setString(4, reservation.getSvcTime());
			ps.setInt(5, reservation.getResvPeo());
			ps.setInt(6, reservation.getResvPrice());
			ps.setInt(7, reservation.getResvCheck());
			ps.setString(8, reservation.getCancleDate());
			
			result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("성공");
				con.commit();
			}
		
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
   
	@Override
	public ReservationDTO selectByUserSeq(int userSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where user_seq = ? 
		String sql = "select * from reservation where user_seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectByResvSeq(int resvSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = null;
		
		// select * from reservation where resv_Seq = ? 
		String sql = "select * from reservation where reserv_Seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resvSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectBySVCIDRes (String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = null;
		
		// select * from reservation where SVCID = ? 
		String sql = "select * from reservation where SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, SVCID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}
	
	@Override
	public FesDTO selectBySVCIDFes(String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FesDTO dto = null;
		
		// select * from FES where SVCID = ? 
		String sql = "select * from FES where SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, SVCID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String svcid = rs.getString("SVCID");
				String MaxClassNm = rs.getString("MAXCLASSNM");
				String MinClassNm = rs.getString("MINCLASSNM");
				String svcStateNm = rs.getString("SVCSTATNM");
				String svcNm = rs.getString("SVCNM");
				String payAtNm = rs.getString("PAYATNM");
				String placeNm = rs.getString("PLACENM");
				String useTgtInfo = rs.getString("USETGTINFO");
				String x = rs.getString("X");
				String y = rs.getString("Y");
				String svcOpnbgndt = rs.getString("SVCOPNBGNDT");
				String svcOpnenddt = rs.getString("SVCOPNENDDT");
				String rcptdgndt = rs.getString("RCPTBGNDT");
				String areaNm = rs.getString("AREANM");
				String imgUrl = rs.getString("IMGURL");
				String dtlCont = rs.getString("DTLCONT");
				String telNo = rs.getString("TELNO");
				String vMax = rs.getString("V_MAX");
				String vMin = rs.getString("V_MIN");
				String revStdDay = rs.getString("REVSTDDAY");
				String revStdDayNm = rs.getString("REVSTDDAYNM");
				int fesState = rs.getInt("FES_STATE");
				String updateDate = rs.getString("UPDATE_DATE");
				int maxNum = rs.getInt("MAXNUM");
				int price = rs.getInt("PRICE");
				int hostSeq = rs.getInt("HOST_SEQ");
				
				dto = new FesDTO(svcid, MaxClassNm, MinClassNm, svcStateNm, svcNm, payAtNm, placeNm, useTgtInfo, x,
						y, svcOpnbgndt, svcOpnenddt, rcptdgndt, areaNm, imgUrl, dtlCont, telNo, vMax, vMin, revStdDay,
						revStdDayNm, fesState, updateDate, maxNum, price, hostSeq);
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public ReservationDTO selectByUserSeqAndSVCID(int userSeq, String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReservationDTO dto = new ReservationDTO();
		
		// select * from reservation where user_seq = ? and SVCID = ? 
		String sql = "select * from reservation where user_seq = ? and SVCID = ? order by reserv_seq";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			ps.setString(2, SVCID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReservationDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public FesDTO selectFes(String SVCID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FesDTO dto = null;
		
		// select * from FES where SVCID = ? 
		String sql = "select * from FES where SVCID = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, SVCID);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				String svcid = rs.getString("SVCID");
				String MaxClassNm = rs.getString("MAXCLASSNM");
				String MinClassNm = rs.getString("MINCLASSNM");
				String svcStateNm = rs.getString("SVCSTATNM");
				String svcNm = rs.getString("SVCNM");
				String payAtNm = rs.getString("PAYATNM");
				String placeNm = rs.getString("PLACENM");
				String useTgtInfo = rs.getString("USETGTINFO");
				String x = rs.getString("X");
				String y = rs.getString("Y");
				String svcOpnbgndt = rs.getString("SVCOPNBGNDT");
				String svcOpnenddt = rs.getString("SVCOPNENDDT");
				String rcptdgndt = rs.getString("RCPTBGNDT");
				String areaNm = rs.getString("AREANM");
				String imgUrl = rs.getString("IMGURL");
				String dtlCont = rs.getString("DTLCONT");
				String telNo = rs.getString("TELNO");
				String vMax = rs.getString("V_MAX");
				String vMin = rs.getString("V_MIN");
				String revStdDay = rs.getString("REVSTDDAY");
				String revStdDayNm = rs.getString("REVSTDDAYNM");
				int fesState = rs.getInt("FES_STATE");
				String updateDate = rs.getString("UPDATE_DATE");
				int maxNum = rs.getInt("MAXNUM");
				int price = rs.getInt("PRICE");
				int hostSeq = rs.getInt("HOST_SEQ");
				
				dto = new FesDTO(svcid, MaxClassNm, MinClassNm, svcStateNm, svcNm, payAtNm, placeNm, useTgtInfo, x,
						y, svcOpnbgndt, svcOpnenddt, rcptdgndt, areaNm, imgUrl, dtlCont, telNo, vMax, vMin, revStdDay,
						revStdDayNm, fesState, updateDate, maxNum, price, hostSeq);
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}
	
	@Override
	public UsersDTO selectUser(int userSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO dto = null;
		
		// select * from USERS where user_seq = ? 
		String sql = "select * from USERS where user_seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int user_seq = rs.getInt("USER_SEQ");
				String user_id = rs.getString("USER_ID");
				int age = rs.getInt("AGE");
				String addr = rs.getString("ADDR");
				String gender = rs.getString("GENDER");
				String email = rs.getString("EMAIL");
				String user_name = rs.getString("USER_NAME");
				String user_tel = rs.getString("USER_TEL");
				String disable = rs.getString("DISABLE");
				dto = new UsersDTO(user_seq, user_id, null, age, addr, gender, email, user_name, disable, user_tel);
			}
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}
	
	@Override
	public WALLET payment(int userSeq, int fee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		WALLET wallet = null;
		
		int money = 0;
		
		// select * from wallet where user_seq = ?;
		String sql = "select * from wallet where user_seq = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int wallet_seq = rs.getInt("WALLET_SEQ");
				int user_seq = rs.getInt("USER_SEQ");
				money = rs.getInt("MONEY");
				int point = rs.getInt("W_POINT");
				
				money = money - fee;

				wallet = new WALLET(wallet_seq, user_seq, money, point);
			}
			
			int result = walletUpdate(money, userSeq, con); 
		
		}finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return wallet;
	}
	
	public int walletUpdate(int money, int userSeq, Connection con) throws SQLException {
		PreparedStatement ps = null;
		WALLET wallet = null;
		int result = 0;
		
		// UPDATE WALLET SET MOENY=? WHERE USER_SEQ = ?;
		String sql = "UPDATE WALLET SET MONEY=? WHERE USER_SEQ = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setInt(2, userSeq);

			result = ps.executeUpdate();
		
		}finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}

	@Override
	public int changeReservation(int resvSeq) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		// UPDATE RESERVATION SET RESERV_CHECK=? WHERE RESERV_SEQ = ?;
		String sql = "UPDATE RESERVATION SET RESERV_CHECK=? WHERE RESERV_SEQ = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.setInt(2, resvSeq);

			result = ps.executeUpdate();
		
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<Integer> getReservNum(String svcId, String date) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<Integer>();
		int count1=0, count2=0, count3=0;
		
		// select * from reservation where SVCID = ? and svc_date = ?;
		String sql = "select * from reservation where SVCID = ? and svc_date = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, svcId);
			ps.setString(2, date);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				String svc_time = rs.getString("SVC_TIME");
				int resv_peo = rs.getInt("RESV_PEO");
				
				switch(svc_time) {
					case "1회" : 
						count1+=resv_peo;
						break;
					case "2회" : 
						count2+=resv_peo;
						break;
					case "3회" : 
						count3+=resv_peo;
						break;
				}
				
				System.out.println("1회 : " + count1 + " | " + "2회 : " + count2 + " | " + "3회 : " + count3);

			}
			
			list.add(count1);
			list.add(count2);
			list.add(count3);
		
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	// insert에서 예약인원 체크하는 메소드
	public int getReservNumForInsert (ReservationDTO reservation, Connection con) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		System.out.println("getReservNumForInsert 호출되었습니다~~");
		// select * from reservation where SVCID = ? and svc_date = ?;
		String sql = "select * from reservation where SVCID = ? and svc_date = ? and svc_time = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reservation.getSVCID());
			ps.setString(2, reservation.getSvcDate());
			ps.setString(3, reservation.getSvcTime());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int resv_peo = rs.getInt("RESV_PEO");
				
				count+=resv_peo;
				
				System.out.println(reservation.getSvcTime() + "회 : " + count);

			}
		
		}finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return count;
	}

}