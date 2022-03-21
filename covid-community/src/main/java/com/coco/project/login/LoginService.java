package com.coco.project.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public LoginDTO loadUserByUsername(String userEamil) throws UsernameNotFoundException {

		LoginDTO loginDTO = loginMapper.getUserAccount(userEamil);

		if (loginDTO == null) {
			throw new UsernameNotFoundException("User not authorized.");
		}

		return loginDTO;
	}

	// 이메일 중복체크
	public int resetPw(Map<String,String> userInfo) {

		String userPw = bcryptPasswordEncoder.encode(userInfo.get("userPw"));
		
		userInfo.put("userPw", userPw);
		
		int result = loginMapper.resetPw(userInfo);

		return result;
	}

}
