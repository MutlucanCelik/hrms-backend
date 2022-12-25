package com.example.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import com.example.hrms.entities.concretes.JobPosting;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {

		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		try {
			return new SuccessResult("City created.");
		} catch (Exception e) {
			return new ErrorResult("something went wrong");
		}
	}

	@Override
	public DataResult<List<City>> getAll() {
		try {
			return new SuccessDataResult<List<City>>(cityDao.findAll(),"Cities listed.");
		} catch (Exception e) {
			return new ErrorDataResult("something went");
		}
	}
	
}
