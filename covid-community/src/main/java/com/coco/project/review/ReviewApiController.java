package com.coco.project.review;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "review/api")
public class ReviewApiController {

	@Autowired
	ReviewService reviewService;
	
	// 후기게시판 글쓰기
	@PostMapping(value = "/write")
    public ResponseEntity<Object> write(@RequestBody ReviewDTO reviewDTO) throws Exception{
		
		int result = -1;
		
		if(reviewDTO != null) {
			result = reviewService.reviewBoardWrite(reviewDTO);	
		}
		
		HashMap<String, Integer> saveResult = new HashMap<>();
		
		// 게시글 작성 성공
		if(result == 1) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		// 게시글 작성 실패
		} else if(result == 0) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		}
		
		saveResult.put("result", result);
		return new ResponseEntity<>(saveResult, HttpStatus.OK);
    }
	
}
