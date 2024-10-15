package wep.mvc.dto;

public class WAIT_FES extends FesDTO{
		
	private int  WAIT_FES_SEQ; //시퀀스, pk
	
	public WAIT_FES() {}

	public WAIT_FES(int wAIT_FES_SEQ) {
		super();
		WAIT_FES_SEQ = wAIT_FES_SEQ;
	}
	
	public int getWAIT_FES_SEQ() {
		return WAIT_FES_SEQ;
	}

	public void setWAIT_FES_SEQ(int wAIT_FES_SEQ) {
		WAIT_FES_SEQ = wAIT_FES_SEQ;
	}
	
	
	
}
