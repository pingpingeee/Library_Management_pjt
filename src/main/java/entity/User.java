package entity;

public class User {
	private int userNumber; // 유저 고유번호
	private String userId; // 유저 아이디
	private String userPw; // 유저 비번
	private String userName; // 유저 이름
	private String userEmail; // 유저 이메일
	private String userTel; // 유저 전번
	private String userBirth; // 유저 생일
	private String userAddress; // 유저 주소
	private int userBorrow; // 유저가 최대 빌릴 수 있는 수 (3권)
	private Boolean userAdmin; // 유저 관리자확인 1,0
	private String userRegdate; // 유저 회원가입날짜

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserBorrow() {
		return userBorrow;
	}

	public void setUserBorrow(int userBorrow) {
		this.userBorrow = userBorrow;
	}

	public Boolean getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(Boolean userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

}
