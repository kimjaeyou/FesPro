package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.BoardCategoryDTO;

public interface BoardCtgDAO {
	BoardCategoryDTO selectCtg(int categorySeq) throws SQLException;  // 카테고리 정보 가져오기
}