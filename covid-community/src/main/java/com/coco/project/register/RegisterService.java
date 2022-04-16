package com.coco.project.register;

public interface RegisterService {

	// 이메일 중복체크
	public int emailCheck(String userEmail) throws Exception;
	// 닉네임 중복체크
	public int nameCheck(String userName) throws Exception;
	// 유저회원가입
	public int userRegister(RegisterDTO registerDTO) throws Exception;
	
}
