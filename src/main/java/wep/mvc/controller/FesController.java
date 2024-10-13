package wep.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

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
import wep.mvc.service.FesSerevice;
import wep.mvc.service.FesSereviceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*10
)
public class FesController implements Controller {
	private FesSerevice fesSerevice = new FesSereviceImpl();
	
	//등록 신청(C)
	public ModelAndView send(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("index.jsp", true);
	}
	//등록 신청을 취소/게시글 삭제(D)
	public ModelAndView cancle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		return new ModelAndView("index.jsp", true);
	}
	///////////////////////////////////////////////////////////////////////////////////여기는 건들지 않는다...! //행사 리스트 띄우는 기능
	public ModelAndView read(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		ServletContext app= req.getServletContext();
		ListPublicReservationCulture list= (ListPublicReservationCulture)app.getAttribute("fesList");
		req.setAttribute("list", list);
		return new ModelAndView("fes/list.jsp");
	}
	///////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 전체검색
	 * */
	public ModelAndView select(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//List<FesDTO> fesDTOList = fesSerevice.selectAll();
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("logincom")==null) { //기업회원으로 로그인 되어있는지 확인
			System.out.println("로그인 안했지롱"); 
			return new ModelAndView("User/login.jsp"); //로그인 페이지로 보낼 것
		}
		
		//기업회원으로 로그인 되어있다면 해당 기업회원 세션에 해당하는 fesDTO만 DB에서 꺼내서 보여줘야지.
		//ServletContext app = req.getServletContext();
		//List<FesDTO> fesDTOList= (List<FesDTO>)app.getAttribute("fesList");
		
		//req.setAttribute("fesDTOList", fesDTOList);
		
		//req.setAttribute("fesDTOList", fesDTOList);
		
		System.out.println("여기");
		
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("logincom");
		
		int host_seq = SessionHostDTO.getHost_seq();
		
		List<FesDTO> fesDTOList = fesSerevice.select(host_seq);
		req.setAttribute("fesDTOList", fesDTOList);
		
		return new ModelAndView("host/myPage1.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse resp) throws Exception{
				
		//서비스 아이디 그냥 uuid로 뽑을게요
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
		int Fes_state = 0; //승인전
		String Update_date = ""; //sysdate
		int MAXNUM = 20;
		int PRICE = Integer.parseInt(req.getParameter("PRICE"));
		
		HttpSession session = req.getSession();
		HostDTO SessionHostDTO = (HostDTO) session.getAttribute("logincom");
		
		int host_seq = SessionHostDTO.getHost_seq();
		
 		String RCPTENDDT = req.getParameter("RCPTENDDT");
 		
 		FesDTO fesDTO = new FesDTO(SVCID, MAXCLASSNM, MINCLASSNM, SVCSTATNM, SVCNM, PAYATNM, PLACENM, USETGTINFO, X, Y,
 								   SVCOPNBGNDT, SVCOPNENDDT, RCPTBGNDT, AREANM, "", DTLCONT, TELNO, V_MAX, V_MIN,
 								   REVSTDDAY, REVSTDDAYNM, Fes_state, Update_date, MAXNUM, PRICE, host_seq, RCPTENDDT);
		
		if(IMGURL != null) {
			String fileName = this.getFilename(IMGURL);
			System.out.println("fileName = " + fileName);
			String saveDir = req.getServletContext().getRealPath("/save");
			
			if(fileName!=null && !fileName.equals("")) {
				 IMGURL.write( saveDir + "/"+ fileName);//서버폴더에 파일 저장=업로드
		         fesDTO.setIMGURL(fileName);
			}
		}
		System.out.println("날짜가 문젠가? 접수종료일시: "+RCPTENDDT);
		System.out.println("시간이 문젠가? V_MAX: "+V_MAX);
		fesSerevice.insert(fesDTO);
		
		return new ModelAndView("front?key=fes&methodName=select", true);

	}
	
	/**
	 * 전송된 파일정보에서 파일이름만 추출해 내는 과정 
	 * */
	private String getFilename(Part part) {
        String headerContent = part.getHeader("content-disposition");
        
        //contentDisp의 결과 form-data; name="fileName"; filename="추가한 파일 이름"
        System.out.println(headerContent);
        
        String[] split = headerContent.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.trim().startsWith("filename")) {
            	System.out.println("temp = " + temp);
            	System.out.println("temp.indexOf(=) = " + temp.indexOf("=") );
            	
                return temp.substring( temp.indexOf("=") + 2 ,  temp.length() - 1);
            }
        }
        return null;
    }
}
