package wep.mvc.dto;

public class HostDTO {

	private int host_seq;
	private String host_id; // 대표자명
	private String com_name; // 기업명
	private String host_pw; // 비번
	private String host_tel; //전번
	private String host_name; // 대표자명
	private int host_check; // 승인여부
	private String rep_name; // 가입자명
	private int host_ben_check; // 밴

	public HostDTO() {

	}

	//로그인
	public HostDTO(String host_id, String host_pw) {
		this.host_id = host_id;
		this.host_pw = host_pw;
	}

	//회원가입

	public String getCom_name() {
		return com_name;
	}

	public HostDTO(String host_id,String host_pw, String host_tel, String host_name , String rep_name , String com_name) {
		this.host_id = host_id;
		this.com_name = com_name;
		this.host_pw = host_pw;
		this.host_tel = host_tel;
		this.host_name = host_name;
		this.rep_name = rep_name;
	}

	
	public HostDTO(int host_seq, String host_id, String com_name, String host_pw, String host_tel, String host_name,
			int host_check, String rep_name, int host_ben_check) {
		super();
		this.host_seq = host_seq;
		this.host_id = host_id;
		this.com_name = com_name;
		this.host_pw = host_pw;
		this.host_tel = host_tel;
		this.host_name = host_name;
		this.host_check = host_check;
		this.rep_name = rep_name;
		this.host_ben_check = host_ben_check;
	}

	public HostDTO(String host_id, String com_name, String host_pw, String host_tel, String host_name, int host_check,
			String rep_name, int host_ben_check) {
		this.host_id = host_id;
		this.com_name = com_name;
		this.host_pw = host_pw;
		this.host_tel = host_tel;
		this.host_name = host_name;
		this.host_check = host_check;
		this.rep_name = rep_name;
		this.host_ben_check = host_ben_check;
	}

	public int getHost_seq() {
		return host_seq;
	}

	public void setHost_seq(int host_seq) {
		this.host_seq = host_seq;
	}

	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}

	public String getHost_pw() {
		return host_pw;
	}

	public void setHost_pw(String host_pw) {
		this.host_pw = host_pw;
	}

	public String getHost_tel() {
		return host_tel;
	}

	public void setHost_tel(String host_tel) {
		this.host_tel = host_tel;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public int getHost_check() {
		return host_check;
	}

	public void setHost_check(int host_check) {
		this.host_check = host_check;
	}

	public String getRep_name() {
		return rep_name;
	}

	public void setRep_name(String rep_name) {
		this.rep_name = rep_name;
	}

	public int getHost_ben_check() {
		return host_ben_check;
	}

	public void setHost_ben_check(int host_ben_check) {
		this.host_ben_check = host_ben_check;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}


}
