package com.coco.project.comment;

import java.util.Map;

public interface CommentService {

	// 댓글 - 글쓰기
	public int commentWrite(CommentDTO commentDTO) throws Exception;
	// 댓글 - 리스트 가져오기
	public Map<String, Object> commentList(int boardId) throws Exception;
	// 대댓글 - 작성
	public int reCommentWrite(CommentDTO commentDTO) throws Exception;
	// 댓글 - 수정
	public int commentUpdate(CommentDTO commentDTO) throws Exception;
	// 댓글 - 삭제
	public int commentDelete(CommentDTO commentDTO) throws Exception;
}
