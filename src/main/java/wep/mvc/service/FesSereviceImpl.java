package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.FesDAO;
import wep.mvc.dao.FesDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.WAIT_FES;

public class FesSereviceImpl implements FesSerevice {
	private FesDAO fesDAO = new FesDAOImpl();

	@Override
	public void insert(FesDTO fesDTO) throws SQLException {
		int result = fesDAO.insert(fesDTO);
		if (result == 0)
			throw new SQLException("등록되지 않았습니다");
	}
	/*
	 * private FesDAO fesDAO = new FesDAOImpl();
	 * 
	 * @Override public List<FesDTO> selectAll() throws SQLException { List<FesDTO>
	 * fesDTOList = fesDAO.selectAll(); return fesDTOList; }
	 */

	@Override
	public List<FesDTO> select(int host_seq) throws SQLException {
		List<FesDTO> list = fesDAO.select(host_seq);
		return list;
	}

	@Override
	public FesDTO selectBySVCID(String sVCID) throws SQLException {
		FesDTO fesDTO = fesDAO.selectBySVCID(sVCID);

		return fesDTO;
	}

	@Override
	public void update(WAIT_FES waitFes) throws SQLException {
		if (fesDAO.update(waitFes) == 0) {
			throw new SQLException("수정 신청하기 실패");
		}
	}

	@Override
	public void insertListener(FesDTO fesdto) throws SQLException {
		int result = fesDAO.insertListener(fesdto);
		if (result == 0)
			throw new SQLException("등록되지 않았습니다");
	}

	@Override
	public List<WAIT_FES> selectWaitFesList(int host_seq) throws SQLException {
		List<WAIT_FES> list = fesDAO.selectWaitFesList(host_seq);
		return list;
	}

	@Override
	public WAIT_FES fesWaitselectBySVCID(String sVCID) throws SQLException {
		WAIT_FES waitFes = fesDAO.fesWaitselectBySVCID(sVCID);

		return waitFes;
	}

	@Override
	public void updateFes(String SVCID) throws SQLException {
		if (fesDAO.updateFes(SVCID) == 0) {
			throw new SQLException("삭제하기 실패");
		}

	}

	@Override
	public void updateFes(String sVCID, int i) throws SQLException {
		if (fesDAO.updateFes(sVCID, i) == 0) {
			throw new SQLException("수정 신청하기 실패");
		}

	}


	@Override
	public HostDTO myPage2(int host_seq) throws SQLException {
		HostDTO hostDTO = fesDAO.myPage2(host_seq);
		return hostDTO;
	}

	@Override
	public void myHostDelete(int host_seq) throws SQLException {
		if(fesDAO.myHostDelete(host_seq)==0) {
			throw new SQLException("탈퇴하기 실패");
		}
	}

	@Override
	public void pwUpdateForm22(String newPw, int host_seq) throws SQLException {
		if(fesDAO.pwUpdateForm22(newPw, host_seq)==0) {
			throw new SQLException("비밀번호 변경 실패");
		}
		
	}

	@Override
	public List<FesDTO> selectALL() throws SQLException {
		return fesDAO.selectALL();
		
	}

	
}

