package com.coco.project.review;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

	public int reviewBoardWrite(ReviewDTO reviewDTO);
}
