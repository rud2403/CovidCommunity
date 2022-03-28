package com.coco.project.review;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coco.project.login.LoginDTO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	// 후기 게시판 - 리스트
	@GetMapping(value = "/list")
    String list(){
        return "/review/reviewList";
    }
	
	// 후기 게시판 - 글쓰기
	@GetMapping(value = "/write")
	String write(@AuthenticationPrincipal LoginDTO loginDTO, Model model){
		
		model.addAttribute("loginDTO", loginDTO);
		
		return "/review/reviewWrite";
	}
	
	// 후기 게시판 - 게시글 상세페이지
//	@GetMapping(value = "/detail")
//	String detail() {
//		
//		return "/review/reviewDetail";
//	}
	
	// 후기 게시판 - 게시글 상세페이지
	
	@GetMapping(value = "/detail/{id}") String detail(@PathVariable("id") int
	boardId, Model model) {
	
	model.addAttribute("boardId", boardId);
	  
	return "/review/reviewDetail"; }
	 
	
}
