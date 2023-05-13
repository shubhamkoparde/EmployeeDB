package com.example.demo.service1;

import java.util.List;

import com.example.demo.model1.Employee;

public interface EmployeeService {

	
	Employee addEmployee(Employee e);
	Employee getByEmployeeId(Integer eid);
	
	List<Employee> getByJob(String jod);
	List<Employee> getByLessSal(Double sal);
	Employee updateEmployee(Employee e);
	Employee deleteEmployee(Integer eid);

}
