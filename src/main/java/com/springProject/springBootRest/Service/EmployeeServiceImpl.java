package com.springProject.springBootRest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springProject.springBootRest.Dao.XYZ;
import com.springProject.springBootRest.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private XYZ empDao;
	
	@Autowired
	public EmployeeServiceImpl(XYZ theEmp) {
		empDao=theEmp;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee findById(int emp) {
		// TODO Auto-generated method stub
		Optional<Employee> result = empDao.findById(emp);
		
		Employee theEmp=null;
		if(result.isPresent())
			theEmp=result.get();
		else
			throw new RuntimeException("Not found");
		
		return theEmp;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		empDao.save(emp);
		
	}

	

	@Override
	public void deleteById(int emp) {
		// TODO Auto-generated method stub
		empDao.deleteById(emp);
	}
	

}
