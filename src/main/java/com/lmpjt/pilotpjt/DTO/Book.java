package com.lmpjt.pilotpjt.DTO;

public class Book {
	private int bookNumber; // ì±? ê³ ìœ ë²ˆí˜¸
	private String bookTitle; // ì±? ? œëª?
	private String bookComent; // ì±? ì§§ì? ?‚´?š©
	private String bookWriter; // ì±? ???
	private String bookPub; // ì±? ì¶œíŒ?‚¬
	private String bookDate; // ì±? ì¶œíŒ?¼?
	private String bookCategory; // ì±? ì¹´í…Œê³ ë¦¬
	private int bookCount; // ì±? ëª‡ê¶Œ?‚¨?•˜?Š”ì§?
	private int bookBorrowcount; // ì±? ?–¼ë§ˆë‚˜ ë¹Œë ¸?Š”ì§?

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
