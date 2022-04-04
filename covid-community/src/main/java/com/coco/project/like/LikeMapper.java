package com.coco.project.like;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
	
	// 후기 게시판 - 좋아요 추가
	public int likeInsert(LikeDTO likeDTO);
	// 후기 게시판 - 좋아요 찾기
	public int likeSearch(LikeDTO likeDTO);
	// 후기 게시판 - 좋아요 취소
	public int likeDelete(LikeDTO likeDTO);
}
