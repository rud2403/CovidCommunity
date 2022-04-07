package com.coco.project.myPage;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coco.project.login.LoginDTO;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	// 마이 페이지 - 내정보 관리 이동
	@GetMapping(value = "/myInfo")
    String login(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
        return "myPage/myInfo";
    }
	
	
}
