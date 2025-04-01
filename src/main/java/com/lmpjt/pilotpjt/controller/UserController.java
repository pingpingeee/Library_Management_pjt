package com.lmpjt.pilotpjt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	
	// 로그인 렌더
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String loginPage() {
		System.out.println("test1");
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
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
    	System.out.println("test1");
        HttpSession session = request.getSession(false); // 세션이 존재하면 가져오기
        if (session != null) {
            session.invalidate(); // 세션 전체 삭제
        }
        return "redirect:/login"; 
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
