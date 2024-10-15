package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.WAIT_FES;

public interface FesSerevice{

	void insert(FesDTO fesDTO) throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	FesDTO selectBySVCID(String sVCID) throws SQLException;

	void update(WAIT_FES waitFes) throws SQLException;

	//List<FesDTO> selectAll() throws SQLException;

	

}
