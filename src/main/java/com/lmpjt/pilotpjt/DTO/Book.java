package com.lmpjt.pilotpjt.DTO;

public class Book {
	private int bookNumber; // �? 고유번호
	private String bookTitle; // �? ?���?
	private String bookComent; // �? 짧�? ?��?��
	private String bookWriter; // �? ???��
	private String bookPub; // �? 출판?��
	private String bookDate; // �? 출판?��?��
	private String bookCategory; // �? 카테고리
	private int bookCount; // �? 몇권?��?��?���?
	private int bookBorrowcount; // �? ?��마나 빌렸?���?

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookComent() {
		return bookComent;
	}

	public void setBookComent(String bookComent) {
		this.bookComent = bookComent;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPub() {
		return bookPub;
	}

	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getBookBorrowcount() {
		return bookBorrowcount;
	}

	public void setBookBorrowcount(int bookBorrowcount) {
		this.bookBorrowcount = bookBorrowcount;
	}

}
