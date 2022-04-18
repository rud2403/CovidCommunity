package com.coco.project.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coco.project.register.RegisterServiceImpl;

@RestController
@RequestMapping(value = "login/api")
public class LoginApiController {
	
	@Autowired
	LoginService loginService;
	
	// 비밀번호 변경
	@Transactional
	@PostMapping(value = "/resetPw")
	public ResponseEntity<Object> resetPw(@RequestBody Map<String, String> userInfo) throws Exception {

		int result = loginService.resetPw(userInfo);

		HashMap<String, Integer> saveResult = new HashMap<>();

		// 패스워드 변경 완료
		if (result == 1) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		// 패스워드 변경 실패
		} else {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		}

	}

}
