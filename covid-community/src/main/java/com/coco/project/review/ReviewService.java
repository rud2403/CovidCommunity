package com.coco.project.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coco.project.register.RegisterMapper;

@Service
public class ReviewService {

	@Autowired
	ReviewMapper reviewMapper;
	
	// 리뷰 게시판 - 글쓰기
	public int reviewBoardWrite(ReviewDTO reviewDTO) {
	
		int result = reviewMapper.reviewBoardWrite(reviewDTO);
		
		return result;
	}
	
	// 리뷰 게시판 - 리스트 가져오기
	public Map<String, Object> reviewBoardList(Map<String, Object> boardInfo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", reviewMapper.reviewBoardList(boardInfo));
		
		return resultMap;
	}
}
