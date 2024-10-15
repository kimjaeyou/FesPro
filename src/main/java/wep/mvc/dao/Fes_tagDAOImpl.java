package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dto.FES_TAG;
import wep.mvc.util.DbUtil;

public class Fes_tagDAOImpl implements Fes_tagDAO {

	@Override
	public int insert(String sVCID, String tag_content) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		String sql = "insert into FES_TAG values(TAG_SEQ.NEXTVAL,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, sVCID);
			ps.setString(2, tag_content);
			
			result=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public List<String> selectBySVCID(String sVCID) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<String> fes_tag_content = new ArrayList<String>();
		
		String sql="select TAG_CONTENT from FES_TAG where SVCID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sVCID);
			rs = ps.executeQuery();
			while(rs.next()) {
				fes_tag_content.add(rs.getString(1));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return fes_tag_content;
	}

	

}
