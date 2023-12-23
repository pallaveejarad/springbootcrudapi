package com.example.springbootcrudapi.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootcrudapi.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
	Session currentSession= entityManager.unwrap(Session.class);
	Employee empObj=currentSession.get(Employee.class, id);
	return empObj;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession= entityManager.unwrap(Session.class);
		currentSession.persist(employee);
	}

	@Override
	public void delete(int id) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		Employee empObj = currentSession.get(Employee.class, id);
		currentSession.remove(empObj);
	}
	
	@Override
	public String update(Employee employee) {
		Session currentSession= entityManager.unwrap(Session.class);
		Employee emp = entityManager.find(Employee.class, employee.getId());
		if(emp != null) {
			emp.setName(employee.getName());
			emp.setGender(emp.getGender());
			emp.setDob(employee.getDob());
		    emp.setDepartment(employee.getDepartment());
		currentSession.merge(employee);
		} else {
			return "data not found";
		}
		return "success";
	}

}
