package wep.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wep.mvc.dto.BoardCategoryDTO;

public class BoardCtgDAOImpl implements BoardCtgDAO {

    private Connection conn;  // DB 연결 객체 (실제 DB 연결 로직은 별도로 구현 필요)


    @Override
    public BoardCategoryDTO selectCtg(int categorySeq) throws SQLException {

        return null;  // 해당 카테고리 정보가 없을 경우 null 반환
    }
}
