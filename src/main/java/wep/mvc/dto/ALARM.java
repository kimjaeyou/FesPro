package wep.mvc.dto;

public class ALARM {
	private int ALARM_SEQ;
	private int USER_SEQ;
	private String CONTENT;
	public int getALARM_SEQ() {
		return ALARM_SEQ;
	}
	public void setALARM_SEQ(int aLARM_SEQ) {
		ALARM_SEQ = aLARM_SEQ;
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
	public ALARM() {}
	public ALARM(int aLARM_SEQ, int uSER_SEQ, String cONTENT) {
		super();
		ALARM_SEQ = aLARM_SEQ;
		USER_SEQ = uSER_SEQ;
		CONTENT = cONTENT;
	}
	
	
}
