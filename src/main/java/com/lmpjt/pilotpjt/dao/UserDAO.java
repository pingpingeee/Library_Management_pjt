package com.lmpjt.pilotpjt.dao;


import java.util.ArrayList;

import com.lmpjt.pilotpjt.dto.UserDTO;

public interface UserDAO {
	public int userJoin(UserDTO dto); // ȸ������
	public ArrayList<UserDTO> userLogin(String id, String pwd); // �α���
	public UserDTO checkId(String userId); // ���̵� �ߺ�Ȯ��
	public UserDTO getUserInfo(String userId); // ȸ������
	public int updateUserInfo(UserDTO dto); // ȸ����������
}
