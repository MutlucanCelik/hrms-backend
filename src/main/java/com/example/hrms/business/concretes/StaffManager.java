package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.StaffService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.StaffDao;
import com.example.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService{

	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public Result add(Staff staff) {
		try {
			staffDao.save(staff);
			return new SuccessResult("Staff created.");
		} catch (Exception e) {
			return new ErrorResult("something went wrong");
		}
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		try {
			return new SuccessDataResult(staffDao.findAll(),"Employers listed.");
		} catch (Exception e) {
			return new ErrorDataResult("something went wrong");
		}
	}
	
}
