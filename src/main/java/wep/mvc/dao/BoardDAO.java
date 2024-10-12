package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public interface BoardDAO {
	
	

		/** 카테고리별 게시글 작성 */
	
	int insertByCtg (BoardDTO boardDTO) throws SQLException;
	

		/** 자신의 게시글 수정 */
	
	int update (BoardDTO boardDTO) throws SQLException;
	
		
		/** 자신의 게시글 삭제*/
	
	int delete (String boardSeq , String user_pw) throws SQLException;
	
		
		/** 카테고리별 전체 목록 조회 */
	
	List<BoardDTO> selectByCtg (BoardDTO boardDTO , BoardCategoryDTO boardCategoryDTO) throws SQLException;
	
		
		/** 선택 게시글 조회*/
		
	BoardDTO select (int userSeq) throws SQLException;
	
}
