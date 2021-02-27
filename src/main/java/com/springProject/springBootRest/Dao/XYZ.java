package com.springProject.springBootRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springProject.springBootRest.entity.Employee;

public interface XYZ extends JpaRepository<Employee, Integer>{

}
