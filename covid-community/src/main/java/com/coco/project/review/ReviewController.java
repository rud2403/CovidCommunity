package com.coco.project.review;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coco.project.login.LoginDTO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	@GetMapping(value = "/list")
    String list(){
        return "/review/reviewList";
    }
	
	@GetMapping(value = "/write")
	String write(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/review/reviewWrite";
	}
	
}
