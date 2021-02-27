package com.springProject.springBootRest.Service;

import java.util.List;

import com.springProject.springBootRest.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int emp);
	 	
	public void save(Employee emp);
	
	public void deleteById(int emp);
	
}
