package wep.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;

public interface FesDAO {

	int insert(FesDTO fesDTO) throws SQLException;
	//List<FesDTO> selectAll() throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	FesDTO selectBySVCID(String sVCID) throws SQLException;

	int update(FesDTO fesDTO) throws SQLException;
}
