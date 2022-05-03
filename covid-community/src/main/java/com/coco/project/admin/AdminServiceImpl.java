package com.coco.project.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coco.project.register.RegisterDTO;
import com.coco.project.review.ReviewDTO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// 관리자페이지 - 유저 정보
	@Override
	public Map<String,Object> userList(Map<String, Object> reqInfo) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("list", adminMapper.userList(reqInfo));
		resultMap.put("totalCnt", adminMapper.userListCnt(reqInfo));
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> userInfo(String uId) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap = adminMapper.userInfo(uId);
		
		return resultMap;
	}
	
	
	// 관리자 페이지 - 유저정보 수정
	@Override
	public int userUpdate(RegisterDTO registerDTO) throws Exception {
		
		if(registerDTO.getUserPw() != null && registerDTO.getUserPw() != "") {
			registerDTO.setUserPw(bcryptPasswordEncoder.encode(registerDTO.getUserPw()));
		}
		int userUpdate = adminMapper.userUpdate(registerDTO);
		
		return userUpdate; 
	}
	
	// 관리자 페이지 - 게시글 리스트
	@Override
	public Map<String,Object> boardList(Map<String, Object> reqInfo) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("list", adminMapper.boardList(reqInfo));
		resultMap.put("totalCnt", adminMapper.boardListCnt(reqInfo));
		
		return resultMap;
	}
	
	// 관리자 페이지 - 게시글 정보
	@Override
	public Map<String, Object> boardInfo(String rbId) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = adminMapper.boardInfo(rbId);
		
		return resultMap;
	}
	
	// 관리자 페이지 - 게시글정보 수정
	@Override
	public int boardUpdate(ReviewDTO reviewDTO) throws Exception {
		
		int boardUpdate = adminMapper.boardUpdate(reviewDTO);
		
		return boardUpdate;
	}
}
