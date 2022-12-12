package com.jobsearch.job.service;

import java.util.List;

import com.jobsearch.job.entity.JobEntity;

public interface JobService {
	//get all jobs
	public List<JobEntity> getAllJobs();
	//add job
	public JobEntity addJob(JobEntity jobEntity);
	//get job by skill, location or both
	public List<JobEntity> viewJobs(String skill, String location);
	//delete job by id
	public String deleteJob(int id);
}
