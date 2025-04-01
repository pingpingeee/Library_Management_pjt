package entity;

public class Book {
	private int bookNumber; // 책 고유번호
	private String bookTitle; // 책 제목
	private String bookComent; // 책 짧은 내용
	private String bookWriter; // 책 저자
	private String bookPub; // 책 출판사
	private String bookDate; // 책 출판일자
	private String bookCategory; // 책 카테고리
	private int bookCount; // 책 몇권남았는지
	private int bookBorrowcount; // 책 얼마나 빌렸는지

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
