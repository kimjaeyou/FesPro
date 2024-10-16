package wep.mvc.dao;

import wep.mvc.dto.BoardCategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardCtgDAOImpl implements BoardCtgDAO {

    private Connection conn;  // DB 연결 객체 (실제 DB 연결 로직은 별도로 구현 필요)


    @Override
    public BoardCategoryDTO selectCtg(int categorySeq) throws SQLException {
        String sql = "SELECT CATEGORY_SEQ, CTG_CONTENT FROM BOARD_CATEGORY WHERE CATEGORY_SEQ = ?";  // SQL 쿼리
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, categorySeq);  // 카테고리 번호 바인딩

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new BoardCategoryDTO(
                        rs.getInt("categorySeq"),
                        rs.getString("ctgContent")
                    );  // 카테고리 정보 반환
                }
            }
        }
        return null;  // 해당 카테고리 정보가 없을 경우 null 반환
    }
}