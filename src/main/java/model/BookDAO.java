package model;

import java.util.List;

import entity.Book;

public interface BookDAO {
	// 관리자만 가능은 Boolean admin을 수정해야할수도 있음
	public int insertBook(Book book, Boolean admin); // 도서등록 (관리자만 가능)
	public int updateBook(Book book, Boolean admin); // 도서수정 (관리자만 가능)
	public List<Book> mainBookInfo(); // 메인화면 책 소개 => b_borrowcount 많은순
	public List<Book> searchBookInfo(); // 회원정보수정 => b_title에 일치한 문자열이 있는 것들
}
