package model;

import entity.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int userJoin(User user) {
		// TODO:: ȸ������ ������
		return 0;
	}

	@Override
	public int userLogin(User user) {
		// TODO:: �α��� ������
		return 0;
	}

	@Override
	public int getUserInfo(User user) {
		// TODO:: ���������ҷ����� ������
		return 0;
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO:: ������������ ������
		return 0;
	}

	@Override
	public void userLogout() {
	}
	
	// �α׾ƿ� ���ǻ���
//	@Override
//	public void userLogout(HtppServletRequest request) {
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) session.invalidate();
//	}

}
