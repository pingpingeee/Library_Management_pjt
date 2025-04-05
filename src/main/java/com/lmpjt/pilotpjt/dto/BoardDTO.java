package com.lmpjt.pilotpjt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private int boardNumber;
	private int userNumber;
	private String boardTitle;
	private String boardContent;
	private String boardWriteDate;
	private int boardViews;
	private int boardLikes;

}
