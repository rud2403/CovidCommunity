package com.coco.project.comment;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDTO {

	private int rcId;
	private String rcContent;
	private int rcWriter;
	private int rcBoard;
	private LocalDateTime rcRegisterDate;
	private String rcDeleteYn;
	private int rcReRef;
	private int rcReLev;
	private int rcReSeq;
	
}
