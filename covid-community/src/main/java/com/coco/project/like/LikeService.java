package com.coco.project.like;

import org.springframework.transaction.annotation.Transactional;

public interface LikeService {

	// 후기 게시판 좋아요 - 좋아요 찾기
		public int likeSearch(LikeDTO likeDTO) throws Exception;
		// 후기 게시판 좋아요 - 좋아요 추가
		public int likeInsert(LikeDTO likeDTO) throws Exception;
		// 후기 게시판 좋아요 - 좋아요 취소
		public int likeDelete(LikeDTO likeDTO) throws Exception;
}
