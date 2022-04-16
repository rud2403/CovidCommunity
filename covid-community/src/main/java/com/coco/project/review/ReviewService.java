package com.coco.project.review;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface ReviewService {

	// 후기 게시판 - 글쓰기
	public int reviewBoardWrite(ReviewDTO reviewDTO, MultipartFile file) throws Exception;
	// 후기 게시판 - 글수정
	public int reviewBoardUpdate(ReviewDTO reviewDTO, MultipartFile file) throws Exception;
	// 후기 게시판 - 리스트 가져오기
	public Map<String, Object> reviewBoardList(Map<String, Object> boardInfo) throws Exception;
	// 후기 게시판 - 게시글 상세정보
	public Map<String, Object> reviewBoardDetail(int boardId) throws Exception;
	// 후기 게시판 - 조회수 증가
	public int reviewBoardViewCnt(HttpServletRequest request, HttpServletResponse response, int boardId) throws Exception;
	// 후기 게시판 삭제
	public int reviewBoardDelete(int boardId) throws Exception;
	// 후기 게시판 좋아요 총 개수 가져오기
	public int reviewLikeCnt(int boardId) throws Exception;
	// 후기 게시판 좋아요 활성화
	public int reviewLikeActive(int boardId, Integer rcWriter) throws Exception;
}
