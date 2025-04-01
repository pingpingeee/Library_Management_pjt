package model;

import entity.User;

public interface UserDAO {
	public int userJoin(User user); // 회원가입
	public int userLogin(String id, String pwd); // 로그인
	public User getUserInfo(String id); // 회원정보
	public int updateUserInfo(User user); // 회원정보수정
}
