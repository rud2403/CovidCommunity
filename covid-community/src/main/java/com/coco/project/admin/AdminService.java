package com.coco.project.admin;

import java.util.Map;

import com.coco.project.register.RegisterDTO;
import com.coco.project.review.ReviewDTO;

public interface AdminService {
	
	// 관리자페이지 - 유저 정보
	public Map<String,Object> userList(Map<String, Object> reqInfo) throws Exception;
	// 관리자 페이지 - 유저정보 수정
	public int userUpdate(RegisterDTO registerDTO) throws Exception;
	// 관리자 페이지 - 게시글 정보
	public Map<String,Object> boardList(Map<String, Object> reqInfo) throws Exception;
	// 관리자 페이지 - 게시글정보 수정
	public int boardUpdate(ReviewDTO reviewDTO) throws Exception;
}
