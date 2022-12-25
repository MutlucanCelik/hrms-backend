package com.example.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "description")
	private String jobDescription;

	@NotNull
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@NotNull
	@Column(name = "salary_min")
	private String salaryMin;

	@NotNull
	@Column(name = "salary_max")
	private String salaryMax;

	@NotNull
	@Column(name = "posting_date")
	private LocalDateTime postingDate;

	@NotNull
	@Column(name = "closing_date")
	private LocalDate closingDate;

	@NotNull
	@Column(name = "is_active")
	private boolean isActive;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

}
