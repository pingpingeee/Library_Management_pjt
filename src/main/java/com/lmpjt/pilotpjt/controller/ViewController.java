package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmpjt.pilotpjt.dto.UserDTO;

@Controller
public class ViewController {
	// ¸ÞÀÎ ·»´õ
	@RequestMapping("/main")
	public String getMainBookInfo() {
		return "main";
	}

	// ¾îµå¹Î °ü·Ã ·»´õ
	@RequestMapping("/admin_view")
	public String adminView() {
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

	// Ã¥°ü·Á ºä ·»´õ
	@RequestMapping("/book_insert_view")
	public String insertBookView() {
		return "book_insert";
	}

	@RequestMapping("/search_book_view")
	public String searchBookView() {
		return "book_search";
	}

	@RequestMapping("/update_book_view")
	public String updateBook() {
		return "book_update";
	}

	// À¯Àú °ü·Ã ·»´õ
	// ·Î±×ÀÎ È­¸é ·»´õ
	@RequestMapping("/loginView")
	public String loginPage() {
		return "login";
	}
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}

	// ·Î±×¾Æ¿ô
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	// È¸¿ø°¡ÀÔ ºä
	@RequestMapping("/joinView")
	public String join() {
		return "join";
	}
	
	// °Ô½ÃÆÇ °ü·Ã ·»´õ
	@RequestMapping("/board_view")
	public String boardView() {
		return "board_view";
	}
	@RequestMapping("/board_detail")
	public String boardViewDetail() {
		return "board_detail";
	}
	@RequestMapping("/board_write")
	public String boardViewWrite() {
		return "board_write";
	}
}
