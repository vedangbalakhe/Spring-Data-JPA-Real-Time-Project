package com.springProject.springBootRest.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springProject.springBootRest.Service.EmployeeService;
import com.springProject.springBootRest.entity.Employee;

@RestController
public class EmployeeRest {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRest(EmployeeService emp)
	{
		employeeService=emp;
	}
	
	@GetMapping("/listall")
	public List<Employee> listAll()
	{
		return employeeService.findAll();
	}
//	
//	@GetMapping("ListById")
//	public Employe
	@GetMapping("employee/{employeeId}")
	public Employee findById(@PathVariable int employeeId)
	{
		Employee emp=employeeService.findById(employeeId);
		if(emp==null)
		
		 throw new RuntimeException("Not found"+employeeId);
		return emp;
	}
	@PostMapping("/addEmployee")
	public Employee addEmp(@RequestBody Employee theEmp)
	{
		theEmp.setId(0);
		employeeService.save(theEmp);
		return theEmp;
	}
	@PutMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee theEmp)
	{
		employeeService.save(theEmp);
		return theEmp;		
	}
	@DeleteMapping("/delete/{employeeId}")
	public String emp(@PathVariable int employeeId)
	{
		Employee emp=employeeService.findById(employeeId);
		
		if (emp==null)
			throw new RuntimeException("Invalid");
		employeeService.deleteById(employeeId);
		return "Deleted employee id "+employeeId;
			
		
	
	}

}
