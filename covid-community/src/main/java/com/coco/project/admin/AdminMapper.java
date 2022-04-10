package com.coco.project.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
	
	// 관리자페이지 - 유저 정보
	public List<Map<String,Object>> userList(Map<String,Object> reqInfo);
	// 관리자페이지 - 유저정보 총개수
	public int userListCnt(Map<String,Object> reqInfo);
}
