package wep.mvc.service;

import java.sql.SQLException;

import wep.mvc.dao.BoardCtgDAO;
import wep.mvc.dao.BoardCtgDAOImpl;
import wep.mvc.dao.BoardDAO;
import wep.mvc.dao.BoardDAOImpl;
import wep.mvc.dto.BoardCategoryDTO;
import wep.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO = new BoardDAOImpl();
	private BoardCtgDAO boardCategoryDAO = new BoardCtgDAOImpl();
	
@Override
public int delete(String boardSeq, String user_pw) throws SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public BoardDTO select(int postUserSeq, Integer userSeq, Integer hostSeq)
        throws SQLException {

    BoardDTO bDTO = boardDAO.select(postUserSeq);

    if (bDTO == null) {
        return null;
    }
    
    int categorySeq = bDTO.getCategorySeq();
    
    if (categorySeq == 0 || categorySeq == 2) {
        return bDTO; // 게시글 정보를 반환
    }

    if (categorySeq == 1) {
        // 로그인 확인
        if (userSeq == null && hostSeq == null) {
            return null; // 로그인 필요
        }

        // 작성자 또는 호스트 확인
        if (bDTO.getUserSeq() != userSeq && hostSeq == null) {
            return null; // 권한이 없는 경우
        }

        return bDTO; // 게시글 반환
    }

    // 기본 처리 (잘못된 카테고리 번호일 경우)
    return null;
}

@Override
	public int update(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

@Override
	public int write(Integer userSeq, Integer hostSeq, String title, String content, String categoryParam)
			throws SQLException {
   
    int categorySeq = Integer.parseInt(categoryParam);
    BoardCategoryDTO categoryDTO = boardCategoryDAO.selectCtg(categorySeq);
	
	
    if (categoryDTO.getCategorySeq() == 0) { // 공지사항
        if (hostSeq == null) {
            throw new RuntimeException("공지사항은 관리자만 작성할 수 있습니다.");
        }
    } else if (categoryDTO.getCategorySeq() == 1) { // QA
        if (userSeq == null) {
            throw new RuntimeException("QA 게시판은 회원만 작성할 수 있습니다.");
        }
    } else if (categoryDTO.getCategorySeq() == 2) { // 자유게시판
        if (hostSeq == null && userSeq == null) {
            throw new RuntimeException("자유게시판은 회원이나 관리자가 작성할 수 있습니다.");
        }
    }
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setUserSeq(userSeq);
    boardDTO.setHostSeq(hostSeq);
    boardDTO.setSub(title);
    boardDTO.setbContent(content);
    boardDTO.setCategorySeq(Integer.parseInt(categoryParam));
    
    return boardDAO.insert(boardDTO);
	
	}


}
