package wep.mvc.dto;

public class MESSAGE {
	private int MESSAGE_SEQ;
	private int HOST_SEQ;
	private int USER_SEQ;
	private String CONTENT;
	private String MESSAGE_DATE;
	private String MESSAGE_CATEGORY;
	
	MESSAGE(){}
	public MESSAGE(int mESSAGE_SEQ, int hOST_SEQ, int uSER_SEQ, String cONTENT, String mESSAGE_DATE,
			String mESSAGE_CATEGORY) {
		super();
		MESSAGE_SEQ = mESSAGE_SEQ;
		HOST_SEQ = hOST_SEQ;
		USER_SEQ = uSER_SEQ;
		CONTENT = cONTENT;
		MESSAGE_DATE = mESSAGE_DATE;
		MESSAGE_CATEGORY = mESSAGE_CATEGORY;
	}
	
	public int getMESSAGE_SEQ() {
		return MESSAGE_SEQ;
	}
	public void setMESSAGE_SEQ(int mESSAGE_SEQ) {
		MESSAGE_SEQ = mESSAGE_SEQ;
	}
	public int getHOST_SEQ() {
		return HOST_SEQ;
	}
	public void setHOST_SEQ(int hOST_SEQ) {
		HOST_SEQ = hOST_SEQ;
	}
	public int getUSER_SEQ() {
		return USER_SEQ;
	}
	public void setUSER_SEQ(int uSER_SEQ) {
		USER_SEQ = uSER_SEQ;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getMESSAGE_DATE() {
		return MESSAGE_DATE;
	}
	public void setMESSAGE_DATE(String mESSAGE_DATE) {
		MESSAGE_DATE = mESSAGE_DATE;
	}
	public String getMESSAGE_CATEGORY() {
		return MESSAGE_CATEGORY;
	}
	public void setMESSAGE_CATEGORY(String mESSAGE_CATEGORY) {
		MESSAGE_CATEGORY = mESSAGE_CATEGORY;
	}
	
	
}
