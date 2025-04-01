package model;

import entity.User;

public interface UserDAO {
	public int userJoin(User user); // ȸ������
	public int userLogin(String id, String pwd); // �α���
	public User getUserInfo(String id); // ȸ������
	public int updateUserInfo(User user); // ȸ����������
}
