package com.coco.project.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	// 로그인
	@GetMapping(value = "/login")
    String login(){
        return "login/login";
    }
}
