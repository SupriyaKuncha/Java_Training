package com.ems.EMS.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ems.EMS")
@PropertySource("classpath:application.properties")
public class EmsAppConfig {
//	
//	@Bean
//	public Address address() {
//		Address address = new Address();
//		address.setStreet("Church street");
//		address.setCity("London");
//		address.setState("UK");
//		address.setZipCode("1235");
//		return address;
//	}
//	@Bean
//	public Department department() {
//		Department department = new Department();
//		department.setDeptId(101);
//		department.setDeptName("IT");
//		return department;
//	}
//	
//	@Bean
//	public List<String> skills(){
//		return Arrays.asList("Java","mysql","SpringFrameWork");
//	}
//	
//	@Bean
//	public Employee employee() {
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("Supriya");
//        employee.setEmail("spriya@example.com");
//        employee.setPhone("123-456-7890");
//        employee.setSalary(85000.00);
//        employee.setDesignation("Software Engineer");
//        employee.setAddress(address()); 
//        employee.setDepartment(department()); 
//        employee.setSkills(skills()); 
//        return employee;
//		
//	}
//	@Bean
//	public List<String> projectsHandled(){
//		return Arrays.asList("EcommerceProject","EmployeeManagementProject","Banking Application");
//	}
//	
//	@Bean
//	public Performance performance() {
//		Performance performance = new Performance();
//		performance.setEmployeeid(1);
//		performance.setFeedback("Good");
//		performance.setProjectsHandled(projectsHandled());
//		performance.setRating(5);
//		performance.setEligibleForPromotion(true);
//		
//		return performance;
//		
//	}
//	
//	@Bean
//	public Payroll payroll() {
//		Payroll payroll = new Payroll();
//		payroll.setEmployeeId(1);
//		payroll.setBaseSalary(70000);
//		payroll.setBonuses(5000);
//		payroll.setDeductions(1000);
//		
//		return payroll;
//		
//	}
//	
//	
//	@Bean
//	public Map<Integer, Employee> empRecords(){
//		
//		Map<Integer, Employee> records = new HashMap<>();
//		records.put(1, employee());
//		return records;
//		
//	}
//	@Bean
//	public HR hr() {
//		HR hr = new HR();
//		hr.setEmployeeRecords(empRecords());
//		return hr;
//	}
//
	
	
// value annotation ---------------------------------------------------
// for address -------------------------------------
@Value("${address.street}")
private String street;
@Value("${address.city}")
private String city;
@Value("${address.state}")
private String state;
@Value("${address.zipCode}")
private String zipCode;

@Bean
public Address address() {
	Address address = new Address();
	address.setStreet(street);
	address.setCity(city);
	address.setState(state);
	address.setZipCode(zipCode);
	return address;
}

// department -----------------------------------------

@Value("${department.id}")
private int deptId;
@Value("${department.name}")
private String deptName;

@Bean
public Department department() {
	Department department = new Department();
	department.setDeptId(deptId);
	department.setDeptName(deptName);
	return department;
}

// employee skills
@Value ("${employee.skills}")
private String skillsString;

@Bean
public List<String> skills(){
	return Arrays.asList(skillsString.split(","));
}

// employee
@Value("${employee.id}")
private int empId;
@Value("${employee.name}")
private String empName;
@Value("${employee.email}")
private String empEmail;
@Value("${employee.phone}")
private String empPhone;
@Value("${employee.salary}")
private double empSalary;
@Value("${employee.designation}")
private String empDesignation;

@Bean
public Employee employee() {
    Employee employee = new Employee();
    employee.setId(empId);
    employee.setName(empName);
    employee.setEmail(empEmail);
    employee.setPhone(empPhone);
    employee.setSalary(empSalary);
    employee.setDesignation(empDesignation);
    employee.setAddress(address()); 
    employee.setDepartment(department()); 
    employee.setSkills(skills()); 
    return employee;
	
}

// performance -----------------------------
@Value("${performance.employeeid}")
private int performanceEmpId;
@Value("${performance.rating}")
private double performanceRating;
@Value("${performance.feedback}")
private String performanceFeedback;
@Value("${performance.projectsHandled}")
private String projecthandled;
@Value("${performance.eligibleForPromotion}")
private boolean isEligibleForPromotion;

@Bean
public List<String> projectsHandled(){
	return Arrays.asList(projecthandled.split(","));
}

@Bean
public Performance performance() {
	Performance performance = new Performance();
	performance.setEmployeeid(performanceEmpId);
	performance.setFeedback(performanceFeedback);
	performance.setProjectsHandled(projectsHandled());
	performance.setRating(performanceRating);
	performance.setEligibleForPromotion(isEligibleForPromotion);
	
	return performance;
	
}

// hr
@Bean
public Map<Integer, Employee> empRecords(){
	
	Map<Integer, Employee> records = new HashMap<>();
	records.put(empId, employee());
	return records;
	
}
@Bean
public HR hr() {
	HR hr = new HR();
	hr.setEmployeeRecords(empRecords());
	return hr;
}

// payroll
@Value("${payroll.employeeId}")
private int payrollEmpId;
@Value("${payroll.baseSalary}")
private double baseSalary;
@Value("${payroll.bonuses}")
private double bonuses;
@Value("${payroll.deductions}")
private double deductions;

@Bean
public Payroll payroll() {
	Payroll payroll = new Payroll();
	payroll.setEmployeeId(payrollEmpId);
	payroll.setBaseSalary(baseSalary);
	payroll.setBonuses(bonuses);
	payroll.setDeductions(deductions);
	
	return payroll;
	
}



}
