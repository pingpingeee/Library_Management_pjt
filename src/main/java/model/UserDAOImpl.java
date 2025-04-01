package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import entity.User;

public class UserDAOImpl implements UserDAO{
	
	private static UserDAOImpl instance = new UserDAOImpl();
	public static UserDAOImpl getInstance() {
		return instance;
	}
	
	public void test() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception {
		return ((DataSource)(new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}

	@Override
	public int userJoin(User user) {
		return 0;
	}

	@Override
	public int userLogin(User user) {
		return 0;
	}

	@Override
	public int getUserInfo(User user) {
		return 0;
	}

	@Override
	public int updateUserInfo(User user) {
		return 0;
	}

	@Override
	public void userLogout() {
	}
	
//	@Override
//	public void userLogout(HtppServletRequest request) {
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) session.invalidate();
//	}

}
