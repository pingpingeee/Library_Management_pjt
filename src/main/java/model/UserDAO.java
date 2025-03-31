package model;

import entity.User;

public interface UserDAO {
	public int userJoin(User user); // ȸ������
	public int userLogin(User user); // �α���
	public int getUserInfo(User user); // ȸ�������ҷ�����
	public int updateUserInfo(User user); // ȸ����������
	public void userLogout();
}
