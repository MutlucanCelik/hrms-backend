package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;

public interface EmployerService {

	public Result add(Employer employer);
	
	public DataResult<List<Employer>> getAll();	
}
