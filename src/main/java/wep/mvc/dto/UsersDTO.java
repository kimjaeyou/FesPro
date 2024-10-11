package wep.mvc.dto;

public class UsersDTO {

	private int user_seq;
	private String user_id;
	private String user_pw;
	private int age;
	private String addr;
	private int gender;
	private String email;
	private String user_name;
	private int disable;
	private String user_tel;

	public UsersDTO() {

	}


	public UsersDTO(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	public UsersDTO(int user_seq, String user_id, String user_pw, int age, String addr, int gender, String email,
			String user_name, int disable, String user_tel) {

		super();
		this.user_seq = user_seq;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.age = age;
		this.addr = addr;
		this.gender = gender;
		this.email = email;
		this.user_name = user_name;
		this.disable = disable;
		this.user_tel = user_tel;
	}
	
	//회원수정
	public UsersDTO( String user_pw, int age, String addr, int gender, String email,
			String user_name, int disable, String user_tel) {
		super();
		this.user_pw = user_pw;
		this.age = age;
		this.addr = addr;
		this.gender = gender;
		this.email = email;
		this.user_name = user_name;
		this.disable = disable;
		this.user_tel = user_tel; 
	}
	
	//회원가입
	public UsersDTO(String user_id, String user_pw, int age, String addr, int gender, String email,
			String user_name, int disable, String user_tel) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.age = age;
		this.addr = addr;
		this.gender = gender;
		this.email = email;
		this.user_name = user_name;
		this.disable = disable;
		this.user_tel = user_tel;
	}


	public int getUser_seq() {
		return user_seq;
	}


	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
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


	public int getDisable() {
		return disable;
	}


	public void setDisable(int disable) {
		this.disable = disable;
	}


	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	


}
