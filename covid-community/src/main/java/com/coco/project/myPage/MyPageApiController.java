package com.coco.project.myPage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coco.project.register.RegisterDTO;

@RestController
@RequestMapping("myPage/api")
public class MyPageApiController {

	@Autowired
	MyPageService myPageService;
	
	// 마이페이지 내 정보 관리
	@PutMapping("/myInfo")
	@Transactional
	public ResponseEntity<Object> myInfo(@RequestBody RegisterDTO registerDTO) throws Exception {
		
		// 닉네임 중복체크
		int searchResult = -1;
		
		// 회원 정보 변경
		int updateResult = -1;
		
		searchResult = myPageService.nickNameCheck(registerDTO);
		
		// 중복되지 않은 닉네임
		if(searchResult == 0) {
			updateResult = myPageService.updateUserInfo(registerDTO);
		// 중복된 닉네임
		} else if (searchResult == 1){
			updateResult = 2;
		}
		
		return new ResponseEntity<>(updateResult, HttpStatus.OK);
	}
	
	// 마이페이지 내가 쓴 글 리스트
	@GetMapping("/myBoardList")
	public ResponseEntity<Object> myBoard(@RequestParam Map<String, Object> boardInfo) throws Exception{
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = myPageService.myBoardList(boardInfo);
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
	// 마이페이지 내 댓글
	@GetMapping("/myComment")
	public ResponseEntity<Object> myComment(@RequestParam Map<String, Object> userInfo) throws Exception{
		
		Map<String, Object> commentList = new HashMap<>();
		
		commentList = myPageService.myComment(userInfo);
		
		return new ResponseEntity<>(commentList, HttpStatus.OK);
	}
	
	// 마이페이지 내가 좋아요 한 글
	@GetMapping("/myLike")
	public ResponseEntity<Object> myLike(@RequestParam Map<String, Object> userInfo) throws Exception{
		
		Map<String, Object> likeList = new HashMap<>();
		
		likeList = myPageService.myLike(userInfo);
		
		return new ResponseEntity<>(likeList, HttpStatus.OK);
	}
}
