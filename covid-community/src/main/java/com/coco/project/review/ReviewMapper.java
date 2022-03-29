package com.coco.project.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	// 후기 게시판 - 게시글 작성
	public int reviewBoardWrite(ReviewDTO reviewDTO);
	// 후기 게시판 - 게시글 총 개수 가져오기
	public int reviewTotalCnt(Map<String,Object> boardInfo);
	// 후기 게시판 - 게시글 조회
	public List<Map<String,Object>> reviewBoardList(Map<String,Object> boardInfo);
	// 후기 게시판 - 게시글 상세정보
	public Map<String,Object> reviewBoardDetail(int boardId);
	// 후기 게시판 - 게시글 조회수 증가
	public int reviewBoardViewCnt(int boardId);
}
