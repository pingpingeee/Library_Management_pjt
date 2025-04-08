package com.lmpjt.pilotpjt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.Service.BookService;
import com.lmpjt.pilotpjt.dao.BookDAO;
import com.lmpjt.pilotpjt.dto.BookDTO;
import com.lmpjt.pilotpjt.dto.UserDTO;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@RequestMapping("/book_insert")
	public String insertBook(HttpServletRequest request,@RequestParam HashMap<String, String> param) {
		service.insertBook(param);
		
		return "admin_view";
	}

	@RequestMapping("/update_book")
	public String updateBookView(BookDTO book) {
		return "book_update";
	}
	
	@RequestMapping("/book_search_view")
	public String searchBookView(@RequestParam HashMap<String, String>param, Model model) {
		List<BookDTO> result = service.searchBookInfo(param);
		System.out.println("파라미터 확인: " + param);
		model.addAttribute("bookList", result);
		return "book_search";
	}
	
	@RequestMapping("/book_search")
	public String searchBook(@RequestParam HashMap<String, String>param, Model model) {
		List<BookDTO> result = service.searchBookInfo(param);
		System.out.println("파라미터 확인123: " + param);
		model.addAttribute("bookList", result);
		return "book_search";
	}
}
