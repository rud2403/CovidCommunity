package com.coco.project.error;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.control.messages.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> common(Exception e) {
		
		Map<String, Object> registerResult = new HashMap<>();
		
		registerResult.put("result", e + "에러가 발생하였습니다.");
		
        return new ResponseEntity<>(registerResult, HttpStatus.OK);
	}
}
