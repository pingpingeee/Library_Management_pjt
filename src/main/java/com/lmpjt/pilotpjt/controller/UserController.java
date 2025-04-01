package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import model.UserDAOImpl;

@Controller
public class UserController {
	UserDAOImpl manager = UserDAOImpl.getInstance();

	
	// �α��� ����
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginPage() {
		System.out.println("test1");
		return "login";
	}

	// �α��� ��û ó��
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView login(HttpServletRequest request, String id, String pwd) {
		ModelAndView mv = new ModelAndView();
		int check = manager.userLogin(id, pwd); // �޾ƿ� ���̵� ��� ���� �Ȱ� ���� 1, 0, -1 ���
		User user = manager.getUserInfo(id); // �޾ƿ� ���̵�� ����� ���� �Ȱ� ����
		
		System.out.println(check);

		if (check == 1) { // �α��� ���� ��
			HttpSession session = request.getSession(); // ���� ����
			session.setAttribute("loginUser", user); // Ű : loginUser�� user ��ü ����
			mv.setViewName("redirect:/main"); // �α��� ������ main ����
		} else {
			mv.setViewName("login");
			mv.addObject("error", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
		}

		return mv;
	}

	@RequestMapping("/join")
	public String join(User user) {
		return "join";
	}

	@RequestMapping("/user_info")
	public String getUserInfo(int u_number) {
		return "user_info";
	}

	@RequestMapping("/update_user_info")
	public String updateUserInfo(User user) {
		return "user_update";
	}
}
