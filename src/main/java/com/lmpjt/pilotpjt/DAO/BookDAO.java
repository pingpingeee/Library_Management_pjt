package com.lmpjt.pilotpjt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmpjt.pilotpjt.dto.BookDTO;

public interface BookDAO {
	public int insertBook(@Param("book")BookDTO book, int admin); // 도서등록 (관리자만 가능)
	public int updateBook(BookDTO book, int admin); // 도서수정 (관리자만 가능)
	public List<BookDTO> mainBookInfo(); // 메인화면 책 소개 => b_borrowcount 많은순
	public List<BookDTO> searchBookInfo(); // 회원정보수정 => b_title에 일치한 문자열이 있는 것들
}
