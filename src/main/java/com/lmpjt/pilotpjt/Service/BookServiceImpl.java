package com.lmpjt.pilotpjt.Service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

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
	public ArrayList<BookDTO> mainBookInfo() {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);		
		ArrayList<BookDTO> list = dao.mainBookInfo();
		return list;
	}

	@Override
	public ArrayList<BookDTO> searchBookInfo(HashMap<String, String>param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);		
		ArrayList<BookDTO> list = dao.searchBookInfo(param);
		
		return list;
	}

	@Override
	public BookDTO bookDetailInfo(HashMap<String, String> param) {
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		BookDTO dto = dao.bookDetailInfo(param);
		return dto;
	}

	@Override
	public void bookBorrow(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		BookDAO dao = sqlSession.getMapper(BookDAO.class);
		dao.bookBorrow(param);
	}

	@Override
	public void bookReturn(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		
	}

}
