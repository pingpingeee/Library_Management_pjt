package entity;

public class User {
	private int userNumber; 
	private String userId; 
	private String userPw; 
	private String userName; 
	private String userEmail; 
	private String userTel; 
	private String userBirth; 
	private String userAddress;
	private int userBorrow; 
	private int userAdmin; 
	private String userRegdate;
	private boolean remeberId; // 아이디기억할래용?
	
	

	public boolean isRemeberId() {
		return remeberId;
	}

	public void setRemeberId(boolean remeberId) {
		this.remeberId = remeberId;
	}

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

	public int getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(int userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

}
