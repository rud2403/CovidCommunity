package com.coco.project.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "review/api")
public class ReviewApiController {

	@Autowired
	ReviewService reviewService;
	
	// 후기 게시판 리스트 조회
	@GetMapping(value = "/BoardList")
	public ResponseEntity<Object> BoardList(@RequestParam Map<String, Object> boardInfo){
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = reviewService.reviewBoardList(boardInfo);
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
	// 후기 게시판 상세정보
	@GetMapping(value = "/boardDetail")
	public ResponseEntity<Object> boardDetail(@RequestParam(value = "boardId") int boardId){
		
		Map<String, Object> detailResult = new HashMap<>();
		
		detailResult = reviewService.reviewBoardDetail(boardId);
		
		return new ResponseEntity<>(detailResult, HttpStatus.OK);
	}
	
	// 후기 게시판 조회수 증가
	@PostMapping(value ="/boardViewCnt")
	public ResponseEntity<Object> boardViewCnt(@RequestBody int boardId, HttpServletRequest request, HttpServletResponse response){
		
		int detailResult = reviewService.reviewBoardViewCnt(request, response, boardId);
		
		return new ResponseEntity<>(detailResult, HttpStatus.OK);
	}
	
}
