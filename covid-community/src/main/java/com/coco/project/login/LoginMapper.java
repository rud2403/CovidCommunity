package com.coco.project.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	// 로그인
	public LoginDTO getUserAccount(String userEmail);
}
