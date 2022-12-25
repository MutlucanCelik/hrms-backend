package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Staff;

public interface StaffService {

	public Result add(Staff staff);
	
	public DataResult<List<Staff>> getAll();
}
