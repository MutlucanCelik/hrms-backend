package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	public Result add(JobPosting jobPosting);
	
	public DataResult<List<JobPosting>> getAll();
}
