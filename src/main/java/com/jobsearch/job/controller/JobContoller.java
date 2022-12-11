package com.jobsearch.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobsearch.job.entity.JobEntity;
import com.jobsearch.job.service.JobServiceImpl;

@RestController
public class JobContoller {
	@Autowired
	private JobServiceImpl jobServiceImpl;
	
	@GetMapping("/alljobs")
	public List<JobEntity> getAllJobs() {
		return this.jobServiceImpl.getAllJobs();
	}
	
	@PostMapping("/jobs")
	public JobEntity addJob(@RequestBody JobEntity jobEntity) {
		return this.jobServiceImpl.addJob(jobEntity);
	}
	
	@GetMapping("/jobs")
	public List<JobEntity> getJob(@RequestParam(required = false) String location, @RequestParam(required = false) String skill){
		return this.jobServiceImpl.viewJobs(skill, location);
	}
}
