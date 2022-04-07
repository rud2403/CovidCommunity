package com.coco.project.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coco.project.register.RegisterDTO;

@Service
public class MyPageService {
	
	@Autowired
	MyPageMapper myPageMapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// 마이페이지 - 닉네임 중복체크
	public int nickNameCheck(RegisterDTO registerDTO) {
		
		int result = -1;
		
		result = myPageMapper.nickNameCheck(registerDTO);
		
		return result;
	}
	
	// 마이페이지 - 회원정보 수정
	public int updateUserInfo(RegisterDTO registerDTO) {
		
		int result = -1;
		
		registerDTO.setUserPw(bcryptPasswordEncoder.encode(registerDTO.getUserPw()));
		
		result = myPageMapper.updateUserInfo(registerDTO);
		
		return result;
	}
}
