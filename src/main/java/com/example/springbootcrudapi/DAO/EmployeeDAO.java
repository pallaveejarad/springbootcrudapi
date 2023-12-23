package com.example.springbootcrudapi.DAO;

import java.util.List;

import com.example.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	
	public List<Employee> get();
	
    public	Employee get(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);
	
	public String update(Employee emp);
	

}
