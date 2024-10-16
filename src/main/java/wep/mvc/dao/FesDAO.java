package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.WAIT_FES;

public interface FesDAO {

	int insert(FesDTO fesDTO) throws SQLException;
	//List<FesDTO> selectAll() throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	FesDTO selectBySVCID(String sVCID) throws SQLException;

	int update(WAIT_FES waitFes) throws SQLException;

	int insertListener(FesDTO fesDTO) throws SQLException;

	List<WAIT_FES> selectWaitFesList(int host_seq) throws SQLException;

	WAIT_FES fesWaitselectBySVCID(String sVCID) throws SQLException;

	int updateFes(String sVCID) throws SQLException;

	int updateFes(String sVCID, int i) throws SQLException;


	HostDTO myPage2(int host_seq) throws SQLException;

	int myHostDelete(int host_seq) throws SQLException;

	int pwUpdateForm22(String newPw, int host_seq) throws SQLException;

	
}

