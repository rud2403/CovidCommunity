package com.coco.project.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coco.project.register.RegisterDTO;

@RestController
@RequestMapping("myPage/api")
public class MyPageApiController {

	@Autowired
	MyPageService myPageService;
	
	@PutMapping("myInfo")
	@Transactional
	public ResponseEntity<Object> myInfo(@RequestBody RegisterDTO registerDTO){
		
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
}
