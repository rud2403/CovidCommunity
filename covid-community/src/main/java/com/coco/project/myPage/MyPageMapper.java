package com.coco.project.myPage;

import org.apache.ibatis.annotations.Mapper;

import com.coco.project.register.RegisterDTO;

@Mapper
public interface MyPageMapper {
	
	// 마이페이지 정보변경 - 닉네임 중복체크
	public int nickNameCheck(RegisterDTO registerDTO);
	// 마이페이지 유저 정보변경
	public int updateUserInfo(RegisterDTO registerDTO);
	
}
