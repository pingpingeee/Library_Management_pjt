package model;

import entity.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int userJoin(User user) {
		// TODO:: 회원가입 구현부
		return 0;
	}

	@Override
	public int userLogin(User user) {
		// TODO:: 로그인 구현부
		return 0;
	}

	@Override
	public int getUserInfo(User user) {
		// TODO:: 유저정보불러오기 구현부
		return 0;
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO:: 유저정보수정 구현부
		return 0;
	}

	@Override
	public void userLogout() {
	}
	
	// 로그아웃
//	@Override
//	public void userLogout(HtppServletRequest request) {
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) session.invalidate();
//	}

}
