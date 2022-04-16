package com.coco.project.myPage;

import java.util.Map;

import com.coco.project.register.RegisterDTO;

public interface MyPageService {
	// 마이페이지 - 닉네임 중복체크
	public int nickNameCheck(RegisterDTO registerDTO) throws Exception;
	// 마이페이지 - 회원정보 수정
	public int updateUserInfo(RegisterDTO registerDTO) throws Exception;
	// 마이페이지 - 내가 쓴 글
	public Map<String,Object> myBoardList(Map<String, Object> boardInfo) throws Exception;
	// 마이페이지 - 내 댓글
	public Map<String,Object> myComment(Map<String, Object> userInfo) throws Exception;
	// 마이페이지 - 내가 좋아요 한 글
	public Map<String,Object> myLike(Map<String, Object> userInfo)throws Exception;
}
