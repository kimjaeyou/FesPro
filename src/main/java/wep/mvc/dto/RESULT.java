package wep.mvc.dto;

public class RESULT {
	private String CODE;
	private String MESSAGE;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RESULT [CODE=");
		builder.append(CODE);
		builder.append(", MESSAGE=");
		builder.append(MESSAGE);
		builder.append("]");
		return builder.toString();
	}

	public RESULT() {}

	public RESULT(String cODE, String mESSAGE) {
		super();
		CODE = cODE;
		MESSAGE = mESSAGE;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}

}
