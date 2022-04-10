package com.coco.project.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api")
public class AdminApiController {

	@Autowired
	AdminService adminservice;
	
	// 관리자페이지 - 유저 목록
	@GetMapping("/userList")
	public ResponseEntity<Object> userList(@RequestParam Map<String, Object> reqInfo){
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = adminservice.userList(reqInfo);
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
}
