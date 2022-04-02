package com.coco.project.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	// 댓글 - 글쓰기
	public int commentWrite(CommentDTO commentDTO);
	// 댓글 - 리스트 가져오기
	public List<Map<String,Object>> commentList(int boardId);
	// 댓글 - 개수
	public int commentCnt(int boardId);
	// 대댓글 작성 시 ref 업데이트
	public void reRefUpdate(CommentDTO commentDTO);
	// 대댓글 - 작성
	public int reCommentWrite(CommentDTO commentDTO);
	// 댓글 - 수정
	public int commentUpdate(CommentDTO commentDTO);
	// 댓글 - 삭제
	public int commentDelete(CommentDTO commentDTO);
}
