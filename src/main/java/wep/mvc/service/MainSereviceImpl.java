package wep.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.MainDAOImpl;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;

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

	public List<ReviewDTO> selecReview(String sid) throws SQLException {
		List<ReviewDTO> list = dao.selecReview(sid);
		return list;
	}

	public List<FesDTO> searchList(String search, List<FesDTO> fesList) throws SQLException {
		List<FesDTO> serchList = new ArrayList<>();
		serchList = reList(fesList, search);
		return serchList;
	}

	public List<FesDTO> reList(List<FesDTO> list, String search) {
		List<FesDTO> serchList = new ArrayList<>();

		for (FesDTO fes : list) {
			if (fes.getMINCLASSNM().equals(search)) {
				serchList.add(fes);
			}
		}

		return serchList;
	}

	public List<FesDTO> selecMost() throws SQLException {
		List<FesDTO> list = dao.selecMost();
		return list;
	}

	public void setAlarm(int user,String content) throws SQLException {
		int succ = dao.insertAlarm(user,content);
		if (succ != 0) {
			
		} else {
			throw new SQLException();
		}
	}

}