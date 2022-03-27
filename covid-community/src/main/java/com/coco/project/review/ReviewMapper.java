package com.coco.project.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	// 리뷰 게시판 - 게시글 작성
	public int reviewBoardWrite(ReviewDTO reviewDTO);
	
	// 리뷰 게시판 - 게시글 총 개수 가져오기
	public int reviewTotalCnt(Map<String,Object> boardInfo);
	
	// 리뷰 게시판 - 게시글 조회
	public List<Map<String,Object>> reviewBoardList(Map<String,Object> boardInfo);
}
