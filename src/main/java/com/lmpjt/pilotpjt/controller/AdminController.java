package com.lmpjt.pilotpjt.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmpjt.pilotpjt.Service.UtilService;

@Controller
public class AdminController {
	@Autowired
	private UtilService service;

	@RequestMapping("/admin_view")
	public String adminView(Model model) {
		model.addAttribute("totalBooks", service.getTotalBooks());
		model.addAttribute("totalUsers", service.getTotalUsers());
		model.addAttribute("borrowedBooks", service.getBorrowedBooks());
		model.addAttribute("overdueBooks", service.getOverdueBooks());
		return "admin_view";
	}

	@RequestMapping("/admin_notice")
	public String adminNoti() {
		return "admin_notice";
	}

	@RequestMapping("/admin_notice_write")
	public String adminNotiWrite() {
		return "admin_notice_write";
	}

	@RequestMapping("/admin_notice_detail")
	public String adminNotiDetail() {
		return "admin_notice_detail";
	}

	@RequestMapping("/book_insert_view")
	public String insertBookView() {
		return "book_insert";
	}

	@RequestMapping("/update_book_view")
	public String updateBook() {
		return "book_update";
	}
}
