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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.dao.UserDAO;
import com.lmpjt.pilotpjt.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

//	servlet-context �� �ִ� sqlSession ��ü ����
	@Autowired
	private SqlSession sqlSession;

	// ����
//	@RequestMapping("/mainView")
//	public String mainView() {
//		return "main";
//	}

	// �α��� ��û ó��
	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam HashMap<String, String> param) {
		UserDAO dao = sqlSession.getMapper(UserDAO.class);

		ArrayList<UserDTO> dtos = dao.userLogin(param);

		UserDTO dto = dao.getUserInfo(param);

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
	public String join(HttpServletRequest request, @RequestParam HashMap<String, String> param) {
		UserDAO dao = sqlSession.getMapper(UserDAO.class);

		if (dao.checkId(param) != null) {
		} else {
			int re = dao.userJoin(param);
			if (re == 1) {
				return "redirect:loginView";
			}
		}
		System.out.println("test4");
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
