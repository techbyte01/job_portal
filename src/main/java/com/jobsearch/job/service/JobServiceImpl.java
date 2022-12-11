package com.jobsearch.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.job.entity.JobEntity;
import com.jobsearch.job.repo.JobRepo;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepo jobRepo;

	@Override
	public List<JobEntity> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public JobEntity addJob(JobEntity jobEntity) {
		jobRepo.save(jobEntity);
		return jobEntity;
	}

	@SuppressWarnings("unused")
	@Override
	public List<JobEntity> viewJobs(String skill, String location) {
		if (skill==null) {
			return jobRepo.getJobsByLocation(location);
		}
		else if (location==null) {
			return jobRepo.getJobsBySkill(skill);
		}
		else if (skill == null && location == null) {
			return jobRepo.findAll();
		}
		else {
			return jobRepo.getJobs(location, skill);	
		}
		
	}
	
	
}
