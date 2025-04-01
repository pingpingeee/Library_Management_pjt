package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//registerOK.jsp ����(������ ����� ���Դ��� �ְ�ް� ������ �Ѵ�.)
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Book;
import entity.User;
import model.BookDAOImpl;
import model.UserDAOImpl;

@Controller
public class BookController {

	BookDAOImpl manager = BookDAOImpl.getInstance();

	@RequestMapping("/main")
	public String getMainBookInfo() {
		UserDAOImpl manager = UserDAOImpl.getInstance();
		manager.test();
		return "main";
	}

	@RequestMapping("/book_insert")
	public String insertBook(Book book) {

		return "book_insert";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/book_insert")
	public ModelAndView insertBook(Book book, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
	    // ���ǿ��� �α����� ���� ���� ��������
	    HttpSession session = request.getSession();
	    User loginUser = (User) session.getAttribute("loginUser");
	    
	    // �α��ε� ������ ���� ��� ó��
	    if (loginUser == null) {
	        mv.setViewName("redirect:/login");
	        return mv;
	    }

		int re = manager.insertBook(book, loginUser.getUserAdmin());
		if (re == 1) {
			mv.setViewName("redirect:/main");
		} else {
			mv.setViewName("book_insert");
			mv.addObject("error", "���� ��Ͽ� �����Ͽ����ϴ�.");
		}
		return mv;
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
