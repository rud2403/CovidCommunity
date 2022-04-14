package com.coco.project.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController implements ErrorController{

	@GetMapping("/error403")
	public String getAccessDenied() {
        return "/error/error403";
    }
	
	@GetMapping("/error")
	public String error404() {
        return "/error/error404";
    }
}
