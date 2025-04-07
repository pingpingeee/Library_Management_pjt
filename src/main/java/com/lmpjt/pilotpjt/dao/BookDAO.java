package com.lmpjt.pilotpjt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lmpjt.pilotpjt.dto.BookDTO;

public interface BookDAO {
	public int insertBook(@Param("book")BookDTO book, int admin); // ������� (�����ڸ� ����)
	public int updateBook(BookDTO book, int admin); // �������� (�����ڸ� ����)
	public List<BookDTO> mainBookInfo(); // ����ȭ�� å �Ұ� => b_borrowcount ������
	public List<BookDTO> searchBookInfo(); // ȸ���������� => b_title�� ��ġ�� ���ڿ��� �ִ� �͵�
}
