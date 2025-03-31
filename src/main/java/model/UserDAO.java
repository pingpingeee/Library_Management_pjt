package model;

import entity.User;

public interface UserDAO {
	public int userJoin(User user); // 회원가입
	public int userLogin(User user); // 로그인
	public int getUserInfo(User user); // 회원정보불러오기
	public int updateUserInfo(User user); // 회원정보수정
	public void userLogout();
}
