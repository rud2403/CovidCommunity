package com.coco.project.login;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	// 로그인
	public LoginDTO getUserAccount(String userEmail);
	
	// 비밀번호 변경
	public int resetPw(Map<String, String> userInfo);
}
