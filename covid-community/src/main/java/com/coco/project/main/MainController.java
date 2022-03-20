package com.coco.project.main;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coco.project.login.LoginDTO;


@Controller
public class MainController {

	@RequestMapping(value = "/")
    String main(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
        return "index";
    }
}
