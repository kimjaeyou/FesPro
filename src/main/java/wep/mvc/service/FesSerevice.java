package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.WAIT_FES;

public interface FesSerevice{

	void insert(FesDTO fesDTO) throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	FesDTO selectBySVCID(String sVCID) throws SQLException;

	void update(WAIT_FES waitFes) throws SQLException;

	void insertListener(FesDTO fesdto) throws SQLException;

	List<WAIT_FES> selectWaitFesList(int host_seq) throws SQLException;

	WAIT_FES fesWaitselectBySVCID(String sVCID) throws SQLException;

	void updateFes(String sVCID) throws SQLException;

	void updateFes(String sVCID, int i) throws SQLException;

	HostDTO myPage2(int host_seq) throws SQLException;

	void myHostDelete(int host_seq) throws SQLException;

	void pwUpdateForm22(String newPw, int host_seq) throws SQLException;



	//List<FesDTO> selectAll() throws SQLException;

	

}