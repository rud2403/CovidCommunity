package com.coco.project.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.coco.project.register.RegisterDTO;
import com.coco.project.review.ReviewDTO;

@Mapper
public interface AdminMapper {
	
	// 관리자페이지 - 유저 리스트
	public List<Map<String,Object>> userList(Map<String,Object> reqInfo);
	// 관리자페이지 - 유저 정보
	public Map<String,Object> userInfo(String uId);
	// 관리자페이지 - 유저정보 총개수
	public int userListCnt(Map<String,Object> reqInfo);
	// 관리자페이지 - 유저정보 수정
	public int userUpdate(RegisterDTO registerDTO);
	// 관리자페이지 - 게시글 리스트
	public List<Map<String,Object>> boardList(Map<String,Object> reqInfo);
	// 관리자페이지 - 게시글 정보
	public Map<String,Object> boardInfo(String rbId);
	// 관리자 페이지 - 게시글정보 총개수
	public int boardListCnt(Map<String,Object> reqInfo);
	// 관리자 페이지 - 게시글정보 수정
	public int boardUpdate(ReviewDTO reviewDTO);
}
