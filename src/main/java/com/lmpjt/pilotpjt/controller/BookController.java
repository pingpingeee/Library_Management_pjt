package com.lmpjt.pilotpjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Book;
import model.UserDAOImpl;

@Controller
public class BookController {
	
	
	@RequestMapping("/main")
	public String getMainBookInfo() {
		UserDAOImpl manager = UserDAOImpl.getInstance();
		manager.test();
		return "main";
	}
	
	@RequestMapping("/insert_book")
	public String insertBook(Book book) {
		return "insert_book";
	}
	
	@RequestMapping("/update_book")
	public String updateBook(Book book) {
		return "book_update";
	}
	
	@RequestMapping("/search_book")
	public String searchBook(String title) {
		return "book_search";
	}
}
