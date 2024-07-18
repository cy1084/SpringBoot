package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.JobsVo;

public interface IJobsService {
	public List<JobsVo> allSeLectJob();

	public int insertJob(JobsVo vo);

	public int updateJob();
	
	public int transaction(JobsVo vo); //인서트 업데이트 같이 실행

}
