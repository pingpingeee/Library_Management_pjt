package com.lmpjt.pilotpjt.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lmpjt.pilotpjt.Service.BoardService;
import com.lmpjt.pilotpjt.dto.BoardDTO;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping("/board_view")
	public String boardView(Model model) {
		ArrayList<BoardDTO> list = service.boardView();
		model.addAttribute("boardList", list);
		return "board_view";
	}

	@RequestMapping("/board_write_ok")
	public String boardViewWrite(@RequestParam HashMap<String, String> param) {
		System.out.println(param);
		service.boardWrite(param);
		
		return "board_view";
	}

	@RequestMapping("/board_detail_view")
	public String boardViewDetail(@RequestParam HashMap<String, String> param, Model model) {
		BoardDTO dto = service.boardDetailView(param);
		model.addAttribute("board", dto);
		return "board_detail";
	}
}
