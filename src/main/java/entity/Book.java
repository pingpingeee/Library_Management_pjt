package entity;

public class Book {
	private int b_number; // 책 고유번호
	private String b_title; // 책  제목
	private String b_coment; // 책 짧은 내용
	private String b_writer; // 책 저자
	private String b_pub; // 책 출판사
	private String b_date; // 책 출판일자
	private String b_category; // 책 카테고리
	private int b_count; // 책 몇권남았는지
	private int b_borrowcount; // 책 얼마나 빌렸는지
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_coment() {
		return b_coment;
	}
	public void setB_coment(String b_coment) {
		this.b_coment = b_coment;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_pub() {
		return b_pub;
	}
	public void setB_pub(String b_pub) {
		this.b_pub = b_pub;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	public int getB_borrowcount() {
		return b_borrowcount;
	}
	public void setB_borrowcount(int b_borrowcount) {
		this.b_borrowcount = b_borrowcount;
	}
	
	
}
