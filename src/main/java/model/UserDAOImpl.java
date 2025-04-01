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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into userinfo(u_number, u_id, u_pw, u_name, u_email, u_tel, u_birth, u_address) "
				+ "values((select nvl(max(u_number), 0)+1 from userinfo), ?, ?, ?, ?, ?, ?, ?)";
		int re = -1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserTel());
			pstmt.setString(6, user.getUserBirth());
			pstmt.setString(7, user.getUserAddress());
			
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public int userLogin(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select u_pw from userinfo where u_id=?";
		int re = -1;

		String checkUserPwd = ""; // 디비에서 긁어온거랑 일치하는지 확인할 변수

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkUserPwd = rs.getString("u_pw");
				if (checkUserPwd.equals(pwd)) {
					re = 1;
				} else {
					re = 0;
				}
			} else {
				re = -1; // 로그인 실패
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public User getUserInfo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select u_id, u_pw, u_name, u_tel, u_birth, u_address, u_borrow, u_admin, u_regdate from userinfo where u_id=?";
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
	public int checkId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select u_id from userinfo where u_id=?";
		int re = -1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				re = 1;
			} else {
				re = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

//	@Override
//	public void userLogout(HtppServletRequest request) {
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) session.invalidate();
//	}

}
