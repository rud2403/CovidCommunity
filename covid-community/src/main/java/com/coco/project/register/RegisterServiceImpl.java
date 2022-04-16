package com.coco.project.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterMapper registerMapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// 이메일 중복체크
	@Override
	public int emailCheck(String userEmail) throws Exception {
	
		int result = registerMapper.emailCheck(userEmail);
		
		return result;
	}
	
	// 닉네임 중복체크
	@Override
	public int nameCheck(String userName) throws Exception {
		
		int result = registerMapper.nameCheck(userName);
		
		return result;
	}
	
	// 유저회원가입
	@Override
	@Transactional
	public int userRegister(RegisterDTO registerDTO) throws Exception {
		
		registerDTO.setUserPw(bcryptPasswordEncoder.encode(registerDTO.getUserPw()));
		registerDTO.setUserRole("ROLE_USER");
		registerDTO.setUserEnabled(1);
		
		int result = registerMapper.userRegister(registerDTO);
		
		return result;
	}
}
