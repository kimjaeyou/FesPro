package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dto.FesDTO;

public class MainSereviceImpl{
	
	public FesDTO selecOne(String sid,List<FesDTO> list) throws SQLException {
		for(FesDTO fes : list){
			if(fes.getSVCID().equals(sid)) {
				return fes;
			}
		}
			
		return null;
	}
	
	public FesDTO setLike(String sid) throws SQLException {
		
			
		return null;
	}
	
}
