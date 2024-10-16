package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import wep.mvc.dto.FesDTO;
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.ListPublicReservationCulture;
import wep.mvc.dto.ReviewDTO;
import wep.mvc.dto.UsersDTO;
import wep.mvc.dto.WAIT_FES;
import wep.mvc.service.FesSerevice;
import wep.mvc.service.FesSereviceImpl;
import wep.mvc.service.Fes_tagSerevice;
import wep.mvc.service.Fes_tagSereviceImpl;
import wep.mvc.service.SuperFestivalService;
import wep.mvc.service.SuperFestivalServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class FesController implements Controller {
	private FesSerevice fesSerevice = new FesSereviceImpl();
	private Fes_tagSerevice fes_tagSerevice = new Fes_tagSereviceImpl();
	SuperFestivalService festivalService = new SuperFestivalServiceImpl();
	//등록 신청(C)

	public ModelAndView send(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}

	// 등록 신청을 취소/게시글 삭제(D)
	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}

	/////////////////////////////////////////////////////////////////////////////////// 여기는
	/////////////////////////////////////////////////////////////////////////////////// 건들지
	/////////////////////////////////////////////////////////////////////////////////// 않는다...!
	/////////////////////////////////////////////////////////////////////////////////// //행사
	/////////////////////////////////////////////////////////////////////////////////// 리스트
	/////////////////////////////////////////////////////////////////////////////////// 띄우는
	////////잠시 테스트 중이니다.///////////////////////////////////////////// 기능
	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app = req.getServletContext();
		ListPublicReservationCulture list = (ListPublicReservationCulture) app.getAttribute("fesList");
		req.setAttribute("list", list);
		return new ModelAndView("fes/list.jsp");
	}
	///////////////////////////////////////////////////////////////////////////////////

	/**
	 * 전체검색
	 */
	public ModelAndView select(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1. fes 테이블 db에서 꺼내와서 조회
		
		// List<FesDTO> fesDTOList = fesSerevice.selectAll();

		HttpSession session = req.getSession();

		if (session.getAttribute("loginCom") == null) { // 기업회원으로 로그인 되어있는지 확인
			System.out.println("로그인 안했지롱");
			return new ModelAndView("User/login.jsp"); // 로그인 페이지로 보낼 것
		}

		// 기업회원으로 로그인 되어있다면 해당 기업회원 세션에 해당하는 fesDTO만 DB에서 꺼내서 보여줘야지.
		// ServletContext app = req.getServletContext();
		// List<FesDTO> fesDTOList= (List<FesDTO>)app.getAttribute("fesList");

		// req.setAttribute("fesDTOList", fesDTOList);

		// req.setAttribute("fesDTOList", fesDTOList);

		System.out.println("여기");
		
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("loginCom");
		
		int host_seq = SessionHostDTO.getHost_seq();

		List<FesDTO> fesDTOList = fesSerevice.select(host_seq);
		
		
		req.setAttribute("fesDTOList", fesDTOList);
		
		//2. wait_fes 테이블 db에서 꺼내와서 조회
		List<WAIT_FES> waitFesList = fesSerevice.selectWaitFesList(host_seq);
		req.setAttribute("waitFesList", waitFesList);
		
		

		return new ModelAndView("host/myPage1.jsp");
	}
	
	//C-등록을 신청하는 것이지 fes db에 넣는 게 아니다! wait_fes db에 넣는다.! fes_state=0으로 넣는다!
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// 서비스 아이디 그냥 uuid로 뽑을게요
		UUID uuid = UUID.randomUUID();
		String SVCID = uuid.toString();

		String MAXCLASSNM = req.getParameter("MAXCLASSNM");
		String MINCLASSNM = req.getParameter("MINCLASSNM");
		String SVCSTATNM = req.getParameter("SVCSTATNM");
		String SVCNM = req.getParameter("SVCNM");
		String PAYATNM = req.getParameter("PAYATNM");
		String PLACENM = req.getParameter("PLACENM");
		String USETGTINFO = req.getParameter("USETGTINFO");
		String X = req.getParameter("X");
		String Y = req.getParameter("Y");
		String SVCOPNBGNDT = req.getParameter("SVCOPNBGNDT") + " 00:00:00";
		String SVCOPNENDDT = req.getParameter("SVCOPNENDDT") + " 00:00:00";
		String RCPTBGNDT = req.getParameter("RCPTBGNDT") + " 00:00:00";
		String AREANM = req.getParameter("AREANM");
		Part IMGURL = req.getPart("IMGURL");
		String DTLCONT = req.getParameter("DTLCONT");
		String TELNO = req.getParameter("TELNO");
		String V_MAX = req.getParameter("V_MAX");
		String V_MIN = req.getParameter("V_MIN");
		String REVSTDDAY = req.getParameter("REVSTDDAY");
		String REVSTDDAYNM = req.getParameter("REVSTDDAYNM");
		int Fes_state = 0; // 승인전
		String Update_date = ""; // sysdate
		int MAXNUM = 20;
		int PRICE = Integer.parseInt(req.getParameter("PRICE"));

		HttpSession session = req.getSession();
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("loginCom");

		int host_seq = SessionHostDTO.getHost_seq();

		String RCPTENDDT = req.getParameter("RCPTENDDT") + " 00:00:00";

		FesDTO fesDTO = new FesDTO(SVCID, MAXCLASSNM, MINCLASSNM, SVCSTATNM, SVCNM, PAYATNM, PLACENM, USETGTINFO, X, Y,
				SVCOPNBGNDT, SVCOPNENDDT, RCPTBGNDT, AREANM, "", DTLCONT, TELNO, V_MAX, V_MIN, REVSTDDAY, REVSTDDAYNM,
				Fes_state, Update_date, MAXNUM, PRICE, host_seq, RCPTENDDT);

		if (IMGURL != null) {
			String fileName = this.getFilename(IMGURL);
			System.out.println("fileName = " + fileName);
			String saveDir = req.getServletContext().getRealPath("/save");

			if (fileName != null && !fileName.equals("")) {
				IMGURL.write(saveDir + "/" + fileName);// 서버폴더에 파일 저장=업로드
				fesDTO.setIMGURL(fileName);
			}
		}
		System.out.println("날짜가 문젠가? 접수종료일시: " + RCPTENDDT);
		System.out.println("시간이 문젠가? V_MAX: " + V_MAX);
		fesSerevice.insert(fesDTO);

		String[] fes_tags = req.getParameterValues("tag_content");
		for (String fes_tag : fes_tags) {
			String tag_content = fes_tag;
			fes_tagSerevice.insert(SVCID, tag_content);		

		}

		return new ModelAndView("front?key=fes&methodName=select", true);

	}

	/**
	 * 전송된 파일정보에서 파일이름만 추출해 내는 과정
	 */
	private String getFilename(Part part) {
		String headerContent = part.getHeader("content-disposition");

		// contentDisp의 결과 form-data; name="fileName"; filename="추가한 파일 이름"
		System.out.println(headerContent);

		String[] split = headerContent.split(";");
		for (int i = 0; i < split.length; i++) {
			String temp = split[i];
			if (temp.trim().startsWith("filename")) {
				System.out.println("temp = " + temp);
				System.out.println("temp.indexOf(=) = " + temp.indexOf("="));

				return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);
			}
		}
		return null;
	}

	// 서비스등록신청보기(R) - Fes db 조회
	public ModelAndView selectBySVCID(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String SVCID = req.getParameter("SVCID");
		FesDTO fesDTO = fesSerevice.selectBySVCID(SVCID);
		if(fesDTO==null) {
			throw new SQLException("상세보기가 없습니다");
		}
		List<String> fes_tag = fes_tagSerevice.selectBySVCID(SVCID);
		req.setAttribute("fesDTO", fesDTO);
		req.setAttribute("fes_tag", fes_tag);
		
		return new ModelAndView("host/read.jsp");
	}
	// 서비스등록신청보기(R) - WAIT_FES db 조회
	public ModelAndView fesWaitselectBySVCID(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String SVCID = req.getParameter("SVCID");
		
		List<String> fes_tag = fes_tagSerevice.selectBySVCID(SVCID);

		req.setAttribute("fes_tag", fes_tag);
		
		WAIT_FES waitFes = fesSerevice.fesWaitselectBySVCID(SVCID);
		req.setAttribute("waitFes", waitFes);
		
		return new ModelAndView("host/read2.jsp");
	}

	// U - 수정폼 열기
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String SVCID = request.getParameter("SVCID");
		System.out.println("여기서의 svcid: " + SVCID);
		FesDTO fesdto = fesSerevice.selectBySVCID(SVCID);
		if(fesdto==null) {
			throw new SQLException("상세보기가 없습니다");
		}
		List<String> fes_tag = fes_tagSerevice.selectBySVCID(SVCID);
		
		request.setAttribute("fesDTO", fesdto);
		request.setAttribute("fes_tag", fes_tag);
		
		return new ModelAndView("host/update.jsp");
	}

	// U - 수정폼 제출
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		WAIT_FES waitFes = new WAIT_FES();
		
		System.out.println("1111111111111");
		String SVCID = req.getParameter("SVCID");
		System.out.println("2222 SVCID: " + SVCID);
		String MAXCLASSNM = req.getParameter("MAXCLASSNM");
		String MINCLASSNM = req.getParameter("MINCLASSNM");
		String SVCSTATNM = req.getParameter("SVCSTATNM");
		String SVCNM = req.getParameter("SVCNM");
		String PAYATNM = req.getParameter("PAYATNM");
		String PLACENM = req.getParameter("PLACENM");
		String USETGTINFO = req.getParameter("USETGTINFO");
		String X = req.getParameter("X");
		String Y = req.getParameter("Y");
		String SVCOPNBGNDT = req.getParameter("SVCOPNBGNDT");
		String SVCOPNENDDT = req.getParameter("SVCOPNENDDT");
		String RCPTBGNDT = req.getParameter("RCPTBGNDT");
		String AREANM = req.getParameter("AREANM");
		Part IMGURL = req.getPart("IMGURL");
		String DTLCONT = req.getParameter("DTLCONT");
		String TELNO = req.getParameter("TELNO");
		String V_MAX = req.getParameter("V_MAX");
		String V_MIN = req.getParameter("V_MIN");
		String REVSTDDAY = req.getParameter("REVSTDDAY");
		String REVSTDDAYNM = req.getParameter("REVSTDDAYNM");
		int Fes_state = 2; // 수정신청중
		String Update_date = ""; // sysdate
		int MAXNUM = 20;
		int PRICE = Integer.parseInt(req.getParameter("PRICE"));

		HttpSession session = req.getSession();
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("loginCom");

		int host_seq = SessionHostDTO.getHost_seq();

		String RCPTENDDT = req.getParameter("RCPTENDDT");
		
		waitFes.setWAIT_FES_SEQ(0);
		waitFes.setSVCID(SVCID);
		waitFes.setMAXCLASSNM(MAXCLASSNM);
		waitFes.setMINCLASSNM(MINCLASSNM);
		waitFes.setSVCSTATNM(SVCSTATNM);
		waitFes.setSVCNM(SVCNM);
		waitFes.setPAYATNM(PAYATNM);
		waitFes.setPLACENM(PLACENM);
		waitFes.setUSETGTINFO(USETGTINFO);
		waitFes.setX(X);
		waitFes.setY(Y);
		waitFes.setSVCOPNBGNDT(SVCOPNBGNDT);
		waitFes.setSVCOPNENDDT(SVCOPNENDDT);
		waitFes.setRCPTBGNDT(RCPTBGNDT);
		waitFes.setAREANM(AREANM);
		//IMGURL
		waitFes.setDTLCONT(DTLCONT);
		waitFes.setTELNO(TELNO);
		waitFes.setV_MAX(V_MAX);
		waitFes.setV_MIN(V_MIN);
		waitFes.setREVSTDDAY(REVSTDDAY);
		waitFes.setREVSTDDAYNM(REVSTDDAYNM);
		waitFes.setFes_state(Fes_state);
		waitFes.setUpdate_date(Update_date);
		waitFes.setMAXNUM(MAXNUM);
		waitFes.setPRICE(PRICE);
		waitFes.setHost_seq(host_seq);
		waitFes.setRCPTENDDT(RCPTENDDT);
		
		if (IMGURL != null) {
			String fileName = this.getFilename(IMGURL);
			System.out.println("fileName = " + fileName);
			String saveDir = req.getServletContext().getRealPath("/save");

			if (fileName != null && !fileName.equals("")) {
				IMGURL.write(saveDir + "/" + fileName);// 서버폴더에 파일 저장=업로드
				waitFes.setIMGURL(fileName);
			}
		}

		System.out.println("뽀삐?");

		fesSerevice.update(waitFes);
		fesSerevice.updateFes(SVCID, 2);

		System.out.println("여기까지는 오는가");

		return new ModelAndView("front?key=fes&methodName=select", true);
	}

	// D-삭제신청 FES db에 바로 값 변경
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String SVCID = req.getParameter("SVCID");

		fesSerevice.updateFes(SVCID);

		return new ModelAndView("front?key=fes&methodName=select", true);
	}
	
	//통계보기
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		System.out.println("진이 / detail Call");
		
		String svcid = req.getParameter("SVCID");
		
		//FesDTO 정보 보내기
		FesDTO fes = new FesDTO();
		fes.setSVCID(svcid);
		FesDTO searchFes = festivalService.select(fes);
		req.setAttribute("fes", searchFes);
		
		//USERsDTO 정보 보내기
		List<UsersDTO> userList =  festivalService.selectUser(fes);
		//System.out.println(userList);
		Gson g = new Gson();
		String data =g.toJson(userList);
		req.setAttribute("userList", data);
		
		//리뷰 정보 보내기
		List<ReviewDTO> reviewList =festivalService.selectReview(fes);
		data = g.toJson(reviewList);
		req.setAttribute("reviewList", data);
		req.setAttribute("reviewLength", reviewList.size());
		System.out.println("리뷰리스트:"+reviewList);
		
		//리뷰 쓴 유저 정보 보내기
		List<UsersDTO> reviewUserList = festivalService.selectReviewUser(fes);
		data = g.toJson(reviewUserList);
		req.setAttribute("reviewUserList", data);
		
		return new ModelAndView("host/myPage3.jsp");
	}
	
	//회원정보 업데이트
	public ModelAndView myPage2(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		return new ModelAndView("host/myPage2.jsp");
	}
}