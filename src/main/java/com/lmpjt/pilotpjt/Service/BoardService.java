package com.lmpjt.pilotpjt.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lmpjt.pilotpjt.dto.BoardDTO;

public interface BoardService {
	public void boardWrite(HashMap<String, String> param);

	public ArrayList<BoardDTO> boardView();

	public BoardDTO boardDetailView(HashMap<String, String> param);

	public void boardModify(HashMap<String, String> param);

	public void boardDelete(HashMap<String, String> param);
}
