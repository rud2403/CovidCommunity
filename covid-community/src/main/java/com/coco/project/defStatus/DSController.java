package com.coco.project.defStatus;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coco.project.login.LoginDTO;

@Controller
public class DSController {
	// 발생현황
	@GetMapping("/defStatus")
	String defStatus(@AuthenticationPrincipal LoginDTO loginDTO, Model model) {
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/defStatus/defStatus";
	}
}
