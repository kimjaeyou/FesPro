package wep.mvc.dto;

public class ReviewDTO {
	private int REVIEW_SEQ;
	private int USER_SEQ;
	private String SVCID;
	private String RV_CONTENT;
	private int SCORE;
	
	public ReviewDTO() {}

	public ReviewDTO(int rEVIEW_SEQ, int uSER_SEQ, String sVCID, String rV_CONTENT, int sCORE) {
		super();
		REVIEW_SEQ = rEVIEW_SEQ;
		USER_SEQ = uSER_SEQ;
		SVCID = sVCID;
		RV_CONTENT = rV_CONTENT;
		SCORE = sCORE;
	}

	public int getREVIEW_SEQ() {
		return REVIEW_SEQ;
	}

	public void setREVIEW_SEQ(int rEVIEW_SEQ) {
		REVIEW_SEQ = rEVIEW_SEQ;
	}

	public int getUSER_SEQ() {
		return USER_SEQ;
	}

	public void setUSER_SEQ(int uSER_SEQ) {
		USER_SEQ = uSER_SEQ;
	}

	public String getSVCID() {
		return SVCID;
	}

	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}

	public String getRV_CONTENT() {
		return RV_CONTENT;
	}

	public void setRV_CONTENT(String rV_CONTENT) {
		RV_CONTENT = rV_CONTENT;
	}

	public int getSCORE() {
		return SCORE;
	}

	public void setSCORE(int sCORE) {
		SCORE = sCORE;
	}

	
	
}