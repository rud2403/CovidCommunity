package com.coco.project.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comment/api")
public class CommentApiController {

	@Autowired
	CommentService commentService; 
	
	// 댓글 - 작성
	@PostMapping(value ="/write")
	public ResponseEntity<Object> write(@RequestBody CommentDTO commentDTO) throws Exception{
		
		int writeResult = commentService.commentWrite(commentDTO);
		
		return new ResponseEntity<>(writeResult, HttpStatus.OK);
	}
	
	// 댓글 - 리스트 가져오기
	@GetMapping(value = "/commentList")
	public ResponseEntity<Object> commentList(@RequestParam(value = "boardId") int boardId){
		
		Map<String, Object> listResult = new HashMap<>();
		
		listResult = commentService.commentList(boardId);
		
		return new ResponseEntity<>(listResult, HttpStatus.OK);
	}
	
	// 대댓글 - 작성
	@PostMapping(value ="/reWrite")
	public ResponseEntity<Object> reWrite(@RequestBody CommentDTO commentDTO) throws Exception{
		
		int writeResult = commentService.reCommentWrite(commentDTO);
		
		return new ResponseEntity<>(writeResult, HttpStatus.OK);
	}
	
	// 댓글 - 수정
	@PutMapping(value ="/update")
	public ResponseEntity<Object> update(@RequestBody CommentDTO commentDTO) throws Exception{
		
		int updateResult = commentService.commentUpdate(commentDTO);
		
		return new ResponseEntity<>(updateResult, HttpStatus.OK);
	}
	
	// 댓글- 삭제
	@DeleteMapping(value ="/delete")
	public ResponseEntity<Object> delete(@RequestBody CommentDTO commentDTO) throws Exception{
		
		int deleteResult = commentService.commentDelete(commentDTO);
		
		return new ResponseEntity<>(deleteResult, HttpStatus.OK);
	}
}
