package wep.mvc.dto;

public class ReservationDTO {
	private int reserv_seq;
	private int user_seq;
	private String SVCID; 
	private String resv_date; 
	private String svc_date;
	private String svc_time;
	private int resv_peo;
	private int resv_price;
	private int resv_check;
	
	public ReservationDTO () {
		
	}
	
	public ReservationDTO(int reserv_seq, int user_seq, String sVCID, String svc_date, String svc_time, int resv_peo,
			int resv_price) {
		super();
		this.reserv_seq = reserv_seq;
		this.user_seq = user_seq;
		SVCID = sVCID;
		this.svc_date = svc_date;
		this.svc_time = svc_time;
		this.resv_peo = resv_peo;
		this.resv_price = resv_price;
	}
	
	public ReservationDTO(int reserv_seq, int user_seq, String sVCID, String resv_date, String svc_date, String svc_time,
			int resv_peo, int resv_price, int resv_check) {
		super();
		this.reserv_seq = reserv_seq;
		this.user_seq = user_seq;
		SVCID = sVCID;
		this.resv_date = resv_date;
		this.svc_date = svc_date;
		this.svc_time = svc_time;
		this.resv_peo = resv_peo;
		this.resv_price = resv_price;
		this.resv_check = resv_check;
	}
	
	public int getReserv_seq() {
		return reserv_seq;
	}
	
	public void setReserv_seq(int reserv_seq) {
		this.reserv_seq = reserv_seq;
	}
	
	public int getUser_seq() {
		return user_seq;
	}
	
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	
	public String getSVCID() {
		return SVCID;
	}
	
	public void setSVCID(String sVCID) {
		SVCID = sVCID;
	}
	
	public String getResv_date() {
		return resv_date;
	}
	
	public void setResv_date(String resv_date) {
		this.resv_date = resv_date;
	}
	
	public String getSvc_date() {
		return svc_date;
	}
	
	public void setSvc_date(String svc_date) {
		this.svc_date = svc_date;
	}
	
	public String getSvc_time() {
		return svc_time;
	}
	
	public void setSvc_time(String svc_time) {
		this.svc_time = svc_time;
	}
	
	public int getResv_peo() {
		return resv_peo;
	}
	
	public void setResv_peo(int resv_peo) {
		this.resv_peo = resv_peo;
	}
	
	public int getResv_price() {
		return resv_price;
	}
	
	public void setResv_price(int resv_price) {
		this.resv_price = resv_price;
	}
	
	public int getResv_check() {
		return resv_check;
	}
	
	public void setResv_check(int resv_check) {
		this.resv_check = resv_check;
	}
	
	
}
