package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.util.DbUtil;

public class FesDAOImpl implements FesDAO{

	@Override
	public int insert(FesDTO fesDTO) throws SQLException {
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
		
		String sql = "select * from FES where HOST_SEQ=?";
		
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
	
}
