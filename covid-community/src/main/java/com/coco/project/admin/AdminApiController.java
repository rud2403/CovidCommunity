package com.coco.project.admin;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coco.project.register.RegisterDTO;
import com.coco.project.review.ReviewDTO;
import com.coco.project.review.ReviewService;

@RestController
@RequestMapping("admin/api")
public class AdminApiController {

	@Autowired
	AdminService adminservice;
	
	// 관리자페이지 - 유저 목록
	@GetMapping("/userList")
	public ResponseEntity<Object> userList(@RequestParam Map<String, Object> reqInfo) throws Exception {
		
		Map<String, Object> userList = new HashMap<>();
		
		userList = adminservice.userList(reqInfo);
		
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	// 관리자페이지 - 유저 정보
	@GetMapping("/userInfo/{uId}")
	public ResponseEntity<Object> userInfo(@PathVariable("uId") String uId) throws Exception {
		
		Map<String, Object> userList = new HashMap<>();
		
		userList = adminservice.userInfo(uId);
		
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	// 관리자페이지 - 유저정보 수정
	@PutMapping("/userUpdate")
	public ResponseEntity<Object> userUpdate(@RequestBody RegisterDTO registerDTO) throws Exception {
		
		int updateResult = adminservice.userUpdate(registerDTO);
		
		return new ResponseEntity<>(updateResult, HttpStatus.OK);
	}
	
	// 관리자 페이지 - 게시글 목록
	@GetMapping("/boardList")
	public ResponseEntity<Object> boardList(@RequestParam Map<String, Object> reqInfo) throws Exception {
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = adminservice.boardList(reqInfo);
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
	// 관리자 페이지 - 게시글 정보
	@GetMapping("/boardInfo/{rbId}")
	public ResponseEntity<Object> boardInfo(@PathVariable("rbId") String rbId) throws Exception {
		
		Map<String, Object> userList = new HashMap<>();
		
		userList = adminservice.boardInfo(rbId);
		
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	// 관리자페이지 - 게시글정보 수정
	@PutMapping("/boardUpdate")
	public ResponseEntity<Object> boardUpdate(@RequestBody ReviewDTO reviewDTO) throws Exception {
		
		int updateResult = adminservice.boardUpdate(reviewDTO);
		
		return new ResponseEntity<>(updateResult, HttpStatus.OK);
	}
}
