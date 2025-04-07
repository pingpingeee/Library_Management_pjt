package com.lmpjt.pilotpjt.Service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmpjt.pilotpjt.dao.BookDAO;
import com.lmpjt.pilotpjt.dto.BookDTO;
import com.lmpjt.pilotpjt.dto.UserDTO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession session;
//	@Autowired
//	private UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

	@Override
	public void insertBook(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

		// 세션 전체 값
//		Enumeration<String> names = session.getAttributeNames();
//		while (names.hasMoreElements()) {
//		    String name = names.nextElement();
//		    Object value = session.getAttribute(name);
//		    System.out.println("세션 속성명: " + name + ", 값: " + value);
//		}
//		

		if (loginUser.getUserAdmin() == 1) {
			dao.insertBook(param);	
		} else {
			System.out.println("Not Admin access");
		}
	}

	@Override
	public void updateBook(HashMap<String, String> param) {

	}

	@Override
	public List<BookDTO> mainBookInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> searchBookInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
