package com.example.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/job-seekers")
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		
		return jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}
}
