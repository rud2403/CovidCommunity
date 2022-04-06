package com.coco.project.vaccinationStatus;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coco.project.login.LoginDTO;

@Controller
public class VSController {
	// 후기 게시판 - 게시글 상세페이지
		@GetMapping("/vaccinationStatus")
		String vaccinationStatus(@AuthenticationPrincipal LoginDTO loginDTO, Model model) {
			
			model.addAttribute("loginDTO", loginDTO);
			
			return "/vaccinationStatus/statusCharts";
		}
}
