package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;
import wep.mvc.dto.WAIT_FES;

public interface FesDAO {

	int insert(FesDTO fesDTO) throws SQLException;
	//List<FesDTO> selectAll() throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	FesDTO selectBySVCID(String sVCID) throws SQLException;

	int update(WAIT_FES waitFes) throws SQLException;
}
