package com.coco.project.myPage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.coco.project.register.RegisterDTO;

@Mapper
public interface MyPageMapper {
	
	// 마이페이지 정보변경 - 닉네임 중복체크
	public int nickNameCheck(RegisterDTO registerDTO);
	// 마이페이지 유저 정보변경
	public int updateUserInfo(RegisterDTO registerDTO);
	// 마이페이지 내가 쓴 글
	public List<Map<String,Object>> myBoardList(Map<String,Object> boardInfo);
	// 마이페이지 내가 쓴 글 총 개수
	public int myBoardListCnt(Map<String,Object> boardInfo);
	// 마이페이지 내 댓글
	public List<Map<String,Object>> myComment(Map<String,Object> userInfo);
	// 마이페이지 내 댓글 총 개수
	public int myCommentCnt(Map<String,Object> userInfo);
	// 마이페이지 내가 좋아요한 글
	public List<Map<String,Object>> myLike(Map<String,Object> userInfo);
	// 마이페이지 내가 좋아요한 글 총 개수
	public int myLikeCnt(Map<String,Object> userInfo);
}
