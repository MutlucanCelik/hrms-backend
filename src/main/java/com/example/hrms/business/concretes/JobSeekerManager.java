package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		try {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job seeker created.");
		} catch (Exception e) {
			return new ErrorResult("something went wrong");
		}
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		try {
			return new SuccessDataResult(jobSeekerDao.findAll(),"Job seeker listed.");
		} catch (Exception e) {
			return new ErrorDataResult("something went wrong");
		}
	}
	
}
