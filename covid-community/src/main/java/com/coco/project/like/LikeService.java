package com.coco.project.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
	
	@Autowired
	LikeMapper likeMapper;
	
	// 후기 게시판 좋아요 - 좋아요 찾기
	public int likeSearch(LikeDTO likeDTO) {
		
		int result = -1;
		
		result = likeMapper.likeSearch(likeDTO);
		
		return result;
	}
	
	// 후기 게시판 좋아요 - 좋아요 추가
	@Transactional
	public int likeInsert(LikeDTO likeDTO) {
		
		int result = -1;
		
		result = likeMapper.likeInsert(likeDTO);
		
		return result;
	}
	
	// 후기 게시판 좋아요 - 좋아요 취소
	@Transactional
	public int likeDelete(LikeDTO likeDTO) {
		
		int result = -1;
		
		result = likeMapper.likeDelete(likeDTO);
		
		return result;
	}
}
