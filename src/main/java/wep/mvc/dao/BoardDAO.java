package wep.mvc.dao;

import java.sql.SQLException;

import wep.mvc.dto.BoardDTO;

public interface BoardDAO {
	
	

		/** 공지사항 게시글 작성 */
	
	int insertNoti (BoardDTO boardDTO) throws SQLException;
	
		/** QA 게시글 작성 */
	
	int insertQA (BoardDTO boardDTO) throws SQLException;
	
		/** 자유 게시글 작성*/
	
	int insertFree (BoardDTO boardDTO) throws SQLException;
	
		/** 자신의 게시글 수정 */
	
	
		
		/** 자신의 게시글 삭제*/
	
	
		
		/** 공지사항 전체 목록 조회 */
	
	
	
		/** QA 전체 목록 조회 */
	
	
	
		/** 자유 게시판 전체 목록 조회*/
	
	
		
		/** 선택 게시글 조회*/
		
	
	
}
