package wep.mvc.dto;

public class UsersDTO {

	private String user_id;
	private String user_pw;
	private String age;
	private String addr;
	private String gender;
	private String email;
	private String user_name;
	private String disable;
	private String tel;

	public UsersDTO() {

	}

	public UsersDTO(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	public UsersDTO(String user_id, String user_pw, String age, String addr, String gender, String email,
			String user_name, String disable, String tel) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.age = age;
		this.addr = addr;
		this.gender = gender;
		this.email = email;
		this.user_name = user_name;
		this.disable = disable;
		this.tel = tel;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
