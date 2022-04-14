package com.coco.project.main;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

	// 후기 게시판 최신글
	List<Map<String,Object>> latestBoardList();
	// 후기 게시판 인기글
	List<Map<String,Object>> popBoardList();
}
