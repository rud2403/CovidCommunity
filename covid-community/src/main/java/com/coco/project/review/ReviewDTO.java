package com.coco.project.review;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int rbId;
	private String rbTitle;
	private String rbContent;
	private int rbViewCnt;
	private int rbLikeCnt;
	private LocalDateTime rbRegisterDate;
	private LocalDateTime rbUpdateDate;
	private int rbWriter;
	private String rbNoticeYn;
	private String rbVaccineKind;
	private String rbFileName;
	private String rbFilePath;
}
