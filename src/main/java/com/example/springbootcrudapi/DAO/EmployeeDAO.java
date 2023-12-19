package com.example.springbootcrudapi.DAO;

import java.util.List;

import com.example.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
	

}
