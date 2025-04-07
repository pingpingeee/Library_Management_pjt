package com.lmpjt.pilotpjt.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmpjt.pilotpjt.dao.BoardDAO;
import com.lmpjt.pilotpjt.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void boardWrite(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.boardWrite(param);
	}

	@Override
	public ArrayList<BoardDTO> boardView() {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.boardView();
		System.out.println("list22 : " + list);
		return list;
	}

	@Override
	public BoardDTO boardDetailView(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		BoardDTO dto = dao.boardDetailView(param);
		return dto;
	}

	@Override
	public void boardModify(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.boardModify(param);

	}

	@Override
	public void boardDelete(HashMap<String, String> param) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.boardDelete(param);
	}

}
