package com.coco.project.register;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "register/api")
public class RegisterApiController {

	@Autowired
	RegisterService registerService;
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	// 이메일 중복체크
	@PostMapping(value = "/emailCheck")
    public ResponseEntity<Object> emailCheck(@RequestBody String userEmail) throws Exception{
		
		int result = -1;
		
		if(userEmail != null && userEmail !="") {
			result = registerService.emailCheck(userEmail);	
		}
		
		HashMap<String, Integer> saveResult = new HashMap<>();
		
		// 중복된 이메일
		if(result == 1) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		// 중복되지 않은 이메일
		} else if(result == 0) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		}
		
		saveResult.put("result", result);
		return new ResponseEntity<>(saveResult, HttpStatus.OK);
    }
	
	// 닉네임 중복체크
	@PostMapping(value = "/nameCheck")
    public ResponseEntity<Object> nameCheck(@RequestBody String userName) throws Exception{
		
		int result = -1;
		
		if(userName != null && userName !="") {
			result = registerService.nameCheck(userName);
		}
		
		HashMap<String, Integer> saveResult = new HashMap<>();
		
		// 중복된 닉네임
		if(result == 1) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		// 중복되지 않은 닉네임
		} else if(result == 0) {
			saveResult.put("result", result);
			return new ResponseEntity<>(saveResult, HttpStatus.OK);
		}
		
		saveResult.put("result", result);
		return new ResponseEntity<>(saveResult, HttpStatus.OK);
    }
	
	// 이메일 인증
	@PostMapping(value = "/certiEmail")
    public Map<String, String> certiEmail(@RequestBody String userEmail) {
		
		// String[] strArr = userEmail.replace("=", "").split("%40");
		
		// userEmail = strArr[0] + "@" + strArr[1];
		
		Random random=new Random();  //난수 생성을 위한 랜덤 클래스
		String key="";  //인증번호 

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
		//입력 키를 위한 코드
		for(int i =0; i<3;i++) {
			int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
			key+=(char)index;
		}
		int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
		key+=numIndex;
		message.setSubject("인증번호 입력을 위한 메일 전송");
		message.setText("인증 번호 : "+key);
		javaMailSender.send(message);
		
		Map<String, String> result = new HashMap<>();
		
		result.put("key", key);
		
        return result;
    }
	
	// 유저 회원가입
	@PostMapping(value = "/userRegister")
    public ResponseEntity<Object> userRegister(@RequestBody RegisterDTO registerDTO) {
		
		int result = registerService.userRegister(registerDTO);
		
		Map<String, Object> registerResult = new HashMap<>();
		
		registerResult.put("result", result);
        return new ResponseEntity<>(registerResult, HttpStatus.OK);
    }
	
}
