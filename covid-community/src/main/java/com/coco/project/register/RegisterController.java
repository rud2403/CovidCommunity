package com.coco.project.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@GetMapping(value = "/")
    String register(){
        return "/register/register";
    }
}
