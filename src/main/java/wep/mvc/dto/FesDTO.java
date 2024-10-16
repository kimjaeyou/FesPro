package wep.mvc.dto;

public class FesDTO {

		private String	SVCID; //서비스 아이디
		private String	MAXCLASSNM; //대분류명
		private String	MINCLASSNM; //소분류명
		private String	SVCSTATNM; //서비스상태
		private String	SVCNM; //서비스명
		private String	PAYATNM; //결제방법
		private String	PLACENM; //장소명
		private String	USETGTINFO; //서비스대상
		private String	X; //장소x좌표
		private String	Y; //장소y좌표
		private String	SVCOPNBGNDT; //서비스개시시작일시
		private String	SVCOPNENDDT; //서비스개시종료일시
		private String	RCPTBGNDT; //접수시작일시
		private String	AREANM; //지역명
		private String	IMGURL; //이미지경로
		private String	DTLCONT; //상세내용
		private String	TELNO; //전화번호
		private String	V_MAX; //서비스이용 종료시간
		private String	V_MIN; //서비스이용 시작시간
		private String	REVSTDDAY; //취소기간 기준일까지
		private String	REVSTDDAYNM; //취소기간 기준정보
		private int Fes_state; //등록신청 정보(승인전, 승인완료, ...)
		private String Update_date; //등록신청or수정신청 일시
		private int	MAXNUM; //최대 인원수
		private int	PRICE; //가격
		private int	host_seq; //주최자 sequence
		private String RCPTENDDT; //접수종료일시
		
		public FesDTO() {}
		
		

		public FesDTO(String sVCID, String mAXCLASSNM, String mINCLASSNM, String sVCSTATNM, String sVCNM,
				String pAYATNM, String pLACENM, String uSETGTINFO, String x, String y, String sVCOPNBGNDT,
				String sVCOPNENDDT, String rCPTBGNDT, String aREANM, String iMGURL, String dTLCONT, String tELNO,
				String v_MAX, String v_MIN, String rEVSTDDAY, String rEVSTDDAYNM, int fes_state, String update_date,
				int mAXNUM, int pRICE, int host_seq) {
			super();
			SVCID = sVCID;
			MAXCLASSNM = mAXCLASSNM;
			MINCLASSNM = mINCLASSNM;
			SVCSTATNM = sVCSTATNM;
			SVCNM = sVCNM;
			PAYATNM = pAYATNM;
			PLACENM = pLACENM;
			USETGTINFO = uSETGTINFO;
			X = x;
			Y = y;
			SVCOPNBGNDT = sVCOPNBGNDT;
			SVCOPNENDDT = sVCOPNENDDT;
			RCPTBGNDT = rCPTBGNDT;
			AREANM = aREANM;
			IMGURL = iMGURL;
			DTLCONT = dTLCONT;
			TELNO = tELNO;
			V_MAX = v_MAX;
			V_MIN = v_MIN;
			REVSTDDAY = rEVSTDDAY;
			REVSTDDAYNM = rEVSTDDAYNM;
			Fes_state = fes_state;
			Update_date = update_date;
			MAXNUM = mAXNUM;
			PRICE = pRICE;
			this.host_seq = host_seq;
		}



		public FesDTO(String sVCID, String mAXCLASSNM, String mINCLASSNM, String sVCSTATNM, String sVCNM,
				String pAYATNM, String pLACENM, String uSETGTINFO, String x, String y, String sVCOPNBGNDT,
				String sVCOPNENDDT, String rCPTBGNDT, String aREANM, String iMGURL, String dTLCONT, String tELNO,
				String v_MAX, String v_MIN, String rEVSTDDAY, String rEVSTDDAYNM, int fes_state, String update_date,
				int mAXNUM, int pRICE, int host_seq, String rCPTENDDT) {
			super();
			SVCID = sVCID;
			MAXCLASSNM = mAXCLASSNM;
			MINCLASSNM = mINCLASSNM;
			SVCSTATNM = sVCSTATNM;
			SVCNM = sVCNM;
			PAYATNM = pAYATNM;
			PLACENM = pLACENM;
			USETGTINFO = uSETGTINFO;
			X = x;
			Y = y;
			SVCOPNBGNDT = sVCOPNBGNDT;
			SVCOPNENDDT = sVCOPNENDDT;
			RCPTBGNDT = rCPTBGNDT;
			AREANM = aREANM;
			IMGURL = iMGURL;
			DTLCONT = dTLCONT;
			TELNO = tELNO;
			V_MAX = v_MAX;
			V_MIN = v_MIN;
			REVSTDDAY = rEVSTDDAY;
			REVSTDDAYNM = rEVSTDDAYNM;
			Fes_state = fes_state;
			Update_date = update_date;
			MAXNUM = mAXNUM;
			PRICE = pRICE;
			this.host_seq = host_seq;
			RCPTENDDT = rCPTENDDT;
		}
		// 윤성이가 추가한 생성자
		public FesDTO(String SVCID, String SVCNM, String PLACENM, String RCPTBGNDT, String RCPTENDDT, String SVCOPNBGNDT,
				String SVCOPNENDDT, String V_MAX, String V_MIN, int PRICE, String SVCSTATNM) {
			super();
			this.SVCID = SVCID;
			this.SVCNM = SVCNM;
			this.PLACENM = PLACENM;
			this.RCPTBGNDT = RCPTBGNDT;
			this.RCPTENDDT = RCPTENDDT;
			this.SVCOPNBGNDT = SVCOPNBGNDT;
			this.SVCOPNENDDT = SVCOPNENDDT;
			this.V_MAX = V_MAX;
			this.V_MIN = V_MIN;
			this.PRICE = PRICE;
			this.SVCSTATNM = SVCSTATNM;
		}
		public String getSVCID() {
			return SVCID;
		}

		public void setSVCID(String sVCID) {
			SVCID = sVCID;
		}

		public String getMAXCLASSNM() {
			return MAXCLASSNM;
		}

		public void setMAXCLASSNM(String mAXCLASSNM) {
			MAXCLASSNM = mAXCLASSNM;
		}

		public String getMINCLASSNM() {
			return MINCLASSNM;
		}

		public void setMINCLASSNM(String mINCLASSNM) {
			MINCLASSNM = mINCLASSNM;
		}

		public String getSVCSTATNM() {
			return SVCSTATNM;
		}

		public void setSVCSTATNM(String sVCSTATNM) {
			SVCSTATNM = sVCSTATNM;
		}

		public String getSVCNM() {
			return SVCNM;
		}

		public void setSVCNM(String sVCNM) {
			SVCNM = sVCNM;
		}

		public String getPAYATNM() {
			return PAYATNM;
		}

		public void setPAYATNM(String pAYATNM) {
			PAYATNM = pAYATNM;
		}

		public String getPLACENM() {
			return PLACENM;
		}

		public void setPLACENM(String pLACENM) {
			PLACENM = pLACENM;
		}

		public String getUSETGTINFO() {
			return USETGTINFO;
		}

		public void setUSETGTINFO(String uSETGTINFO) {
			USETGTINFO = uSETGTINFO;
		}

		public String getX() {
			return X;
		}

		public void setX(String x) {
			X = x;
		}

		public String getY() {
			return Y;
		}

		public void setY(String y) {
			Y = y;
		}

		public String getSVCOPNBGNDT() {
			return SVCOPNBGNDT;
		}

		public void setSVCOPNBGNDT(String sVCOPNBGNDT) {
			SVCOPNBGNDT = sVCOPNBGNDT;
		}

		public String getSVCOPNENDDT() {
			return SVCOPNENDDT;
		}

		public void setSVCOPNENDDT(String sVCOPNENDDT) {
			SVCOPNENDDT = sVCOPNENDDT;
		}

		public String getRCPTBGNDT() {
			return RCPTBGNDT;
		}

		public void setRCPTBGNDT(String rCPTBGNDT) {
			RCPTBGNDT = rCPTBGNDT;
		}

		public String getAREANM() {
			return AREANM;
		}

		public void setAREANM(String aREANM) {
			AREANM = aREANM;
		}

		public String getIMGURL() {
			return IMGURL;
		}

		public void setIMGURL(String iMGURL) {
			IMGURL = iMGURL;
		}

		public String getDTLCONT() {
			return DTLCONT;
		}

		public void setDTLCONT(String dTLCONT) {
			DTLCONT = dTLCONT;
		}

		public String getTELNO() {
			return TELNO;
		}

		public void setTELNO(String tELNO) {
			TELNO = tELNO;
		}

		public String getV_MAX() {
			return V_MAX;
		}

		public void setV_MAX(String v_MAX) {
			V_MAX = v_MAX;
		}

		public String getV_MIN() {
			return V_MIN;
		}

		public void setV_MIN(String v_MIN) {
			V_MIN = v_MIN;
		}

		public String getREVSTDDAY() {
			return REVSTDDAY;
		}

		public void setREVSTDDAY(String rEVSTDDAY) {
			REVSTDDAY = rEVSTDDAY;
		}

		public String getREVSTDDAYNM() {
			return REVSTDDAYNM;
		}

		public void setREVSTDDAYNM(String rEVSTDDAYNM) {
			REVSTDDAYNM = rEVSTDDAYNM;
		}

		public int getFes_state() {
			return Fes_state;
		}

		public void setFes_state(int fes_state) {
			Fes_state = fes_state;
		}

		public String getUpdate_date() {
			return Update_date;
		}

		public void setUpdate_date(String update_date) {
			Update_date = update_date;
		}

		public int getMAXNUM() {
			return MAXNUM;
		}

		public void setMAXNUM(int mAXNUM) {
			MAXNUM = mAXNUM;
		}

		public int getPRICE() {
			return PRICE;
		}

		public void setPRICE(int pRICE) {
			PRICE = pRICE;
		}

		public int getHost_seq() {
			return host_seq;
		}

		public void setHost_seq(int host_seq) {
			this.host_seq = host_seq;
		}

		public String getRCPTENDDT() {
			return RCPTENDDT;
		}

		public void setRCPTENDDT(String rCPTENDDT) {
			RCPTENDDT = rCPTENDDT;
		}
		
		
}