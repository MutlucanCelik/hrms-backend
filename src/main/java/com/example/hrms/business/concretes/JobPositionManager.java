package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		try {
			jobPositionDao.save(jobPosition);
			return new SuccessResult("Job position created.");
		} catch (Exception e) {
			return new ErrorResult("something went wrong");
		}
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		try {
			return new SuccessDataResult(jobPositionDao.findAll(),"Job positions listed.");
		} catch (Exception e) {
			return new ErrorDataResult("something went wrong");
		}
		
	}
	
}
