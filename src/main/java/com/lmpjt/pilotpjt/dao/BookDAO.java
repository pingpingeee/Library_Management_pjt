package com.lmpjt.pilotpjt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmpjt.pilotpjt.dto.BookDTO;

public interface BookDAO {
//	public int insertBook(@Param("book")BookDTO book, int admin); 
//	public int updateBook(BookDTO book, int admin);
//	public List<BookDTO> mainBookInfo();
//	public List<BookDTO> searchBookInfo();
	public void insertBook(HashMap<String, String> param);

	public void updateBook(HashMap<String, String> param);

	public ArrayList<BookDTO> mainBookInfo();

	public ArrayList<BookDTO> searchBookInfo(HashMap<String, String> param);

	public BookDTO bookDetailInfo(HashMap<String, String> param);

	public void bookBorrow(HashMap<String, String> param);

	public void bookReturn(HashMap<String, String> param);

	public int getBorrowedCount(HashMap<String, String> param);
	public int getOverdueCount(HashMap<String, String> param);
	public int getReturnedCount(HashMap<String, String> param);
	
	public ArrayList<BookDTO> isReturned(HashMap<String, String> param);	
	
}
