package com.coco.project.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(value = "/")
    String login(){
        return "/login/login";
    }
}
