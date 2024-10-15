package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public interface BoardService {
	
	/**
	 * 글쓰기
	 * */
	public int write(Integer userSeq, Integer hostSeq, String title, String content, String categoryParam)
            throws SQLException;

	/**
	 * 수정
	 * */
	public int update(BoardDTO boardDTO) throws SQLException;

	/**
	 * 삭제
	 * @param boardSeq 
	 * */
	public int delete(int boardSeq, int userSeq, int hostSeq) throws SQLException;


	/**
	 * 상세보기
	 * */
	BoardDTO select(int postUserSeq, Integer userSeq, Integer hostSeq) throws SQLException;
	
	/**
	 * 목록 조회
	 * */
	
	List<BoardDTO> selectByCtg () throws SQLException;
	
	
	
}
