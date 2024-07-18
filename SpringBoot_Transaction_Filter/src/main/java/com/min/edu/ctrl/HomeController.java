package com.min.edu.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.model.service.IJobsService;
import com.min.edu.vo.JobsVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//요청 처리 위한 컨트롤러
@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	private final IJobsService service;
	
	@GetMapping(value="/")
	public String welcomePage() {
		return "intro";
	}
	
	@GetMapping(value="/selectJobs.do")
	public String selectAll(Model model) {
		List<JobsVo> lists= service.allSeLectJob();
		model.addAttribute("lists",lists);
		
		return "result";
	}
	
	@PostMapping(value="/insertJob.do")
	public String insertJob(JobsVo vo, Model model) {
		int cnt=service.insertJob(vo);
		
		model.addAttribute("insertResult",cnt);
		return "result";
	}
	
	@GetMapping(value="/updateJob.do")
	public String updateJob(Model model) {
		int cnt= service.updateJob();
		model.addAttribute("updateResult",cnt);
		
		return "result";
	}
	
	@GetMapping(value="transaction.do")
	public String transaction(Model model) {
		log.info("home controller transaction 처리");
		
			JobsVo vo=new JobsVo("AI_Man","인공지능",100,1000);
			int cnt=service.transaction(vo);
			
			model.addAttribute("transaction result",cnt);
		
		return "result";
	}
}

