package com.coco.project.register;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

	// 이메일 중복체크
	public int emailCheck(String userEmail);
	// 닉네임 중복체크
	public int nameCheck(String userName);
	// 유저 회원가입
	public int userRegister(RegisterDTO registerDTO);
}
