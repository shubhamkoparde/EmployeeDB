package com.example.demo.repo1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model1.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value="select * from Employee where jod=?1",nativeQuery=true)
	List<Employee> findByJob(String jod);
	
	@Query(value="select * from Employee where sal<=?1",nativeQuery=true)
	List<Employee> findByLessSal(Double sal);
}
