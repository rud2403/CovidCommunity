package com.coco.project.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public LoginDTO loadUserByUsername(String userEamil) throws UsernameNotFoundException {
		
		LoginDTO loginDTO = loginMapper.getUserAccount(userEamil);
		
		if (loginDTO == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
		
		return loginDTO;
	}
	
}
