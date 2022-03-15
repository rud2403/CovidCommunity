package com.coco.project.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {

	@Autowired
	RegisterMapper registerMapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// 이메일 중복체크
	public int emailCheck(String userEmail) {
	
		int result = registerMapper.emailCheck(userEmail);
		
		return result;
	}
	
	// 닉네임 중복체크
	public int nameCheck(String userName) {
		
		int result = registerMapper.nameCheck(userName);
		
		return result;
	}
	
	// 유저회원가입
	public int userRegister(RegisterDTO registerDTO) {
		
		registerDTO.setUserPw(bcryptPasswordEncoder.encode(registerDTO.getUserPw()));
		registerDTO.setUserRole("ROLE_USER");
		registerDTO.setUserEnabled(1);
		
		int result = registerMapper.userRegister(registerDTO);
		
		return result;
	}
}
