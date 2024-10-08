package wep.mvc.dto;

public class row {
	private String GUBUN;
	private String SVCID;
	private String MAXCLASSNM;
	private String MINCLASSNM;
	private String SVCSTATNM;
	private String SVCNM;
	private String PAYATNM;
	private String PLACENM;
	private String USETGTINFO;
	private String SVCURL;
	private String X;
	private String Y;
	private String SVCOPNBGNDT;
	private String SVCOPNENDDT;
	private String RCPTBGNDT;
	private String RCPTENDDT;
	private String AREANM;
	private String IMGURL;
	private String DTLCONT;
	private String TELNO;
	private String V_MIN;
	private String V_MAX;
	private String REVSTDDAYNM;
	private String REVSTDDAY;
	private int host_seq;
	

	public int gethost_seq() {
		return host_seq;
	}
	public void sethost_seq(int host_seq) {
		this.host_seq = host_seq;
	}
	public row() {}
	public row(String gUBUN, String sVCID, String mAXCLASSNM, String mINCLASSNM, String sVCSTATNM, String sVCNM,
			String pAYATNM, String pLACENM, String uSETGTINFO, String sVCURL, String x, String y, String sVCOPNBGNDT,
			String sVCOPNENDDT, String rCPTBGNDT, String rCPTENDDT, String aREANM, String iMGURL, String dTLCONT,
			String tELNO, String v_MIN, String v_MAX, String rEVSTDDAYNM, String rEVSTDDAY,int host_seq) {
		super();
		GUBUN = gUBUN;
		SVCID = sVCID;
		MAXCLASSNM = mAXCLASSNM;
		MINCLASSNM = mINCLASSNM;
		SVCSTATNM = sVCSTATNM;
		SVCNM = sVCNM;
		PAYATNM = pAYATNM;
		PLACENM = pLACENM;
		USETGTINFO = uSETGTINFO;
		SVCURL = sVCURL;
		X = x;
		Y = y;
		SVCOPNBGNDT = sVCOPNBGNDT;
		SVCOPNENDDT = sVCOPNENDDT;
		RCPTBGNDT = rCPTBGNDT;
		RCPTENDDT = rCPTENDDT;
		AREANM = aREANM;
		IMGURL = iMGURL;
		DTLCONT = dTLCONT;
		TELNO = tELNO;
		V_MIN = v_MIN;
		V_MAX = v_MAX;
		REVSTDDAYNM = rEVSTDDAYNM;
		REVSTDDAY = rEVSTDDAY;
		this.host_seq=host_seq;
	}

	public String getGUBUN() {
		return GUBUN;
	}

	public void setGUBUN(String gUBUN) {
		GUBUN = gUBUN;
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

	public String getSVCURL() {
		return SVCURL;
	}

	public void setSVCURL(String sVCURL) {
		SVCURL = sVCURL;
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

	public String getRCPTENDDT() {
		return RCPTENDDT;
	}

	public void setRCPTENDDT(String rCPTENDDT) {
		RCPTENDDT = rCPTENDDT;
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

	public String getV_MIN() {
		return V_MIN;
	}

	public void setV_MIN(String v_MIN) {
		V_MIN = v_MIN;
	}

	public String getV_MAX() {
		return V_MAX;
	}

	public void setV_MAX(String v_MAX) {
		V_MAX = v_MAX;
	}

	public String getREVSTDDAYNM() {
		return REVSTDDAYNM;
	}

	public void setREVSTDDAYNM(String rEVSTDDAYNM) {
		REVSTDDAYNM = rEVSTDDAYNM;
	}

	public String getREVSTDDAY() {
		return REVSTDDAY;
	}

	public void setREVSTDDAY(String rEVSTDDAY) {
		REVSTDDAY = rEVSTDDAY;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("row [GUBUN=");
//		builder.append(GUBUN);
		builder.append("host_seq=");
		builder.append(host_seq);
//		builder.append(", SVCID=");
//		builder.append(SVCID);
//		builder.append(", MAXCLASSNM=");
//		builder.append(MAXCLASSNM);
//		builder.append(", MINCLASSNM=");
//		builder.append(MINCLASSNM);
//		builder.append(", SVCSTATNM=");
//		builder.append(SVCSTATNM);
//		builder.append(", SVCNM=");
//		builder.append(SVCNM);
//		builder.append(", PAYATNM=");
//		builder.append(PAYATNM);
//		builder.append(", PLACENM=");
//		builder.append(PLACENM);
//		builder.append(", USETGTINFO=");
//		builder.append(USETGTINFO);
//		builder.append(", SVCURL=");
//		builder.append(SVCURL);
//		builder.append(", X=");
//		builder.append(X);
//		builder.append(", Y=");
//		builder.append(Y);
//		builder.append(", SVCOPNBGNDT=");
//		builder.append(SVCOPNBGNDT);
//		builder.append(", SVCOPNENDDT=");
//		builder.append(SVCOPNENDDT);
//		builder.append(", RCPTBGNDT=");
//		builder.append(RCPTBGNDT);
//		builder.append(", RCPTENDDT=");
//		builder.append(RCPTENDDT);
//		builder.append(", AREANM=");
//		builder.append(AREANM);
//		builder.append(", IMGURL=");
//		builder.append(IMGURL);
//		builder.append(", DTLCONT=");
//		builder.append(DTLCONT);
//		builder.append(", TELNO=");
//		builder.append(TELNO);
//		builder.append(", V_MIN=");
//		builder.append(V_MIN);
//		builder.append(", V_MAX=");
//		builder.append(V_MAX);
//		builder.append(", REVSTDDAYNM=");
//		builder.append(REVSTDDAYNM);
//		builder.append(", REVSTDDAY=");
//		builder.append(REVSTDDAY);
//		builder.append("]");
		return builder.toString();
	}
	
	
}
