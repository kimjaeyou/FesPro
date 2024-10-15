package wep.mvc.dto;

public class ReservationDTO {
	private int reservSeq; // 예약번호
	private int userSeq; // 유저시퀀
	private String SVCID; // 서비스 아이디
	private String resvDate;// 예약한 날짜
	private String svcDate; // 실제 행사일자
	private String svcTime; // 회차
	private int resvPeo; // 예약한 사람수
	private int resvPrice; // 이용요금
	private int resvCheck; // 예약상태
	
	public ReservationDTO () {
		
	}
	
	public ReservationDTO(int userSeq, String sVCID, String svcDate, String svcTime, int resvPeo,
			int resvPrice) {
		super();
		this.userSeq = userSeq;
		this.SVCID = sVCID;
		this.svcDate = svcDate;
		this.svcTime = svcTime;
		this.resvPeo = resvPeo;
		this.resvPrice = resvPrice;
	}
	
	public ReservationDTO(int reservSeq, int userSeq, String sVCID, String resvDate, String svcDate, String svcTime,
			int resvPeo, int resvPrice, int resvCheck) {
		super();
		this.reservSeq = reservSeq;
		this.userSeq = userSeq;
		this.SVCID = sVCID;
		this.resvDate = resvDate;
		this.svcDate = svcDate;
		this.svcTime = svcTime;
		this.resvPeo = resvPeo;
		this.resvPrice = resvPrice;
		this.resvCheck = resvCheck;
	}

	public int getReservSeq() {
		return reservSeq;
	}

	public void setReservSeq(int reservSeq) {
		this.reservSeq = reservSeq;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getSVCID() {
		return SVCID;
	}

	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}

	public String getResvDate() {
		return resvDate;
	}

	public void setResvDate(String resvDate) {
		this.resvDate = resvDate;
	}

	public String getSvcDate() {
		return svcDate;
	}

	public void setSvcDate(String svcDate) {
		this.svcDate = svcDate;
	}

	public String getSvcTime() {
		return svcTime;
	}

	public void setSvcTime(String svcTime) {
		this.svcTime = svcTime;
	}

	public int getResvPeo() {
		return resvPeo;
	}

	public void setResvPeo(int resvPeo) {
		this.resvPeo = resvPeo;
	}

	public int getResvPrice() {
		return resvPrice;
	}

	public void setResvPrice(int resvPrice) {
		this.resvPrice = resvPrice;
	}

	public int getResvCheck() {
		return resvCheck;
	}

	public void setResvCheck(int resvCheck) {
		this.resvCheck = resvCheck;
	}
	
	
}
