package wep.mvc.service;

import java.sql.SQLException;
import java.util.List;

import wep.mvc.dao.MainDAOImpl;
import wep.mvc.dto.FesDTO;

public class MainSereviceImpl {
	MainDAOImpl dao = new MainDAOImpl();

	public FesDTO selecOne(String sid, List<FesDTO> list) throws SQLException {
		for (FesDTO fes : list) {
			if (fes.getSVCID().equals(sid)) {
				return fes;
			}
		}

		return null;
	}

	public int setLike(String sid, int user) throws SQLException {
		int succ = dao.insert(sid, user);
		if (succ != 0) {
			return succ;
		} else {
			throw new SQLException();
		}
	}

}
