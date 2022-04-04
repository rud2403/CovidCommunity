package com.coco.project.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coco.project.like.LikeService;

@RestController
@RequestMapping("review/api")
public class ReviewApiController {

	@Autowired
	ReviewService reviewService;
	
	// 후기 게시판 리스트 조회
	@GetMapping("/BoardList")
	public ResponseEntity<Object> BoardList(@RequestParam Map<String, Object> boardInfo){
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = reviewService.reviewBoardList(boardInfo);
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
	// 후기 게시판 상세정보
	@GetMapping("/boardDetail")
	public ResponseEntity<Object> boardDetail(@RequestParam("boardId") int boardId, @RequestParam(value = "rcWriter", required = false) Integer rcWriter){
	// public ResponseEntity<Object> boardDetail(@RequestBody ReviewDTO reviewDTO){	
		Map<String, Object> detailResult = new HashMap<>();
		
		// 게시글 정보
		detailResult.put("boardDetail", reviewService.reviewBoardDetail(boardId));
		// 게시글 좋아요 총 개수
		detailResult.put("likeCnt", reviewService.reviewLikeCnt(boardId));
		// 좋아요 정보
		if(rcWriter != null) {
			// 좋아요 버튼 활성화
			detailResult.put("likeActive", reviewService.reviewLikeActive(boardId, rcWriter));
		}
		return new ResponseEntity<>(detailResult, HttpStatus.OK);
	}
	
	// 후기 게시판 조회수 증가
	@PostMapping("/boardViewCnt")
	public ResponseEntity<Object> boardViewCnt(@RequestBody int boardId, HttpServletRequest request, HttpServletResponse response){
		
		int detailResult = reviewService.reviewBoardViewCnt(request, response, boardId);
		
		return new ResponseEntity<>(detailResult, HttpStatus.OK);
	}
	
	// 후기 게시판 삭제
	@PutMapping("/boardDelete")
	public ResponseEntity<Object> boardDelete(@RequestBody int boardId){
		
		int deleteResult = reviewService.reviewBoardDelete(boardId);
		
		return new ResponseEntity<>(deleteResult, HttpStatus.OK);
	}
	
}
