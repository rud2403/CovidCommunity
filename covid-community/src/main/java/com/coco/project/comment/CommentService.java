package com.coco.project.comment;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	// 댓글 - 글쓰기
	@Transactional
	public int commentWrite(CommentDTO commentDTO) throws Exception {
	
		int result = commentMapper.commentWrite(commentDTO);
		
		return result;
	}
	
	// 댓글 - 리스트 가져오기
	public Map<String, Object> commentList(int boardId) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("list", commentMapper.commentList(boardId));
		resultMap.put("cnt", commentMapper.commentCnt(boardId));
		
		return resultMap; 
	}
	
	// 대댓글 - 작성
	@Transactional
	public int reCommentWrite(CommentDTO commentDTO) throws Exception {
		
		commentMapper.reRefUpdate(commentDTO);
		int result = commentMapper.reCommentWrite(commentDTO);
		
		return result;
	}
	
	// 댓글 - 수정
	@Transactional
	public int commentUpdate(CommentDTO commentDTO) throws Exception {
		
		int result = commentMapper.commentUpdate(commentDTO);
		
		return result;
	}
	
	// 댓글 - 삭제
	public int commentDelete(CommentDTO commentDTO) throws Exception {
		
		int result = commentMapper.commentDelete(commentDTO);
		
		return result;
	}
	
}
