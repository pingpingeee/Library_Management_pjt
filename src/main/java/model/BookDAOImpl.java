package model; //DBBean 역할

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import entity.Book;

public class BookDAOImpl implements BookDAO {
	private static BookDAOImpl instance = new BookDAOImpl();

	public static BookDAOImpl getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}

	@Override
	public int insertBook(Book book, int admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int re = -1; // 초기값 -1, insert 정상적으로 실행되면 1
		String sql = "insert into book(b_number,b_title,b_coment,b_writer,b_pub, b_date, b_category, b_count)"
				+ " values((select nvl(max(b_number), 0)+1 from book),?,?,?,?,?,?,?)";
		try {
			if (admin == 1) {
				// dbcp 기법의 연결객체
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getBookTitle());
				pstmt.setString(2, book.getBookComent());
				pstmt.setString(3, book.getBookWriter());
				pstmt.setString(4, book.getBookPub());
				pstmt.setString(5, book.getBookDate());
				pstmt.setString(6, book.getBookCategory());
				pstmt.setInt(7, book.getBookCount());
//         		INSERT 문은 executeUpdate 메소드 호출
				re = pstmt.executeUpdate();

				// re 를 호출, 1을반환(실행된다는 전제하에.)
				// rs를 호출, sql 을 뱉는다 이말이네

//         excuteQuery -> select문을 사용할때 씀 ,
				// excuteUpdate -> insert,update, delete 그리고 반환타입이 int
				// 행의 갯수를 반환하기때문에 ResultSet 을 사용할 필요가없다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return re;
	}

	@Override
	public int updateBook(Book book, int admin) {
		return 0;
	}

	@Override
	public List<Book> mainBookInfo() {
		return null;
	}

	@Override
	public List<Book> searchBookInfo() {
		return null;
	}
}
