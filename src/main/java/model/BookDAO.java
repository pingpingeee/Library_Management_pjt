package model;

import java.util.List;

import entity.Book;

public interface BookDAO {
	// �����ڸ� ������ Boolean admin�� �����ؾ��Ҽ��� ����
	public int insertBook(Book book, Boolean admin); // ������� (�����ڸ� ����)
	public int updateBook(Book book, Boolean admin); // �������� (�����ڸ� ����)
	public List<Book> mainBookInfo(); // ����ȭ�� å �Ұ� => b_borrowcount ������
	public List<Book> searchBookInfo(); // ȸ���������� => b_title�� ��ġ�� ���ڿ��� �ִ� �͵�
}
