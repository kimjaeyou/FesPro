package wep.mvc.dto;

public class ReservationDTO2 {
	private int reserv_Seq; // 예약번호
	private String svcnm; // 서비스명
	private String svc_Time; // 회차
	private String svc_Date; // 실제 행사일자
	private String resv_Date;// 예약한 날짜
	private int resv_Price; // 이용요금
	private int resv_Check; // 예약상태
	private String SVCID; // 서비스 아이디
	private int resvPeo; // 예약한 사람수
	private int userSeq; // 유저시퀀

	public ReservationDTO2() {

	}

	public ReservationDTO2(int reserv_Seq, String svcnm, String svc_Time, String svc_Date, String resv_Date,
			int resv_Price, int resv_Check, String sVCID, int resvPeo, int userSeq) {
		super();
		this.reserv_Seq = reserv_Seq;
		this.svcnm = svcnm;
		this.svc_Time = svc_Time;
		this.svc_Date = svc_Date;
		this.resv_Date = resv_Date;
		this.resv_Price = resv_Price;
		this.resv_Check = resv_Check;
		this.SVCID = sVCID;
		this.resvPeo = resvPeo;
		this.userSeq = userSeq;
	}

	public ReservationDTO2(int reserv_Seq, String svcnm, String svc_Time, String svc_Date, String resv_Date,
			int resv_Price, int resv_Check) {
		super();
		this.reserv_Seq = reserv_Seq;
		this.svcnm = svcnm;
		this.svc_Time = svc_Time;
		this.svc_Date = svc_Date;
		this.resv_Date = resv_Date;
		this.resv_Price = resv_Price;
		this.resv_Check = resv_Check;
	}

	
	public ReservationDTO2(int reserv_Seq, String svcnm, String svc_Time, String svc_Date, String resv_Date,
			int resv_Price, int resv_Check, String sVCID) {
		super();
		this.reserv_Seq = reserv_Seq;
		this.svcnm = svcnm;
		this.svc_Time = svc_Time;
		this.svc_Date = svc_Date;
		this.resv_Date = resv_Date;
		this.resv_Price = resv_Price;
		this.resv_Check = resv_Check;
		this.SVCID = sVCID;
	}

	public int getReserv_Seq() {
		return reserv_Seq;
	}

	public void setReserv_Seq(int reserv_Seq) {
		this.reserv_Seq = reserv_Seq;
	}

	public String getSvcnm() {
		return svcnm;
	}

	public void setSvcnm(String svcnm) {
		this.svcnm = svcnm;
	}

	public String getSvc_Time() {
		return svc_Time;
	}

	public void setSvc_Time(String svc_Time) {
		this.svc_Time = svc_Time;
	}

	public String getSvc_Date() {
		return svc_Date;
	}

	public void setSvc_Date(String svc_Date) {
		this.svc_Date = svc_Date;
	}

	public String getResv_Date() {
		return resv_Date;
	}

	public void setResv_Date(String resv_Date) {
		this.resv_Date = resv_Date;
	}

	public String getSVCID() {
		return SVCID;
	}

	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}

	public int getResv_Price() {
		return resv_Price;
	}

	public void setResv_Price(int resv_Price) {
		this.resv_Price = resv_Price;
	}

	public int getResv_Check() {
		return resv_Check;
	}

	public void setResv_Check(int resv_Check) {
		this.resv_Check = resv_Check;
	}

	public int getResvPeo() {
		return resvPeo;
	}

	public void setResvPeo(int resvPeo) {
		this.resvPeo = resvPeo;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

}
