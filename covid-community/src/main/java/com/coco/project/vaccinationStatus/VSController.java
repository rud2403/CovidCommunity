package com.coco.project.vaccinationStatus;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coco.project.login.LoginDTO;

@Controller
public class VSController {
	// 백신접종현황
	@GetMapping("/vaccinationStatus")
	String vaccinationStatus(@AuthenticationPrincipal LoginDTO loginDTO, Model model) {
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/vaccinationStatus/statusCharts";
	}
}
