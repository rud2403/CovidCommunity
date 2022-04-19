package com.coco.project.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coco.project.login.LoginDTO;

@Controller
public class ErrorHandlerController implements ErrorController{

	@GetMapping("/error403")
	public String getAccessDenied(@AuthenticationPrincipal LoginDTO loginDTO, Model model) {
		
		model.addAttribute("loginDTO", loginDTO);
		
        return "/error/error403";
    }
	
	@GetMapping("/error")
	public String error404(@AuthenticationPrincipal LoginDTO loginDTO, Model model) {
		
		model.addAttribute("loginDTO", loginDTO);
		
        return "/error/error404";
    }
}
