package com.lmpjt.pilotpjt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
