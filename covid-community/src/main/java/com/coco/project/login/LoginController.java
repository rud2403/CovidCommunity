package com.coco.project.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	// 로그인 페이지 이동
	@GetMapping(value = "/login")
    String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception,
            Model model){
		
		model.addAttribute("error",error);
        model.addAttribute("exception",exception);
		
        return "login/login";
    }
	
	// 비밀번호 찾기 페이지 이동
	@GetMapping(value = "/forgotPw")
	String forgotPW() {
		return "login/forgotPw";
	}
	
	// 비밀번호 재설정 페이지 이동
	@PostMapping(value = "/resetPw")
	String resetPw(@RequestBody String userEmail, Model model) {
		
		model.addAttribute("userInfo",userEmail);
		
		return "login/resetPw";
	}
}
