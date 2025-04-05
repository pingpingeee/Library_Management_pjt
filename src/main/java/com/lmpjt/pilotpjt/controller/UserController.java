package com.lmpjt.pilotpjt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.dao.UserDAO;
import com.lmpjt.pilotpjt.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

//	servlet-context 에 있는 sqlSession 객체 연결
	@Autowired
	private SqlSession sqlSession;

	// 메인
//	@RequestMapping("/mainView")
//	public String mainView() {
//		return "main";
//	}

	// 로그인 요청 처리
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		UserDAO dao = sqlSession.getMapper(UserDAO.class);
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		ArrayList<UserDTO> dtos = dao.userLogin(userId, userPw);

		UserDTO dto = dao.getUserInfo(userId);

		if (dtos.isEmpty()) {
			return "redirect:loginView";
		} else {
			if (userPw.equals(dtos.get(0).getUserPw())) {
				HttpSession session = request.getSession(); // 세션 생성
				session.setAttribute("loginUser", dto); // 키 : loginUser에 user 객체 담음
				return "redirect:main";
			}
			return "redirect:loginView";
		}
	}

//	회원가입 요청 처리
	@RequestMapping("/join")
	public String join(HttpServletRequest request, UserDTO dto) {
		UserDAO dao = sqlSession.getMapper(UserDAO.class);
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");		
		String userName = request.getParameter("userName");		
		String userEmail = request.getParameter("userEmail");		
		String userTel = request.getParameter("userTel");		
		String userBirth = request.getParameter("userBirth");		
		String userAddress = request.getParameter("userAddress");
		String userDetailAddress = request.getParameter("userDetailAddress");
		String userZipCode = request.getParameter("userZipCode");
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(userTel);
		System.out.println(userBirth);
		System.out.println(userAddress);
		System.out.println(userDetailAddress);
		System.out.println(userZipCode);

		if (dao.checkId(request.getParameter("userId")) != null) {
			// 이미 사용중인 아이디 화면 처리 어떻게?
			System.out.println("join => 아이디 중복 체크");
		} else {
			int re = dao.userJoin(dto);
			if (re == 1) {
				// 성공 화면 처리 어떻게?
				return "redirect:loginView";
			}
		}
		return "join";
	}

	@RequestMapping("/user_info")
	public String getUserInfo(int u_number) {
		return "user_info";
	}

	@RequestMapping("/update_user_info")
	public String updateUserInfo(UserDTO user) {
		return "user_update";
	}
}
