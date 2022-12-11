package com.jobsearch.job.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobsearch.job.entity.JobEntity;

@Repository
public interface JobRepo  extends JpaRepository<JobEntity, Integer>{
	
	@Query(nativeQuery = true, value = "select * from job_entity where job_location like %?1% and skills_required like %?2%")
	List<JobEntity> getJobs(String location, String skill);
	
	@Query(nativeQuery = true, value = "select * from job_entity where skills_required like %?1%")
	List<JobEntity> getJobsBySkill(String skill);
	
	@Query(nativeQuery = true, value = "select * from job_entity where job_location like %?1%")
	List<JobEntity> getJobsByLocation(String location);
}
