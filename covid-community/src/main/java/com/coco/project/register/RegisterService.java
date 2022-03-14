package com.coco.project.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {

	@Autowired
	RegisterMapper registerMapper;
	
	// 이메일 중복체크
	public int emailCheck(String userEmail) {
	
		int result = registerMapper.emailCheck(userEmail);
		
		return result;
	}
}
