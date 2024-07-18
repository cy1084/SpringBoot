package com.min.edu.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IJobsMapper;
import com.min.edu.vo.JobsVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//dao를 조합하여 transaction 처리
@Slf4j
@Service
@RequiredArgsConstructor
public class JobsServiceImpl implements IJobsService {

	private final IJobsMapper dao;

	@Override
	public List<JobsVo> allSeLectJob() {

		return dao.allSeLectJob();
	}

	@Override
	public int insertJob(JobsVo vo) {

		return dao.insertJob(vo);
	}

	@Override
	public int updateJob() {

		return dao.updateJob();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int transaction(JobsVo vo) {

		log.info("트랜잭션 동작");

		int n = dao.updateJob();
		int m = dao.insertJob(vo);

		return (n + m) > 0 ? 1 : 0;
	}

}
