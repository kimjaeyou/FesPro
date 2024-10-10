package wep.mvc.dto;

public class WALLET {
	private int WALLET_SEQ;
	private int USER_SEQ;
	private int MONEY;
	private int W_POINT;
	
	public WALLET() {}
	
	public WALLET(int wALLET_SEQ, int uSER_SEQ, int mONEY, int w_POINT) {
		super();
		WALLET_SEQ = wALLET_SEQ;
		USER_SEQ = uSER_SEQ;
		MONEY = mONEY;
		W_POINT = w_POINT;
	}

	public int getWALLET_SEQ() {
		return WALLET_SEQ;
	}

	public void setWALLET_SEQ(int wALLET_SEQ) {
		WALLET_SEQ = wALLET_SEQ;
	}

	public int getUSER_SEQ() {
		return USER_SEQ;
	}

	public void setUSER_SEQ(int uSER_SEQ) {
		USER_SEQ = uSER_SEQ;
	}

	public int getMONEY() {
		return MONEY;
	}

	public void setMONEY(int mONEY) {
		MONEY = mONEY;
	}

	public int getW_POINT() {
		return W_POINT;
	}

	public void setW_POINT(int w_POINT) {
		W_POINT = w_POINT;
	}
	
	
	
}
