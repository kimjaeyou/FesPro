package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.WAIT_FES;
import wep.mvc.util.DbUtil;

public class FesDAOImpl implements FesDAO{
	//등록신청하기
	@Override
	public int insert(FesDTO fesDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "insert into WAIT_FES values(WAIT_FES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, fesDTO.getSVCID());
			ps.setString(2, fesDTO.getMAXCLASSNM());
			ps.setString(3, fesDTO.getMINCLASSNM());
			ps.setString(4, fesDTO.getSVCSTATNM());
			ps.setString(5, fesDTO.getSVCNM());
			ps.setString(6, fesDTO.getPAYATNM());
			ps.setString(7, fesDTO.getPLACENM());
			ps.setString(8, fesDTO.getUSETGTINFO());
			ps.setString(9, fesDTO.getX());
			ps.setString(10, fesDTO.getY());
			ps.setString(11, fesDTO.getSVCOPNBGNDT());
			ps.setString(12, fesDTO.getSVCOPNENDDT());
			ps.setString(13, fesDTO.getRCPTBGNDT());
			ps.setString(14, fesDTO.getAREANM());
			ps.setString(15, fesDTO.getIMGURL());
			ps.setString(16, fesDTO.getDTLCONT());
			ps.setString(17, fesDTO.getTELNO());
			ps.setString(18, fesDTO.getV_MAX());
			ps.setString(19, fesDTO.getV_MIN());
			ps.setString(20, fesDTO.getREVSTDDAY());
			ps.setString(21, fesDTO.getREVSTDDAYNM());
			ps.setInt(22, fesDTO.getFes_state());
			ps.setInt(23, fesDTO.getMAXNUM());
			ps.setInt(24, fesDTO.getPRICE());
			ps.setInt(25, fesDTO.getHost_seq());
			ps.setString(26, fesDTO.getRCPTENDDT());
			
			result = ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	//api데이터 db에 바로 넣어주기
	@Override
	public int insertListener(FesDTO fesDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "insert into FES values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, fesDTO.getSVCID());
			ps.setString(2, fesDTO.getMAXCLASSNM());
			ps.setString(3, fesDTO.getMINCLASSNM());
			ps.setString(4, fesDTO.getSVCSTATNM());
			ps.setString(5, fesDTO.getSVCNM());
			ps.setString(6, fesDTO.getPAYATNM());
			ps.setString(7, fesDTO.getPLACENM());
			ps.setString(8, fesDTO.getUSETGTINFO());
			ps.setString(9, fesDTO.getX());
			ps.setString(10, fesDTO.getY());
			ps.setString(11, fesDTO.getSVCOPNBGNDT());
			ps.setString(12, fesDTO.getSVCOPNENDDT());
			ps.setString(13, fesDTO.getRCPTBGNDT());
			ps.setString(14, fesDTO.getAREANM());
			ps.setString(15, fesDTO.getIMGURL());
			ps.setString(16, fesDTO.getDTLCONT());
			ps.setString(17, fesDTO.getTELNO());
			ps.setString(18, fesDTO.getV_MAX());
			ps.setString(19, fesDTO.getV_MIN());
			ps.setString(20, fesDTO.getREVSTDDAY());
			ps.setString(21, fesDTO.getREVSTDDAYNM());
			ps.setInt(22, fesDTO.getFes_state());
			ps.setInt(23, fesDTO.getMAXNUM());
			ps.setInt(24, fesDTO.getPRICE());
			ps.setInt(25, fesDTO.getHost_seq());
			ps.setString(26, fesDTO.getRCPTENDDT());
			
			result = ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	
	/*
	@Override
	public List<FesDTO> selectAll() throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<FesDTO> fesDTOList = new ArrayList<FesDTO>();
		
		String sql = "select * from fes"; //select * from fes where host_seq=현재로그인 된 세션의 sequence
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FesDTO fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
										   rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
										   rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
										   rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
										   rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24), rs.getInt(25),
										   rs.getInt(26));
				fesDTOList.add(fesDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return fesDTOList;
	}
	*/

	@Override
	public List<FesDTO> select(int host_seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<FesDTO> list = new ArrayList<FesDTO>();
		
		String sql = "select * from FES where HOST_SEQ=? order by Update_date";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, host_seq);
			rs=ps.executeQuery();
			while(rs.next()) {
				FesDTO fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
										   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
										   rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
										   rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
										   rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
										   rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
										   rs.getInt(25), rs.getInt(26), rs.getString(27));
				list.add(fesDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return list;
	}

	@Override
	public FesDTO selectBySVCID(String sVCID) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		FesDTO fesDTO = null;
		
		String sql="select * from FES where SVCID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sVCID);
			rs = ps.executeQuery();
			if(rs.next()) {
				fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
										   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
										   rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
										   rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
										   rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
										   rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
										   rs.getInt(25), rs.getInt(26), rs.getString(27));
				//System.out.println("코코VER2");
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return fesDTO;
	}

	@Override
	public int update(WAIT_FES waitFes) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql = "insert into WAIT_FES values(WAIT_FES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, waitFes.getSVCID());
			ps.setString(2, waitFes.getMAXCLASSNM());
			ps.setString(3, waitFes.getMINCLASSNM());
			ps.setString(4, waitFes.getSVCSTATNM());
			ps.setString(5, waitFes.getSVCNM());
			ps.setString(6, waitFes.getPAYATNM());
			ps.setString(7, waitFes.getPLACENM());
			ps.setString(8, waitFes.getUSETGTINFO());
			ps.setString(9, waitFes.getX());
			ps.setString(10, waitFes.getY());
			ps.setString(11, waitFes.getSVCOPNBGNDT());
			ps.setString(12, waitFes.getSVCOPNENDDT());
			ps.setString(13, waitFes.getRCPTBGNDT());
			ps.setString(14, waitFes.getAREANM());
			ps.setString(15, waitFes.getIMGURL());
			ps.setString(16, waitFes.getDTLCONT());
			ps.setString(17, waitFes.getTELNO());
			ps.setString(18, waitFes.getV_MAX());
			ps.setString(19, waitFes.getV_MIN());
			ps.setString(20, waitFes.getREVSTDDAY());
			ps.setString(21, waitFes.getREVSTDDAYNM());
			ps.setInt(22, waitFes.getFes_state());
			ps.setInt(23, waitFes.getMAXNUM());
			ps.setInt(24, waitFes.getPRICE());
			ps.setInt(25, waitFes.getHost_seq());
			ps.setString(26, waitFes.getRCPTENDDT());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public List<WAIT_FES> selectWaitFesList(int host_seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<WAIT_FES> list = new ArrayList<WAIT_FES>();
		
		String sql = "select * from WAIT_FES where HOST_SEQ=? order by Update_date";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, host_seq);
			rs=ps.executeQuery();
			while(rs.next()) {
				WAIT_FES waitFes = new WAIT_FES(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
										   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
										   rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
										   rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
										   rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
										   rs.getString(21), rs.getString(22), rs.getInt(23), rs.getString(24),
										   rs.getInt(25), rs.getInt(26), rs.getInt(27),rs.getString(28));
				System.out.println(waitFes.getSVCNM());
				list.add(waitFes);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return list;
	}

	@Override
	public WAIT_FES fesWaitselectBySVCID(String sVCID) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		WAIT_FES waitFes = null;
		
		String sql="select * from WAIT_FES where SVCID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sVCID);
			rs = ps.executeQuery();
			if(rs.next()) {
				waitFes = new WAIT_FES(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						   rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
						   rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
						   rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						   rs.getString(21), rs.getString(22), rs.getInt(23), rs.getString(24),
						   rs.getInt(25), rs.getInt(26), rs.getInt(27),rs.getString(28));
				System.out.println("나나나");
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return waitFes;
	}

	@Override
	public int updateFes(String SVCID) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql = "update FES set FES_STATE=3 where SVCID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, SVCID);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int updateFes(String sVCID, int i) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql = "update FES set FES_STATE=? where SVCID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, i);
			ps.setString(2, sVCID);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public HostDTO myPage2(int host_seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		HostDTO hostDTO = null;
		
		String sql = "select * from HOST where HOST_SEQ=?";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, host_seq);
			rs=ps.executeQuery();
			while(rs.next()) {
				hostDTO = new HostDTO(
						rs.getInt(1), rs.getString(2), rs.getString(9),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8)
				);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return hostDTO;
	}

	@Override
	public int myHostDelete(int host_seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql = "update HOST set HOST_BEN_CHECK=0 where HOST_SEQ=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, host_seq);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int pwUpdateForm22(String newPw, int host_seq) throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		int result=0;
		
		String sql = "update HOST set HOST_PASSWORD=? where HOST_SEQ=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, newPw);
			ps.setInt(2, host_seq);
			result=ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<FesDTO> selectALL() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<FesDTO> fesDTOlist = new ArrayList<FesDTO>();
		
		String sql = "select * from FES";
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				FesDTO fesDTO = new FesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						   rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
						   rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16),
						   rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20),
						   rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24),
						   rs.getInt(25), rs.getInt(26), rs.getString(27));
				fesDTOlist.add(fesDTO);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return fesDTOlist;
	}

	
}

