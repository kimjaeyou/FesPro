package wep.mvc.dto;

public class USER_LIKE {
	private int LIKE_SEQ;
	private String SVCID;
	private int USER_SEQ;
	
	public USER_LIKE() {}
	public USER_LIKE(int lIKE_SEQ, String sVCID, int uSER_SEQ) {
		super();
		LIKE_SEQ = lIKE_SEQ;
		SVCID = sVCID;
		USER_SEQ = uSER_SEQ;
	}
	
	public int getLIKE_SEQ() {
		return LIKE_SEQ;
	}
	public void setLIKE_SEQ(int lIKE_SEQ) {
		LIKE_SEQ = lIKE_SEQ;
	}
	public String getSVCID() {
		return SVCID;
	}
	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}
	public int getUSER_SEQ() {
		return USER_SEQ;
	}
	public void setUSER_SEQ(int uSER_SEQ) {
		USER_SEQ = uSER_SEQ;
	}
	
	
}