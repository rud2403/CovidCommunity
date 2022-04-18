package com.coco.project.oauth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.coco.project.login.LoginDTO;
import com.coco.project.login.LoginMapper;
import com.coco.project.register.RegisterDTO;
import com.coco.project.register.RegisterMapper;

@Service
public class OauthUserService extends DefaultOAuth2UserService{

	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private RegisterMapper registerMapper;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2User oauth2user = super.loadUser(userRequest);
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		
		String username = "g_" + oauth2user.getAttribute("sub").toString().substring(0,5); 
		
		String userEmail = oauth2user.getAttribute("email");
		
		LoginDTO loginDTO = loginMapper.getUserAccount(userEmail);
		
		if(loginDTO == null) {
			// 회원가입
			RegisterDTO registerDTO = new RegisterDTO();
			UUID uid = UUID.randomUUID();
			
			registerDTO.setUserEmail(userEmail);
			registerDTO.setUserNickName(username);
			registerDTO.setUserRole("ROLE_USER");
			registerDTO.setUserEnabled(1);
			
			int result = registerMapper.userRegister(registerDTO);
			
			if(result == 1) {
				loginDTO = loginMapper.getUserAccount(userEmail);
			} else {
				throw new OAuth2AuthenticationException("구글 연동 회원가입 실패.");
			}
			
		}
		
		return loginDTO;
	}
	
}
