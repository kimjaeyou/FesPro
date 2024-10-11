package wep.mvc.service;

import java.util.ArrayList;
import java.util.List;

import wep.mvc.dao.SuperFestivalDAO;
import wep.mvc.dao.SuperFestivalDAOImpl;
import wep.mvc.dto.FesDTO;

public class SuperFestivalServiceImpl implements SuperFestivalService {
	SuperFestivalDAO dao = new SuperFestivalDAOImpl();
	
	@Override
	public List<FesDTO> selectAll() {
		List<FesDTO> result=null;
		
		//더미 데이터
		FesDTO fes1 = new FesDTO(
			    "SVC001", "문화", "음악", "운영중", "서울재즈페스티벌", "현장결제", "서울 올림픽공원", "일반", "37.520454", "127.121788", 
			    "2024-05-01", "2024-05-03", "2024-04-01", "서울", "https://example.com/image1.jpg", "서울에서 열리는 재즈 페스티벌", 
			    "010-1234-5678", "30°C", "20°C", "2024-05-02", "금요일", 1, "2024-04-10", 1000, 50000, 1001
			);

			FesDTO fes2 = new FesDTO(
			    "SVC002", "문화", "영화", "운영예정", "부산국제영화제", "온라인결제", "부산 영화의전당", "영화 애호가", "35.181467", "129.074403", 
			    "2024-10-01", "2024-10-10", "2024-09-01", "부산", "https://example.com/image2.jpg", "부산에서 열리는 국제 영화제", 
			    "010-8765-4321", "28°C", "18°C", "2024-10-05", "토요일", 0, "2024-09-15", 1500, 30000, 1002
			);

			FesDTO fes3 = new FesDTO(
			    "SVC003", "스포츠", "축구", "운영중", "K리그 결승전", "현장결제", "서울 월드컵경기장", "축구 팬", "37.568256", "126.897240", 
			    "2024-11-15", "2024-11-15", "2024-10-01", "서울", "https://example.com/image3.jpg", "K리그 챔피언 결정전", 
			    "010-2222-3333", "22°C", "15°C", "2024-11-15", "일요일", 1, "2024-10-20", 50000, 100000, 1003
			);

			FesDTO fes4 = new FesDTO(
			    "SVC004", "문화", "공연", "운영중", "뮤지컬 레미제라블", "온라인결제", "대구 오페라하우스", "뮤지컬 팬", "35.872022", "128.601743", 
			    "2024-12-20", "2024-12-31", "2024-12-01", "대구", "https://example.com/image4.jpg", "레미제라블 공연", 
			    "010-4444-5555", "10°C", "5°C", "2024-12-25", "목요일", 1, "2024-12-05", 800, 70000, 1004
			);

			FesDTO fes5 = new FesDTO(
			    "SVC005", "축제", "음식", "운영중", "전주비빔밥축제", "현장결제", "전주 한옥마을", "미식가", "35.814027", "127.150750", 
			    "2024-09-15", "2024-09-20", "2024-09-01", "전주", "https://example.com/image5.jpg", "전통 비빔밥을 즐길 수 있는 축제", 
			    "010-5555-6666", "26°C", "16°C", "2024-09-17", "수요일", 1, "2024-08-25", 3000, 10000, 1005
			);
		
			result = new ArrayList();
			result.add(fes1);
			result.add(fes2);
			result.add(fes3);
			result.add(fes4);
			result.add(fes5);

		return result;
	}

}
