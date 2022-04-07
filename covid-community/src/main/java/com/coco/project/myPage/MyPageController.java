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
    String myInfo(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		model.addAttribute("loginDTO", loginDTO);
		
        return "myPage/myInfo";
    }
	
	// 마이 페이지 - 내가 쓴 글
	@GetMapping(value = "/myBoardList")
    String myPost(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		model.addAttribute("loginDTO", loginDTO);
		
        return "myPage/myBoardList";
    }
	
	// 마이 페이지 - 내가 쓴 글
	@GetMapping(value = "/myComment")
    String myComment(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		model.addAttribute("loginDTO", loginDTO);
		
        return "myPage/myComment";
    }
		
}
