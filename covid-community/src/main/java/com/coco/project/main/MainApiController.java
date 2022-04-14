package com.coco.project.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/api")
public class MainApiController {

	@Autowired
	MainService mainService;
	
	
	@GetMapping("/boardList")
	public ResponseEntity<Object> boardList(){
		
		Map<String, Object> boardList = new HashMap<>();
		
		boardList = mainService.boardList();
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
}
