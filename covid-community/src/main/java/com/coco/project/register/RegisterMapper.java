package com.coco.project.register;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

	// 이메일 중복체크
	public int emailCheck(String userEmail);
}
