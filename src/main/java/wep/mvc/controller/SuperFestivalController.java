package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.service.FesSerevice;
import wep.mvc.service.FesSereviceImpl;
import wep.mvc.service.SuperFestivalService;
import wep.mvc.service.SuperFestivalServiceImpl;

public class SuperFestivalController implements Controller {
	SuperFestivalService festivalService = new SuperFestivalServiceImpl();
	FesSerevice fesService = new FesSereviceImpl();
	
	/**
	 * 행사 변경될때 애플리케이션 영역에 업로드
	 * @param req
	 * @param fesDto
	 * @param action 0-넣기 1-빼기
	 */
	private void setfesDtoApplication(HttpServletRequest req,FesDTO fesDto, int action) {
		ServletContext application = req.getServletContext();
		List<FesDTO> fesList = (List<FesDTO>)application.getAttribute("fesList");
		
		//넣기
		if(action ==0) {
			boolean exist=false; //이미 있는지
			FesDTO origin=null; //있으면 바꿔줄 데이터
			
			for (FesDTO originData : fesList) {
				if(originData.getSVCID().equals(fesDto.getSVCID())) {
					exist =true;
					origin = originData;
					break;
				}
			}
			
			if(exist) {
				fesList.remove(origin);
			}
			fesList.add(fesDto);
		}
		//빼기
		else if(action ==1) {
			for (FesDTO originData : fesList) {
				if(originData.getSVCID().equals(fesDto.getSVCID())) {
					fesList.remove(originData);
					break;
				}
			}
		}
		
		application.setAttribute("fesList", fesList);
	}

	public SuperFestivalController() {
		// System.out.println("형우 / SuperFestivalController 생성자 Call");
	}

	/**
	 * 문화행사 전체조회
	 */
	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// System.out.println("형우 / selectAll Call");

		// List<FesDTO> list = festivalService.selectAll();

		// fes테이블의 승인완료, 비활성화인 리스트 + waitfes테이블의 모든 리스트
		List<FesDTO> list = festivalService.selectAllSuper();

		req.setAttribute("festivalList", list);

		return new ModelAndView("super/festival/selectAll.jsp");
	}

	/**
	 * 문화행사 상세
	 */
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// System.out.println("형우 / detail Call");

		String svcid = req.getParameter("svcid");
		String state = req.getParameter("state");
		// System.out.println(state);

		// FesDTO 정보 보내기
		FesDTO fes = new FesDTO();
		fes.setSVCID(svcid);

		boolean isWaitFes = (state.equals("0") || state.equals("2")); // 승인대기 또는 수정대기인 행사를 자세히 보기했는지
		// System.out.println("isWaitFes / " +isWaitFes);
		FesDTO searchFes = festivalService.select(fes, isWaitFes);
		req.setAttribute("fes", searchFes);

		// USERsDTO 정보 보내기
		List<UsersDTO> userList = festivalService.selectUser(fes);
		// System.out.println(userList);
		Gson g = new Gson();
		String data = g.toJson(userList);
		req.setAttribute("userList", data);

		// 리뷰 정보 보내기
		List<ReviewDTO> reviewList = festivalService.selectReview(fes);
		data = g.toJson(reviewList);
		req.setAttribute("reviewList", data);
		req.setAttribute("reviewLength", reviewList.size());

		// 리뷰 쓴 유저 정보 보내기
		List<UsersDTO> reviewUserList = festivalService.selectReviewUser(fes);
		data = g.toJson(reviewUserList);
		req.setAttribute("reviewUserList", data);

		return new ModelAndView("super/festival/detail.jsp");
	}

	/**
	 * 문화행사 수정
	 */
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// System.out.println("update Call");
		// System.out.println("형우 / update Call");
		// System.out.println(req.getParameter("SVCID"));
		// System.out.println(req.getParameter("festivalStateOptions"));
		int fesState = Integer.parseInt(req.getParameter("festivalStateOptions")); // 라디오에서 넘어온 값
		int originState = Integer.parseInt(req.getParameter("originState")); // 라디오에서 변경하기 전 값

		System.out.println("오리진 스테이트 " + originState);
		System.out.println("바꾸려는 스테이트 " + fesState);

		FesDTO fes = new FesDTO(); // 폼에 행사데이터
		fes.setSVCID(req.getParameter("SVCID"));
		fes.setMAXCLASSNM(req.getParameter("MAXCLASSNM"));
		fes.setMINCLASSNM(req.getParameter("MINCLASSNM"));
		fes.setSVCSTATNM(req.getParameter("SVCSTATNM"));
		fes.setSVCNM(req.getParameter("SVCNM"));
		fes.setPAYATNM(req.getParameter("PAYATNM"));
		fes.setPLACENM(req.getParameter("PLACENM"));
		fes.setUSETGTINFO(req.getParameter("USETGTINFO"));
		fes.setX(req.getParameter("X"));
		fes.setY(req.getParameter("Y"));
		fes.setSVCOPNBGNDT(req.getParameter("SVCOPNBGNDT"));
		fes.setSVCOPNENDDT(req.getParameter("SVCOPNENDDT"));
		fes.setRCPTBGNDT(req.getParameter("RCPTBGNDT"));
		fes.setAREANM(req.getParameter("AREANM"));
		fes.setIMGURL(req.getParameter("IMGURL"));
		fes.setDTLCONT(req.getParameter("DTLCONT"));
		fes.setTELNO(req.getParameter("TELNO"));
		fes.setV_MAX(req.getParameter("V_MAX"));
		fes.setV_MIN(req.getParameter("V_MIN"));
		fes.setREVSTDDAY(req.getParameter("REVSTDDAY"));
		fes.setREVSTDDAYNM(req.getParameter("REVSTDDAYNM"));
		fes.setFes_state(fesState); // 등록상태
		fes.setUpdate_date(req.getParameter("Update_date"));
		fes.setMAXNUM(Integer.parseInt(req.getParameter("MAXNUM")));
		fes.setPRICE(Integer.parseInt(req.getParameter("PRICE")));
		fes.setHost_seq(Integer.parseInt(req.getParameter("host_seq")));
		fes.setRCPTENDDT(req.getParameter("RCPTENDDT"));

		int result = 0;

		// 등록대기에서 승인완료
		if (originState == 0 && fesState == 1) {
			// fes에 insert
			fesService.insertListener(fes);
			// waitfes에 delete
			result = festivalService.delete(fes);
		}
		// 수정대기에서 승인완료
		else if (originState == 2 && fesState == 1) {
			// fes에 update
			festivalService.update(fes);
			// waitfes에서 delete
			result = festivalService.delete(fes);
			
		}
		/*
		 * //완료상태에서 등록대기 else if(originState ==1 && fesState ==0){ //fes에서 update(상태만
		 * 업데이트)가 아니라 삭제를해야함 -> 왜냐 삭제를 안하면 등록대기에서 완료로 갈때 insert를 못해줌 무결성제약조건
		 * //festivalService.update(fes,0); result = festivalService.deleteFes(fes);
		 * //waitfes에서 insert; fesService.insert(fes); } //완료에서 수정대기 else if
		 * (originState ==1 && fesState==2) { //fes에서 update(상태만 업데이트) result =
		 * festivalService.update(fes,2); //waitfes에서 insert; fesService.insert(fes); }
		 */
		// 나머지들은 그냥 FES에서 업데이트
		else {
			festivalService.update(fes, fesState);
		}
		
		
		
		

		if (result == 1) {
			// 성공
			/* 애플리케이션 로직*/
			if(fesState ==1) {
				//넣기
				setfesDtoApplication(req,fes,0); 
			}
			else {
				 //빼기
				setfesDtoApplication(req,fes,1);
			}
		} else {
			System.out.println("형우 / 행사 업데이트 실패 Controller-update");
		}

		return new ModelAndView("front?key=superfestival&methodName=selectAll", true);
	}

	/**
	 * 대시보드에서 행사 미승인건 전체 확인.
	 */
	public ModelAndView dashFesSelectAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String search = req.getParameter("search");
		System.out.println("search = " + search);
		List<FesDTO> list = festivalService.dashFesSelectAll();

		req.setAttribute("festivalList", list);
		req.setAttribute("search", search);
		return new ModelAndView("super/auth/dashFesSelectAll.jsp");
	}

	/**
	 * 문화행사 상세
	 */
	public ModelAndView dashWaitAcceptDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		//System.out.println("형우 / detail Call");
		
		String svcid = req.getParameter("svcid");
		System.out.println("svcid="+svcid);
		String state = req.getParameter("state");
		//System.out.println(state);
		
		
		//FesDTO 정보 보내기
		FesDTO fes = new FesDTO();
		fes.setSVCID(svcid);

		boolean isWaitFes = (state.equals("0") || state.equals("2")); 	//승인대기 또는 수정대기인 행사를 자세히 보기했는지 
		System.out.println("isWaitFes / " +isWaitFes);
		FesDTO searchFes=festivalService.select(fes,isWaitFes);
		System.out.println("searchFes="+searchFes);
		req.setAttribute("fes", searchFes);

		// USERsDTO 정보 보내기
		List<UsersDTO> userList = festivalService.selectUser(fes);
		// System.out.println(userList);
		Gson g = new Gson();
		String data = g.toJson(userList);
		req.setAttribute("userList", data);

		// 리뷰 정보 보내기
		List<ReviewDTO> reviewList = festivalService.selectReview(fes);
		data = g.toJson(reviewList);
		req.setAttribute("reviewList", data);
		req.setAttribute("reviewLength", reviewList.size());

		// 리뷰 쓴 유저 정보 보내기
		List<UsersDTO> reviewUserList = festivalService.selectReviewUser(fes);
		data = g.toJson(reviewUserList);
		req.setAttribute("reviewUserList", data);

		return new ModelAndView("super/auth/dashFesDetail.jsp");
	}
	
	

	/**
	 * 문화행사 승인으로 수정
	 */
	public ModelAndView dashFesAcceptUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		//System.out.println("update Call");
		//System.out.println("형우 / update Call");
		//System.out.println(req.getParameter("SVCID"));
		//System.out.println(req.getParameter("festivalStateOptions"));
		System.out.println("!!!!!!!!!!!!!!e 1번 카드 눌렀을때 나오는 Call");
		int fesState = Integer.parseInt(req.getParameter("festivalStateOptions")); //라디오에서 넘어온 값
		//System.out.println("페스티벌 스테이트" +fesState);
		int originState = Integer.parseInt(req.getParameter("originState")); // 라디오에서 변경하기 전 값

		System.out.println("오리진 스테이트 " + originState);
		System.out.println("바꾸려는 스테이트 " + fesState);
		
		
		FesDTO fes = new FesDTO();
	    fes.setSVCID(req.getParameter("SVCID"));
	    fes.setMAXCLASSNM(req.getParameter("MAXCLASSNM"));
	    fes.setMINCLASSNM(req.getParameter("MINCLASSNM"));
	    fes.setSVCSTATNM(req.getParameter("SVCSTATNM"));
	    fes.setSVCNM(req.getParameter("SVCNM"));
	    fes.setPAYATNM(req.getParameter("PAYATNM"));
	    fes.setPLACENM(req.getParameter("PLACENM"));
	    fes.setUSETGTINFO(req.getParameter("USETGTINFO"));
	    fes.setX(req.getParameter("X"));
	    fes.setY(req.getParameter("Y"));
	    fes.setSVCOPNBGNDT(req.getParameter("SVCOPNBGNDT"));
	    fes.setSVCOPNENDDT(req.getParameter("SVCOPNENDDT"));
	    fes.setRCPTBGNDT(req.getParameter("RCPTBGNDT"));
	    fes.setAREANM(req.getParameter("AREANM"));
	    fes.setIMGURL(req.getParameter("IMGURL"));
	    fes.setDTLCONT(req.getParameter("DTLCONT"));
	    fes.setTELNO(req.getParameter("TELNO"));
	    fes.setV_MAX(req.getParameter("V_MAX"));
	    fes.setV_MIN(req.getParameter("V_MIN"));
	    fes.setREVSTDDAY(req.getParameter("REVSTDDAY"));
	    fes.setREVSTDDAYNM(req.getParameter("REVSTDDAYNM"));
	    fes.setFes_state(fesState); //등록상태
	    fes.setUpdate_date(req.getParameter("Update_date"));
	    fes.setMAXNUM(Integer.parseInt(req.getParameter("MAXNUM")));
	    fes.setPRICE(Integer.parseInt(req.getParameter("PRICE")));
	    fes.setHost_seq(Integer.parseInt(req.getParameter("host_seq")));
	    fes.setRCPTENDDT(req.getParameter("RCPTENDDT"));
		
	    int result = 0;

		// 등록대기에서 승인완료
		if (originState == 0 && fesState == 1) {
			// fes에 insert
			fesService.insertListener(fes);
			// waitfes에 delete
			result = festivalService.delete(fes);
		}
		// 수정대기에서 승인완료
		else if (originState == 2 && fesState == 1) {
			// fes에 update
			festivalService.update(fes);
			// waitfes에서 delete
			result = festivalService.delete(fes);
		}
		//나머지는 그냥 스테이트업데이트
		else {
			result = festivalService.update(fes, fesState);
		}

		
		
///////재구 페이지 처리
	    if (result == 1) {//////////==========================================
	    	
	    	/* 애플리케이션 로직*/
			if(fesState ==1) {
				//넣기
				setfesDtoApplication(req,fes,0);
			}
			else {//(비활성화)
				 //빼기
				setfesDtoApplication(req,fes,1);
			}
	    	
	    	System.out.println("3333333333333333333333333");

	        // 업데이트 성공 시
	        if (fesState == 2) {
	            // 행사수정 미승인건 처리 후 이동       	
	            return new ModelAndView("front?key=superfestival&methodName=dashFesWaitFesSelectAll", true);
	        } else if (fesState == 3) {
	            // 행사 취소 미승인건 처리 후 이동
	            return new ModelAndView("front?key=superfestival&methodName=dashFesCancleWaitFesSelectAll", true);
	        } else {
	            // 그 외의 경우 기본 selectAll로 이동
	            return new ModelAndView("front?key=superfestival&methodName=dashFesSelectAll", true);
	        }
	    } else {
	    	System.out.println("44444444444444444444");
	        System.out.println("행사 업데이트 실패 Controller-update");
	        return new ModelAndView("front?key=superfestival&methodName=dashFesSelectAll");
	    }
	
	}
	
	
	/**
	 * 대시보드에서 행사수정 미승인건 전체 확인. 
	 */
	public ModelAndView dashFesWaitFesSelectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		/*
		 * String search = req.getParameter("search");
		 * System.out.println("search = "+search);
		 */
		List<FesDTO> list =  festivalService.dashFesWaitFesSelectAll();
		System.out.println("재구/행사수정");
		
		for(FesDTO fes:list)
		{
			System.out.println(fes.getSVCNM());
		}
		req.setAttribute("festivalList", list);
		
		/* req.setAttribute("search", search); */
		return new ModelAndView("super/auth/dashFesSelectAll.jsp");
	}
	
	/**
	 * 대시보드에서 행사취소 미승인건 전체 확인. 
	 */
	public ModelAndView dashFesCancleWaitFesSelectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		
		String search = req.getParameter("search");
		System.out.println("search = "+search);
		List<FesDTO> list =  festivalService.dashFesCancleWaitFesSelectAll();
		
		req.setAttribute("festivalList", list);
		req.setAttribute("search", search);
		return new ModelAndView("super/auth/dashFesSelectAll.jsp");
	}

	
	/**
	 * 대시보드에서 행사 미승인건에 대한 수정
	 */
	public ModelAndView dashFesUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("update Call");
		
		FesDTO fes = new FesDTO();
	    fes.setSVCID(req.getParameter("SVCID"));
	    fes.setMAXCLASSNM(req.getParameter("MAXCLASSNM"));
	    fes.setMINCLASSNM(req.getParameter("MINCLASSNM"));
	    fes.setSVCSTATNM(req.getParameter("SVCSTATNM"));
	    fes.setSVCNM(req.getParameter("SVCNM"));
	    fes.setPAYATNM(req.getParameter("PAYATNM"));
	    fes.setPLACENM(req.getParameter("PLACENM"));
	    fes.setUSETGTINFO(req.getParameter("USETGTINFO"));
	    fes.setX(req.getParameter("X"));
	    fes.setY(req.getParameter("Y"));
	    fes.setSVCOPNBGNDT(req.getParameter("SVCOPNBGNDT"));
	    fes.setSVCOPNENDDT(req.getParameter("SVCOPNENDDT"));
	    fes.setRCPTBGNDT(req.getParameter("RCPTBGNDT"));
	    fes.setAREANM(req.getParameter("AREANM"));
	    fes.setIMGURL(req.getParameter("IMGURL"));
	    fes.setDTLCONT(req.getParameter("DTLCONT"));
	    fes.setTELNO(req.getParameter("TELNO"));
	    fes.setV_MAX(req.getParameter("V_MAX"));
	    fes.setV_MIN(req.getParameter("V_MIN"));
	    fes.setREVSTDDAY(req.getParameter("REVSTDDAY"));
	    fes.setREVSTDDAYNM(req.getParameter("REVSTDDAYNM"));
	    fes.setFes_state(Integer.parseInt(req.getParameter("Fes_state")));
	    fes.setUpdate_date(req.getParameter("Update_date"));
	    fes.setMAXNUM(Integer.parseInt(req.getParameter("MAXNUM")));
	    fes.setPRICE(Integer.parseInt(req.getParameter("PRICE")));
	    fes.setHost_seq(Integer.parseInt(req.getParameter("host_seq")));
		
		int result = festivalService.update(fes,Integer.parseInt(req.getParameter("Fes_state")));
		
		if(result ==1) {
			/* 애플리케이션 로직*/
			if(fes.getFes_state() ==1) {
				//넣기
				setfesDtoApplication(req,fes,0);
			}
			else {//(비활성화)
				 //빼기
				setfesDtoApplication(req,fes,1);
			}
			
			return new ModelAndView("front?key=superAuth&methodName=dashFesSelectAll",true);
		}
		else {
			//에러페이지
			System.out.println("형우 / 행사 업데이트 실패 Controller-update");
			return null;
		}
	}
	
}
