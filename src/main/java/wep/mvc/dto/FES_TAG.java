package wep.mvc.dto;

public class FES_TAG {
	private int TAG_SEQ;
	private String TAG_CONTENT;
	private String SVCID;
	
	public FES_TAG() {}
	public FES_TAG(int tAG_SEQ, String tAG_CONTENT, String sVCID) {
		super();
		TAG_SEQ = tAG_SEQ;
		TAG_CONTENT = tAG_CONTENT;
		SVCID = sVCID;
	}
	
	public int getTAG_SEQ() {
		return TAG_SEQ;
	}
	public void setTAG_SEQ(int tAG_SEQ) {
		TAG_SEQ = tAG_SEQ;
	}
	public String getTAG_CONTENT() {
		return TAG_CONTENT;
	}
	public void setTAG_CONTENT(String tAG_CONTENT) {
		TAG_CONTENT = tAG_CONTENT;
	}
	public String getSVCID() {
		return SVCID;
	}
	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}
	
}
