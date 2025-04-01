package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import entity.User;

public class UserDAOImpl implements UserDAO {

	private static UserDAOImpl instance = new UserDAOImpl();

	public static UserDAOImpl getInstance() {
		return instance;
	}

	public void test() {

	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}

	@Override
	public int userJoin(User user) {
		return 0;
	}

	@Override
	public int userLogin(String id, String pwd) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "select u_pw from userinfo where u_id=?";
	    int result = -1;

	    try {
	        conn = getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, user.getUserId());
	        pstmt.setString(2, user.getUserPw());
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            result = 1; // 로그인 성공
	        } else {
	            result = 0; // 로그인 실패
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return result;
	}

	@Override
	public User getUserInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select u_id, u_pw, u_name, u_tel, u_birth, u_address, u_borrw, u_admin, u_regdate from userinfo where u_id=?";
		int re = -1;
		User user = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(id);
				user.setUserPw(rs.getString("u_pw"));
				user.setUserName(rs.getString("u_name"));
				user.setUserTel(rs.getString("u_tel"));
				user.setUserBirth(rs.getString("u_birth"));
				user.setUserAddress(rs.getString("u_address"));
				user.setUserBorrow(rs.getInt("u_borrow"));
				user.setUserAdmin(rs.getInt("u_admin"));
				user.setUserRegdate(rs.getString("u_regdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public int updateUserInfo(User user) {
		return 0;
	}

	@Override
	public void userLogout() {
	}

	@Override
	public User getUserInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void userLogout(HtppServletRequest request) {
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) session.invalidate();
//	}

}
