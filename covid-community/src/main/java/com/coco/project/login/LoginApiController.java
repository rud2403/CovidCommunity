package com.coco.project.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApiController {
	// 로그인 실패
	@GetMapping(value = "/loginDenied")
    String loginDenied(){
        return "loginDenied";
    }
}
