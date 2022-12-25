package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		
		try {
			jobPostingDao.save(jobPosting);
			return new SuccessResult("Job posting created.");
		} catch (Exception e) {
			return new ErrorResult("something went wrong");
		}
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		try {
			return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(),"Job postings listed.");
		} catch (Exception e) {
			return new ErrorDataResult("something went");
		}
		
	}
	
}
