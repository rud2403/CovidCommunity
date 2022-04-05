package com.coco.project.vaccinationStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VSController {
	// 후기 게시판 - 게시글 상세페이지
		@GetMapping("/vaccinationStatus")
		String vaccinationStatus() {
			return "/vaccinationStatus/statusCharts";
		}
}
