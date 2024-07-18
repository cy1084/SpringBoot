package com.min.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/education")
public class HomeController {
	
	//응답정보(성공, 실패 등) 보내는 애
	@GetMapping("/")
	public ResponseEntity<String> fetchDetail(){
		String str="success";
		return ResponseEntity.status(HttpStatus.OK).body(str);
	}
}
