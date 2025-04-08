package com.lmpjt.pilotpjt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentDTO {
	private int commentNumber;
	private int commentSubNumber;
	private int boardNumber;
	private int userNumber;
	private String userName;
	private String commentContent;
	private String commentWriteDate;
}
