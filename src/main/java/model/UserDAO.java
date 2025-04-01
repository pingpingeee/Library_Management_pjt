package model;

import entity.User;

public interface UserDAO {
	public int userJoin(User user); // ȸ������
	public int userLogin(String id, String pwd); // �α���
	public int checkId(String id); // ���̵� �ߺ�Ȯ��
	public User getUserInfo(String id); // ȸ������
	public int updateUserInfo(User user); // ȸ����������
}
