package com.jobsearch.job.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.job.controller.JobContoller;
import com.jobsearch.job.entity.JobEntity;
import com.jobsearch.job.repo.JobRepo;

@Service
public class JobServiceImpl implements JobService {
	Logger logger = LoggerFactory.getLogger(JobContoller.class);
	
	@Autowired
	private JobRepo jobRepo;

	@Override
	//Get all jobs
	public List<JobEntity> getAllJobs() {
		logger.info("JobService - getAllJobs Running");
		return jobRepo.findAll();
	}

	@Override
	//Add Jobs
	public JobEntity addJob(JobEntity jobEntity) {
		logger.info("JobService - addJob Running");
		jobRepo.save(jobEntity);
		logger.info("JobService - getAllJobs Running");
		return jobEntity;
	}

	@SuppressWarnings("unused")
	@Override
	//Get job by skill and location
	public List<JobEntity> viewJobs(String skill, String location) {
		logger.info("JobService - viewJobs Running");
		//if user pass null value in skill will return job only by location
		if (skill==null) {
			logger.warn("No value has been passed for skill");
			return jobRepo.getJobsByLocation(location);
		}
		//if user pass null value in location it will return job only by skill
		else if (location==null) {
			logger.warn("No value has been passed for location");
			return jobRepo.getJobsBySkill(skill);
		}
		//if user pass both null values it will return all jobs
		else if (skill == null && location == null) {
			logger.warn("No value has been passed for location");
			return jobRepo.findAll();
		}
		//if both values are passed it will return jobs by skill and location
		else {
			return jobRepo.getJobs(location, skill);	
		}
		
	}

	@Override
	//delete job by id
	public String deleteJob(int id) {
		logger.info("JobService - DeleteJob Running");
		jobRepo.deleteById(id);
		
		return "Job Deleted Successfully";
	}
	
	
}
