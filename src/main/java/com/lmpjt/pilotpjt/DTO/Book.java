package com.lmpjt.pilotpjt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
