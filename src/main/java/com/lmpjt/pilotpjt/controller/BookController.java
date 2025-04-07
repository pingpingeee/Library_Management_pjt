package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//registerOK.jsp ����(������ ����� ���Դ��� �ְ�ް� ������ �Ѵ�.)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.dao.BookDAO;
import com.lmpjt.pilotpjt.dto.BookDTO;
import com.lmpjt.pilotpjt.dto.UserDTO;

@Controller
public class BookController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/book_insert")
	public String insertBook(HttpServletRequest request, BookDTO book) {
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

		BookDAO dao = sqlSession.getMapper(BookDAO.class);

		if (loginUser == null) {
			return "redirect:loginView";
		}

		dao.insertBook(book, loginUser.getUserAdmin());
		return "admin_view";

//		int re = manager.insertBook(book, loginUser.getUserAdmin());
//		if (re == 1) {
//			mv.setViewName("redirect:/main");
//		} else {
//			mv.setViewName("book_insert");
//			mv.addObject("error", "���� ��Ͽ� �����Ͽ����ϴ�.");
//		}
	}

	@RequestMapping("/update_book")
	public String updateBookView(BookDTO book) {
		return "book_update";
	}

	@RequestMapping("/search_book")
	public String searchBook(String title) {
		return "book_search";
	}
}
