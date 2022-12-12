package com.jobsearch.job.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobsearch.job.entity.JobEntity;
import com.jobsearch.job.service.JobServiceImpl;

@RestController
//job controller
public class JobContoller {
	
	Logger logger = LoggerFactory.getLogger(JobContoller.class);
	@Autowired
	private JobServiceImpl jobServiceImpl;
	
	
	@GetMapping("/alljobs")
	//get all jobs
	public List<JobEntity> getAllJobs() {
		logger.info("JobController - getAllJobs Running");
		return this.jobServiceImpl.getAllJobs();
	}
	
	
	@PostMapping("/jobs")
	//add jobs
	public JobEntity addJob(@RequestBody JobEntity jobEntity) {
		logger.info("JobController - addJob Running");
		return this.jobServiceImpl.addJob(jobEntity);
	}
	
	
	@GetMapping("/jobs")
	//get jobs by skill, location or both
	public List<JobEntity> getJob(@RequestParam(required = false) String location, @RequestParam(required = false) String skill){
		logger.info("JobController - getJob Running");
		return this.jobServiceImpl.viewJobs(skill, location);
	}
	
	@DeleteMapping("/jobs/{id}")
	//delete job by id
	public String deleteJob(@PathVariable int id) {
		logger.info("JobController - deleteJob Running");
		return this.jobServiceImpl.deleteJob(id);
	}
}
