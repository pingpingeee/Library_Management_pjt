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

	// 로그인 렌더
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginPage() {
		return "login";
	}

	// 로그인 요청 처리
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String id, String pwd) {
		ModelAndView mv = new ModelAndView();
		int check = manager.userLogin(id, pwd); // 받아온 아이디 비번 쿼리 훑고 오기 1, 0, -1 담김
		User user = manager.getUserInfo(id); // 받아온 아이디로 사용자 정보 훑고 오기

//		System.out.println(check);

		// 아이디기억 체크 하면 쿠키로 7일간 정리하게 처리
//		Cookie rememberCookie = new Cookie("REMEBER", user.getUserId());
//		rememberCookie.setPath("/");
//		if(user.isRemeberId()) {
//			rememberCookie.setMaxAge(60*60*24*7); // 7일간 아이디 기억
//		}else {
//			rememberCookie.setMaxAge(0);
//		}
//		response.addCookie(rememberCookie);

		if (check == 1) { // 로그인 성공 시
			HttpSession session = request.getSession(); // 세션 생성
			session.setAttribute("loginUser", user); // 키 : loginUser에 user 객체 담음
			mv.setViewName("redirect:/main"); // 로그인 성공시 main 으로
		} else {
			mv.setViewName("login");
			mv.addObject("error", "아이디 또는 비밀번호가 틀립니다.");
		}

		return mv;
	}

	// 로그아웃
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

	    if (manager.checkId(user.getUserId()) == 1) { // 중복 아이디 체크
	        out.println("<script>");
	        out.println("alert('이미 사용중인 아이디입니다.');");
	        out.println("history.back();"); // 이전 페이지로 이동
	        out.println("</script>");
	        out.close();
	    } else {
	        int re = manager.userJoin(user);
	        // 회원가입 성공시 팝업창 처리해야함
	        // 여기만 어떻게 처리하면 회원가입 완전 끝
	        // 예외처리까지 다 넣음 팝업문 넣는게 좀 별론데 회원가입완료됐다고 창을 새롭게 넣을지 말지 고민중
	        if (re == 1) {
	            out.println("<script>");
	            out.println("alert('회원가입이 완료되었습니다.');");
	            out.println("location.href='/';"); // 메인 페이지로 이동
	            out.println("</script>");
	            out.close();
	        }
	    }
	}
	
	// 둘 다 팝업 처리? 
//	@RequestMapping(method = RequestMethod.POST, value = "/join")
//	public ModelAndView join(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
//		ModelAndView mv = new ModelAndView();
//		if (manager.checkId(user.getUserId()) == 1) { // 중복 시
//			mv.setViewName("join");
//			mv.addObject("error", "이미 사용중인 아이디입니다.");
//			return mv;
//		} else {
//			int re = manager.userJoin(user);
//			if (re == 1) {
//				PrintWriter out = response.getWriter(); // 팝업창을 열어주기 위한 선언
//				out.println("<script>");
//				out.println("alert('회원가입이 완료되었습니다.');");
//				out.println("location.href='/';"); // 메인 페이지로 이동
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
