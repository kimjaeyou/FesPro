package wep.mvc.dto;

public class ADJUSTMENT {
	private int ADJ_SEQ;
	private int HOST_SEQ;
	private String SVCID;
	private int TOTAL;
	
	public ADJUSTMENT() {}
	public ADJUSTMENT(int aDJ_SEQ, int hOST_SEQ, String sVCID, int tOTAL) {
		super();
		ADJ_SEQ = aDJ_SEQ;
		HOST_SEQ = hOST_SEQ;
		SVCID = sVCID;
		TOTAL = tOTAL;
	}
	public int getADJ_SEQ() {
		return ADJ_SEQ;
	}
	public void setADJ_SEQ(int aDJ_SEQ) {
		ADJ_SEQ = aDJ_SEQ;
	}
	public int getHOST_SEQ() {
		return HOST_SEQ;
	}
	public void setHOST_SEQ(int hOST_SEQ) {
		HOST_SEQ = hOST_SEQ;
	}
	public String getSVCID() {
		return SVCID;
	}
	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}
	public int getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(int tOTAL) {
		TOTAL = tOTAL;
	}
	
}
