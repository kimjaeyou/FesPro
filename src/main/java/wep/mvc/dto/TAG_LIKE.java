package wep.mvc.dto;

public class TAG_LIKE {
	private int LIKE_SEQ;
	private int TAG_SEQ;
	private int USER_SEQ;

	public TAG_LIKE() {
	}

	public TAG_LIKE(int lIKE_SEQ, int tAG_SEQ, int uSER_SEQ) {
		super();
		LIKE_SEQ = lIKE_SEQ;
		TAG_SEQ = tAG_SEQ;
		USER_SEQ = uSER_SEQ;
	}

	public int getLIKE_SEQ() {
		return LIKE_SEQ;
	}

	public void setLIKE_SEQ(int lIKE_SEQ) {
		LIKE_SEQ = lIKE_SEQ;
	}

	public int getTAG_SEQ() {
		return TAG_SEQ;
	}

	public void setTAG_SEQ(int tAG_SEQ) {
		TAG_SEQ = tAG_SEQ;
	}

	public int getUSER_SEQ() {
		return USER_SEQ;
	}

	public void setUSER_SEQ(int uSER_SEQ) {
		USER_SEQ = uSER_SEQ;
	}

}
