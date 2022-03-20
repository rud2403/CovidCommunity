package com.coco.project.login;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class LoginDTO implements UserDetails{

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
	
}
