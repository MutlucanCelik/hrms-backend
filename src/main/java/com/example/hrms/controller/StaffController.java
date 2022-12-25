package com.example.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.StaffService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Staff;

@RestController
@RequestMapping("api/staff")
public class StaffController {

	private StaffService staffService;

	@Autowired
	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Staff staff) {
		
		return staffService.add(staff);
	}
	
	@GetMapping("getAll")
	public DataResult<List<Staff>> getAll() {
		return staffService.getAll();
	}
	
}
