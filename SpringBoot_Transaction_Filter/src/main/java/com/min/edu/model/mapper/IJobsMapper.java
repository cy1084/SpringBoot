package com.min.edu.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.min.edu.vo.JobsVo;

//마이바티스 실행 dao
@Mapper
public interface IJobsMapper {
	public List<JobsVo> allSeLectJob();

	public int insertJob(JobsVo vo);

	public int updateJob();

}
