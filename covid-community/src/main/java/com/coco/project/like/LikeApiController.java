package com.coco.project.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.log4jdbc.log.log4j2.Log4j2SpyLogDelegator;

@RestController
@RequestMapping("like/api")
public class LikeApiController {
	
	@Autowired
	LikeService likeService;
	
	@PostMapping("/likeInsert")
	public ResponseEntity<Object> likeInsert(@RequestBody LikeDTO likeDTO) {
		
		int insertResult = -1;
		int deleteResult = -1;
		
		int searchResult = likeService.likeSearch(likeDTO);
		
		// 좋아요한 게시글이 없을 경우
		if(searchResult == 0) {
			// 좋아요 추가
			insertResult = likeService.likeInsert(likeDTO);
		// 좋아요한 게시글이 있을 경우
		} else {
			// 좋아요 취소
			deleteResult = likeService.likeDelete(likeDTO);
			if(deleteResult == 1) {
				insertResult = 0;
			} else {
				insertResult = -1;
			}
		}
		
		
		
		return new ResponseEntity<>(insertResult, HttpStatus.OK);
	}
}
