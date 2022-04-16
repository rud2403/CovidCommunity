package com.coco.project.review;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewMapper reviewMapper;
	
	// 후기 게시판 - 글쓰기
	@Override
	public int reviewBoardWrite(ReviewDTO reviewDTO, MultipartFile file) throws Exception {
	
		// 파일 설정 시작
		if(file.getOriginalFilename() != "") {
			// 파일 경로 설정
			String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
			
			UUID uuid = UUID.randomUUID();
			
			String fileName = uuid + "_" + file.getOriginalFilename();
			
			// 파일 객체 생성 File(경로, 이름)
			File saveFile = new File(projectPath, fileName); 
			
			file.transferTo(saveFile);
			
			reviewDTO.setRbFileName(fileName);
			reviewDTO.setRbFilePath("/files/" + fileName);
		}
		// 파일 설정 끝
		
		
		int result = reviewMapper.reviewBoardWrite(reviewDTO);
		
		return result;
	}
	
	// 후기 게시판 - 글수정
	@Override
	public int reviewBoardUpdate(ReviewDTO reviewDTO, MultipartFile file) throws Exception {
		
		// 파일 설정 시작
		if(file.getOriginalFilename() != "") {
			// 파일 경로 설정
			String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
			
			UUID uuid = UUID.randomUUID();
			
			String fileName = uuid + "_" + file.getOriginalFilename();
			
			// 파일 객체 생성 File(경로, 이름)
			File saveFile = new File(projectPath, fileName); 
			
			file.transferTo(saveFile);
			
			reviewDTO.setRbFileName(fileName);
			reviewDTO.setRbFilePath("/files/" + fileName);
		}
		// 파일 설정 끝
		
		
		int result = reviewMapper.reviewBoardUpdate(reviewDTO);
		
		return result;
	}
	
	// 후기 게시판 - 리스트 가져오기
	@Override
	public Map<String, Object> reviewBoardList(Map<String, Object> boardInfo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", reviewMapper.reviewBoardList(boardInfo));
		resultMap.put("totalCnt", reviewMapper.reviewTotalCnt(boardInfo));
		
		return resultMap;
	}
	
	// 후기 게시판 - 게시글 상세정보
	@Override
	public Map<String, Object> reviewBoardDetail(int boardId) {
	// public Map<String, Object> reviewBoardDetail(ReviewDTO reviewDTO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = reviewMapper.reviewBoardDetail(boardId);
		
		return resultMap;
	}
	
	// 후기 게시판 - 조회수 증가
	@Override
	public int reviewBoardViewCnt(HttpServletRequest request, HttpServletResponse response, int boardId) {
		
		Cookie[] cookies = request.getCookies();
		
		// 비교하기 위해 새로운 쿠키
        Cookie viewCookie = null;
        
        int result = 0;
        
        // 쿠키가 있을 경우 
        if (cookies != null && cookies.length > 0) 
        {
            for (int i = 0; i < cookies.length; i++)
            {
                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
                if (cookies[i].getName().equals("cookie"+boardId))
                { 
                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
                    viewCookie = cookies[i];
                }
            }
        }
        
        if (viewCookie == null) {    
            System.out.println("cookie 없음");
            
            // 쿠키 생성(이름, 값)
            Cookie newCookie = new Cookie("cookie"+boardId, "|" + boardId + "|");
                            
            // 쿠키 추가
            response.addCookie(newCookie);

            // 쿠키를 추가 시키고 조회수 증가시킴
            // 조회수 증가하는 Service
            result = reviewMapper.reviewBoardViewCnt(boardId);
            
            if(result>0) {
                System.out.println("조회수 증가");
            }else {
                System.out.println("조회수 증가 에러");
            }
        }
        // viewCookie가 null이 아닐경우 쿠키가 있으므로 조회수 증가 로직을 처리하지 않음.
        else {
            System.out.println("cookie 있음");
            
            // 쿠키 값 받아옴.
            String value = viewCookie.getValue();
            
            System.out.println("cookie 값 : " + value);
    
        }
		
		return result;
	}
	
	// 후기 게시판 삭제
	@Transactional
	@Override
	public int reviewBoardDelete(int boardId) {
		
		int result = -1;
		
		result = reviewMapper.reviewBoardDelete(boardId);
		
		return result;
	}
	
	// 후기 게시판 좋아요 총 개수 가져오기
	@Override
	public int reviewLikeCnt(int boardId) {
		
		int result = reviewMapper.reviewLikeCnt(boardId);
		
		return result;
	}
	
	// 후기 게시판 좋아요 활성화
	@Override
	public int reviewLikeActive(int boardId, Integer rcWriter) {
		
		int result = reviewMapper.reviewLikeActive(boardId, rcWriter);
		
		return result;
	}
}
