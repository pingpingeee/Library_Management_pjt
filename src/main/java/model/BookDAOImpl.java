package model;

import java.sql.Connection;
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
		return ((DataSource)(new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	@Override
	public int insertBook(Book book, Boolean admin) {
		return 0;
	}

	@Override
	public int updateBook(Book book, Boolean admin) {
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
