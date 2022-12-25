package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.City;

public interface CityService {
public Result add(City city);
	
	public DataResult<List<City>> getAll();
}
