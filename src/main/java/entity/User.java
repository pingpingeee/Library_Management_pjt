package entity;

public class User {
	private int u_number; // 유저 고유번호
	private String u_id; // 유저 아이디
	private String u_pw; // 유저 비번
	private String u_name; // 유저 이름
	private String u_email; // 유저 이메일
	private int u_borrow; // 유저가 최대 빌릴 수 있는 수 (3권)
	private Boolean u_admin; // 유저 관리자확인 1,0
	private String u_regdate; // 유저 회원가입날짜
	public int getU_number() {
		return u_number;
	}
	public void setU_number(int u_number) {
		this.u_number = u_number;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getU_borrow() {
		return u_borrow;
	}
	public void setU_borrow(int u_borrow) {
		this.u_borrow = u_borrow;
	}
	public Boolean getU_admin() {
		return u_admin;
	}
	public void setU_admin(Boolean u_admin) {
		this.u_admin = u_admin;
	}
	public String getU_regdate() {
		return u_regdate;
	}
	public void setU_regdate(String u_regdate) {
		this.u_regdate = u_regdate;
	}

	
}
