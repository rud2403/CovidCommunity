package com.coco.project.register;

import lombok.Data;

@Data
public class RegisterDTO {

	private String userEmail;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userAddr;
	private String userRole;
	private int userEnabled;
	
}
