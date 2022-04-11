package com.coco.project.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coco.project.login.LoginDTO;


@Controller
@RequestMapping("admin")
public class AdminController {
	@GetMapping("/userManagement")
	public String userManagement(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/admin/userManagement";
	}
	
	@GetMapping("/boardManagement")
	public String boardManagement(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/admin/boardManagement";
	}
}
