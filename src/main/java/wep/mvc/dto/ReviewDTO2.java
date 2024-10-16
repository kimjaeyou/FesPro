package wep.mvc.dto;

public class ReviewDTO2 {
	private int review_SEQ; // 리뷰 시퀀스
	private int score; // 리뷰 시퀀스
	private String svcnm; // 리뷰 시퀀스
	private String rv_Content; // 서비스 아이디
	private String sysdate;
	public ReviewDTO2(int review_SEQ, int score, String svcnm, String rv_Content, String sysdate) {
		super();
		this.review_SEQ = review_SEQ;
		this.score = score;
		this.svcnm = svcnm;
		this.rv_Content = rv_Content;
		this.sysdate = sysdate;
	}
	public int getReview_SEQ() {
		return review_SEQ;
	}
	public void setReview_SEQ(int review_SEQ) {
		this.review_SEQ = review_SEQ;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSvcnm() {
		return svcnm;
	}
	public void setSvcnm(String svcnm) {
		this.svcnm = svcnm;
	}
	public String getRv_Content() {
		return rv_Content;
	}
	public void setRv_Content(String rv_Content) {
		this.rv_Content = rv_Content;
	}
	public String getSysdate() {
		return sysdate;
	}
	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}


}
