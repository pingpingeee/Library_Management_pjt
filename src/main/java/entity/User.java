package entity;

public class User {
	private int userNumber; // �쑀�� 怨좎쑀踰덊샇
	private String userId; // �쑀�� �븘�씠�뵒
	private String userPw; // �쑀�� 鍮꾨쾲
	private String userName; // �쑀�� �씠由�
	private String userEmail; // �쑀�� �씠硫붿씪
	private String userTel; // �쑀�� �쟾踰�
	private String userBirth; // �쑀�� �깮�씪
	private String userAddress; // �쑀�� 二쇱냼
	private int userBorrow; // �쑀��媛� 理쒕� 鍮뚮┫ �닔 �엳�뒗 �닔 (3沅�)
	private int userAdmin; // �쑀�� 愿�由ъ옄�솗�씤 1,0
	private String userRegdate; // �쑀�� �쉶�썝媛��엯�궇吏�

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
