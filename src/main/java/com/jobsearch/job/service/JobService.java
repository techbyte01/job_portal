package com.jobsearch.job.service;

import java.util.List;

import com.jobsearch.job.entity.JobEntity;

public interface JobService {
	public List<JobEntity> getAllJobs();
	public JobEntity addJob(JobEntity jobEntity);
	public List<JobEntity> viewJobs(String skill, String location);
}
