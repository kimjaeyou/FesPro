package wep.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public List<FesDTO> selecLike(int user_seq, List<FesDTO> fesList) throws SQLException {
		List<String> list = dao.selecLike(user_seq);
		List<FesDTO> fesLike = new ArrayList<>();

		if (list == null) {
			throw new SQLException();
		} else {
			for (String svcid : list) {
				for (FesDTO fes : fesList) {
					if (fes.getSVCID().equals(svcid)) {
						fesLike.add(fes);
					}
				} // inner for end
			} // outer for end
		} // else end
		return fesLike;
	}

}
