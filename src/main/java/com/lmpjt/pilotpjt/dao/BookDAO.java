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

	// ������ book_borrow ���̺� ���Եʰ� ���ÿ� borrow_record ���̺� ���Ե˴ϴ�.
	public void bookBorrow(HashMap<String, String> param); // ���� �ʿ� �� ��ȯ �� ����
	// �ݳ��� book_borrow ���̺��� �ش� ���� ���� �ϰ� return_record ���̺�� ���� �˴ϴ�.
	public void bookReturn(HashMap<String, String> param); // �ݳ� �ʿ� �� ��ȯ �� ����
	
	
}
