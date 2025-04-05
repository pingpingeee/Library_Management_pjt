package com.lmpjt.pilotpjt.dao;

import java.util.ArrayList;

import com.lmpjt.pilotpjt.dto.UserDTO;

public interface UserDAO {
	public int userJoin(UserDTO dto); // 회원가입
	public ArrayList<UserDTO> userLogin(String id, String pwd); // 로그인
	public UserDTO checkId(String userId); // 아이디 중복확인
	public UserDTO getUserInfo(String userId); // 회원정보
	public int updateUserInfo(UserDTO dto); // 회원정보수정
}
