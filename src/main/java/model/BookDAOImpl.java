package model;

import java.util.List;

import entity.Book;

public class BookDAOImpl implements BookDAO {

	@Override
	public int insertBook(Book book, Boolean admin) {
		// TODO::도서등록 구현부
		return 0;
	}

	@Override
	public int updateBook(Book book, Boolean admin) {
		// TODO::도서수정 구현부
		return 0;
	}

	@Override
	public List<Book> mainBookInfo() {
		// TODO::메인화면 책정보 불러오기 구현부
		return null;
	}

	@Override
	public List<Book> searchBookInfo() {
		// TODO:: 책 검색 구현부
		return null;
	}

}
