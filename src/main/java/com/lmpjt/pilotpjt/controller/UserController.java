package com.lmpjt.pilotpjt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lmpjt.pilotpjt.dao.UserDAOImpl;
import com.lmpjt.pilotpjt.dto.User;

@Controller
public class UserController {
	UserDAOImpl manager = UserDAOImpl.getInstance();

	// �α��� ����
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginPage() {
		return "login";
	}

	// �α��� ��û ó��
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String id, String pwd) {
		ModelAndView mv = new ModelAndView();
		int check = manager.userLogin(id, pwd); // �޾ƿ� ���̵� ��� ���� �Ȱ� ���� 1, 0, -1 ���
		User user = manager.getUserInfo(id); // �޾ƿ� ���̵�� ����� ���� �Ȱ� ����

//		System.out.println(check);

		// ���̵��� üũ �ϸ� ��Ű�� 7�ϰ� �����ϰ� ó��
//		Cookie rememberCookie = new Cookie("REMEBER", user.getUserId());
//		rememberCookie.setPath("/");
//		if(user.isRemeberId()) {
//			rememberCookie.setMaxAge(60*60*24*7); // 7�ϰ� ���̵� ���
//		}else {
//			rememberCookie.setMaxAge(0);
//		}
//		response.addCookie(rememberCookie);

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

	// �α׾ƿ�
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("redirect:/login");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/join")
	public String join(User user) {
		return "join";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/join")
	public void join(HttpServletResponse response, User user) throws IOException {
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    if (manager.checkId(user.getUserId()) == 1) { // �ߺ� ���̵� üũ
	        out.println("<script>");
	        out.println("alert('�̹� ������� ���̵��Դϴ�.');");
	        out.println("history.back();"); // ���� �������� �̵�
	        out.println("</script>");
	        out.close();
	    } else {
	        int re = manager.userJoin(user);
	        // ȸ������ ������ �˾�â ó���ؾ���
	        // ���⸸ ��� ó���ϸ� ȸ������ ���� ��
	        // ����ó������ �� ���� �˾��� �ִ°� �� ���е� ȸ�����ԿϷ�ƴٰ� â�� ���Ӱ� ������ ���� �����
	        if (re == 1) {
	            out.println("<script>");
	            out.println("alert('ȸ�������� �Ϸ�Ǿ����ϴ�.');");
	            out.println("location.href='/';"); // ���� �������� �̵�
	            out.println("</script>");
	            out.close();
	        }
	    }
	}
	
	// �� �� �˾� ó��? 
//	@RequestMapping(method = RequestMethod.POST, value = "/join")
//	public ModelAndView join(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
//		ModelAndView mv = new ModelAndView();
//		if (manager.checkId(user.getUserId()) == 1) { // �ߺ� ��
//			mv.setViewName("join");
//			mv.addObject("error", "�̹� ������� ���̵��Դϴ�.");
//			return mv;
//		} else {
//			int re = manager.userJoin(user);
//			if (re == 1) {
//				PrintWriter out = response.getWriter(); // �˾�â�� �����ֱ� ���� ����
//				out.println("<script>");
//				out.println("alert('ȸ�������� �Ϸ�Ǿ����ϴ�.');");
//				out.println("location.href='/';"); // ���� �������� �̵�
//				out.println("</script>");
//				out.close();
//			}
//		}
//		return mv;
//	}

	@RequestMapping("/user_info")
	public String getUserInfo(int u_number) {
		return "user_info";
	}

	@RequestMapping("/update_user_info")
	public String updateUserInfo(User user) {
		return "user_update";
	}
}
