package com.lmpjt.pilotpjt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.Service.BookService;
import com.lmpjt.pilotpjt.Service.UserService;
import com.lmpjt.pilotpjt.Service.UtilService;
import com.lmpjt.pilotpjt.dao.UserDAO;
import com.lmpjt.pilotpjt.dto.BookRecordDTO;
import com.lmpjt.pilotpjt.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	private BookService bookService;
	@Autowired
	private UtilService utilSerivce;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam HashMap<String, String> param) {

		ArrayList<UserDTO> dtos = service.userLogin(param);

		UserDTO dto = service.getUserInfo(param);

		if (dtos.isEmpty()) {
			return "redirect:loginView";
		} else {
			if (param.get("userPw").equals(dtos.get(0).getUserPw())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", dto);
				return "redirect:main";
			}
			return "redirect:loginView";
		}
	}

	@RequestMapping("/join")
	public ResponseEntity<String> join(HttpServletRequest request, @RequestParam HashMap<String, String> param) {

		if (service.checkId(param) != null) {

		} else {
			int re = service.userJoin(param);
			if (re == 1) {
				return ResponseEntity.ok("available");
			}
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("duplicate");
	}

	@RequestMapping("/user_info")
	public String getUserInfo(int u_number) {
		return "user_info";
	}

	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
		UserDTO dto = (UserDTO) request.getSession().getAttribute("loginUser");

		param.put("userNumber", String.valueOf(dto.getUserNumber()));
		ArrayList<BookRecordDTO> bookBorrowedList = bookService.bookBorrowed(param);
		ArrayList<BookRecordDTO> bookBorrowList = bookService.bookRecord(param);
		int userBorrowedBooks = utilSerivce.getUserBorrowed(param);
		int userRecord = utilSerivce.getUserRecord(param);
		int userOver = utilSerivce.getUserOver(param);
		int userRecordCount = utilSerivce.getBookRecordCount(param);
		model.addAttribute("bookBorrowedList", bookBorrowedList);
		model.addAttribute("bookBorrowList", bookBorrowList);
		model.addAttribute("userBorrowedBooks", userBorrowedBooks);
		model.addAttribute("userRecord", userRecord);
		model.addAttribute("userOver", userOver);
		model.addAttribute("userRecordCount", userRecordCount);

		return "mypage";
	}

	@RequestMapping("/user_update_view")
	public String updateUserInfo(UserDTO user) {
		return "user_update";
	}

	@RequestMapping("/userUpdate")
	public String updateUserInfo(@RequestParam HashMap<String, String> param, HttpSession session) {
		int result = service.updateUserInfo(param);
		if (result > 0) {
			session.invalidate(); // 세션 초기화 → 자동 로그아웃
			return "redirect:/loginView"; // 로그인 페이지로
		} else {
			return "redirect:/user_update_view"; // 실패 시 다시 수정 화면
		}

	}

	@RequestMapping("/userPwUpdate")
	public String updateUserPwInfo(@RequestParam HashMap<String, String> param, HttpSession session, Model model) {
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		int result = -1;

		String inputPw = param.get("userPw");
		String newPw = param.get("userNewPw");
		String confirmPw = param.get("userNewPwCheck");

		if (user.getUserPw().equals(param.get("userPw"))) {
			result = service.updateUserPwInfo(param);
		}

		if (result > 0) {
			session.invalidate(); // 세션 초기화 → 자동 로그아웃
			return "redirect:/loginView"; // 로그인 페이지로
		} else {
			model.addAttribute("errorMsg", "현재 비밀번호가 일치하지 않습니다.");
			model.addAttribute("userPw", inputPw);
			model.addAttribute("userNewPw", newPw);
			model.addAttribute("userNewPwCheck", confirmPw);
			return "mypage"; // 이 JSP가 위 코드와 같은 JSP라고 가정
		}
	}
}
