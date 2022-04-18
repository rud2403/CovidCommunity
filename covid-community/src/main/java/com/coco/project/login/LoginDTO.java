package com.coco.project.login;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class LoginDTO implements UserDetails, OAuth2User{
	private int userId;
	private String userEmail;
	private String userPw;
	private String userNickName;
	private String userBirth;
	private String userAddr;
	private String userRole;
	private int userEnabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(this.userRole));
	}
	@Override
	public String getPassword() {
		return this.userPw;
	}
	@Override
	public String getUsername() {
		return this.userEmail;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.userEnabled == 1?true:false;
	}
	
	// OAuth2
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
