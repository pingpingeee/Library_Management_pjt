package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmpjt.pilotpjt.dto.UserDTO;

@Controller
public class ViewController {
	
	@RequestMapping("/main")
	public String getMainBookInfo() {
//		HttpSession session = request.getSession();
//		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
//		if (loginUser == null) {
//			return "redirect:loginView";
//		}
		return "main";
	}

	// ���� ���� ����
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

	// å���� �� ����
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

	// ���� ���� ����
	// �α��� ȭ�� ����
	@RequestMapping("/loginView")
	public String loginPage() {
		return "login";
	}
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}

	// �α׾ƿ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	// ȸ������ ��
	@RequestMapping("/joinView")
	public String join() {
		return "join";
	}
	
	// �Խ��� ���� ����
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
