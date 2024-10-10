package wep.mvc.dto;

public class REVIEW {
	private int REVIEW_SEQ;
	private int USER_SEQ;
	private String SVCID;
	private String RV_CONTENT;
	private int SCORE;
	
	public REVIEW() {}

	public REVIEW(int REVIEW_SEQ, int USER_SEQ, String SVCID, String RV_CONTENT, int SCORE) {
		super();
		REVIEW_SEQ = REVIEW_SEQ;
		USER_SEQ = USER_SEQ;
		SVCID = SVCID;
		RV_CONTENT = RV_CONTENT;
		SCORE = SCORE;
	}

	public int getREVIEW_SEQ() {
		return REVIEW_SEQ;
	}

	public void setREVIEW_SEQ(int REVIEW_SEQ) {
		REVIEW_SEQ = REVIEW_SEQ;
	}

	public int getUSER_SEQ() {
		return USER_SEQ;
	}

	public void setUSER_SEQ(int USER_SEQ) {
		USER_SEQ = USER_SEQ;
	}

	public String getSVCID() {
		return SVCID;
	}

	public void setSVCID(String SVCID) {
		SVCID = SVCID;
	}

	public String getRV_CONTENT() {
		return RV_CONTENT;
	}

	public void setRV_CONTENT(String RV_CONTENT) {
		RV_CONTENT = RV_CONTENT;
	}

	public int getSCORE() {
		return SCORE;
	}

	public void setSCORE(int SCORE) {
		SCORE = SCORE;
	}
	
	
	
}
