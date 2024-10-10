package wep.mvc.dto;

public class HostDTO {
	private String host_id;
	private String host_pw;
	private String host_tel;
	private String host_name;
	private String rep_name;

	public HostDTO() {

	}

	public HostDTO(String host_id, String host_pw) {
		this.host_id = host_id;
		this.host_pw = host_pw;
	}

	public HostDTO(String host_id, String host_pw, String host_tel, String host_name, String rep_name) {
		super();
		this.host_id = host_id;
		this.host_pw = host_pw;
		this.host_tel = host_tel;
		this.host_name = host_name;
		this.rep_name = rep_name;
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

	public String getRep_name() {
		return rep_name;
	}

	public void setRep_name(String rep_name) {
		this.rep_name = rep_name;
	}

}
