package com.coco.project.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	
	// 관리자페이지 - 유저 정보
	public Map<String,Object> userList(Map<String, Object> reqInfo){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("list", adminMapper.userList(reqInfo));
		resultMap.put("totalCnt", adminMapper.userListCnt(reqInfo));
		
		return resultMap;
	}
}
