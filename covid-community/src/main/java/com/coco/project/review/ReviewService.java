package com.coco.project.review;

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
}
