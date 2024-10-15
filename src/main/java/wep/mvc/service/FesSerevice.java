package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;

public interface FesSerevice{

	void insert(FesDTO fesDTO) throws SQLException;

	List<FesDTO> select(int host_seq) throws SQLException;

	//List<FesDTO> selectAll() throws SQLException;

	

}
