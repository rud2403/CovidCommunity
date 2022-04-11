package com.coco.project.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coco.project.register.RegisterDTO;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	// 관리자페이지 - 유저 정보
	public Map<String,Object> userList(Map<String, Object> reqInfo){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("list", adminMapper.userList(reqInfo));
		resultMap.put("totalCnt", adminMapper.userListCnt(reqInfo));
		
		return resultMap;
	}
	
	// 관리자 페이지 - 유저정보 수정
	public int userUpdate(RegisterDTO registerDTO) {
		
		if(registerDTO.getUserPw() != null && registerDTO.getUserPw() != "") {
			registerDTO.setUserPw(bcryptPasswordEncoder.encode(registerDTO.getUserPw()));
		}
		int userUpdate = adminMapper.userUpdate(registerDTO);
		
		return userUpdate; 
	}
	
	// 관리자 페이지 - 게시글 정보
	public Map<String,Object> boardList(Map<String, Object> reqInfo){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("list", adminMapper.boardList(reqInfo));
		resultMap.put("totalCnt", adminMapper.boardListCnt(reqInfo));
		
		return resultMap;
	}
}
