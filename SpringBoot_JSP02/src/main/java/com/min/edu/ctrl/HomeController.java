package com.min.edu.ctrl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String home() throws UnsupportedEncodingException {
		//스프링 부트엔 웰컴파일이 없기 때문에 컨텍스트 루트가 첫페이지. 여기서 리다이렉트로 첫페이지로 원하는 화면 설정
		log.info("springboot_jsp 처음 호출되는 @GetMapping");
		
		String name=URLEncoder.encode("한글","UTF-8");
		
		return "redirect:/info.do?name="+name+"&age=100";
		//리다이렉트는 인코딩이 안되기 때문에 인코딩 설정 따로 해줘야 함
	}
	
	@GetMapping(value="/info.do")
	public String info(UserDTO dto,Model model) {
		
		log.info("info 메소드","전달받은 파라미터 {}",dto);
		model.addAttribute("infoname",dto.getName());
		model.addAttribute("infoage",dto.getAge());
		
		return "info";
	}
}
