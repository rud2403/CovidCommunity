package com.coco.project.review;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.coco.project.login.LoginDTO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
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
	
	@GetMapping(value = "/detail/{id}") String detail(@PathVariable("id") int boardId, @AuthenticationPrincipal LoginDTO loginDTO, Model model) {
	
	model.addAttribute("userInfo", loginDTO);
	model.addAttribute("boardId", boardId);
	  
	return "/review/reviewDetail"; }
	
	// 후기게시판 글쓰기
	@Transactional
	@PostMapping(value = "/write")
    public String write(ReviewDTO reviewDTO, MultipartFile file, Model model) {
		
		int result = -1;
		
		try {
			
			if(reviewDTO != null) {
				result = reviewService.reviewBoardWrite(reviewDTO, file);	
			}
			
			// 게시글 작성 성공
			if(result == 1) {
				model.addAttribute("writeResult", result);
				return "/review/reviewList";
			// 게시글 작성 실패
			} else if(result == 0) {
				model.addAttribute("writeResult", result);
				return "/review/reviewList";
			} else {
				model.addAttribute("writeResult", result);
				return "/review/reviewList";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("writeResult", result);
		return "/review/reviewList";
		
    }
}
