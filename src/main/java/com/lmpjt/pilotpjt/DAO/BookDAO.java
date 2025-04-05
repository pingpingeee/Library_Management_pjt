package com.lmpjt.pilotpjt.dao;

import java.util.List;

import com.lmpjt.pilotpjt.dto.Book;

public interface BookDAO {
	// �����ڸ� ������ Boolean admin�� �����ؾ��Ҽ��� ����
	public int insertBook(Book book, int admin); // ������� (�����ڸ� ����)
	public int updateBook(Book book, int admin); // �������� (�����ڸ� ����)
	public List<Book> mainBookInfo(); // ����ȭ�� å �Ұ� => b_borrowcount ������
	public List<Book> searchBookInfo(); // ȸ���������� => b_title�� ��ġ�� ���ڿ��� �ִ� �͵�
}
