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
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public String insertBook(HttpServletRequest request, @RequestParam HashMap<String, String> param) {
		service.insertBook(param);

		return "admin_view";
	}

	@RequestMapping("/update_book")
	public String updateBookView(BookDTO book) {
		return "book_update";
	}

	@RequestMapping("/book_search_view")
	public String searchBookView(@RequestParam HashMap<String, String> param, Model model) {
		List<BookDTO> list = service.searchBookInfo(param);
		model.addAttribute("bookList", list);
		return "book_search";
	}

	@RequestMapping("/book_detail")
	public String bookDetail(@RequestParam HashMap<String, String> param, Model model) {
		BookDTO dto = service.bookDetailInfo(param);
		System.out.println("param : " + param);
		System.out.println("result : " + dto);
		model.addAttribute("book", dto);
		return "book_detail";
	}
	
	@RequestMapping("/book_borrow")
	public String bookBorrow(@RequestParam HashMap<String, String> param, HttpServletRequest request, Model model) {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		if (user == null) {
	        return "redirect:main"; // 로그인
	    }
		int userNumber = user.getUserNumber();
		
	    param.put("userNumber", String.valueOf(userNumber)); // 유저번호 param에 추가
	    try {
	        service.bookBorrow(param);
	    } catch (Exception e) {
	        e.printStackTrace(); // 콘솔에서 자세히 확인

	        String message = e.getMessage();
	        if (message != null && message.contains("ORA-20002")) {
	            model.addAttribute("errorMsg", "회원의 대출 가능 권수가 0입니다.");
	        } else if (message != null && message.contains("ORA-20001")) {
	            model.addAttribute("errorMsg", "책의 남은 수량이 없습니다.");
	        } else {
	            model.addAttribute("errorMsg", "오류 발생: " + message);
	        }

	        model.addAttribute("bookNumber", param.get("bookNumber")); // 다시 book_detail에 전달
	        return "book_detail";
	    }

	    
	    return "redirect:book_detail?bookNumber=" + param.get("bookNumber");
	}
	
	
	@RequestMapping("/user_book_borrowing")
	public String userBookBorrowing(BookDTO book) {
		return "user_book_borrowing";
	}
}
