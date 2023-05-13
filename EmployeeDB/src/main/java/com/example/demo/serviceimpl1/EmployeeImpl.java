package com.example.demo.serviceimpl1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model1.Employee;
import com.example.demo.repo1.EmployeeRepo;
import com.example.demo.service1.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	EmployeeRepo ep;

	@Override
	public Employee addEmployee(Employee e) {
		return ep.save(e);
	}

	@Override
	public Employee getByEmployeeId(Integer eid) {
		return ep.findById(eid).orElseThrow(()-> new ResourceNotFound("Employee", "ID", eid) );
	}

	@Override
	public List<Employee> getByJob(String jod) {
		// TODO Auto-generated method stub
		return ep.findByJob(jod);
	}

	@Override
	public List<Employee> getByLessSal(Double sal) {
		// TODO Auto-generated method stub
		return ep.findByLessSal(sal);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1=ep.findById(e.getEid()).orElse(null);
		if(e1!=null) {
			e1.setEname(e.getEname());
			e1.setJod(e.getJod());
			e1.setPhno(e.getPhno());
			e1.setSal(e.getSal());
			return ep.save(e1);
		}
		else {
			throw new ResourceNotFound("Employee", "eid", e.getEid());
		}


	}

	@Override
	public Employee deleteEmployee(Integer eid) {
		Employee e=ep.findById(eid).orElse(null);
		if(e!=null) {
			 ep.deleteById(eid);
			 return e;
		}
		else {
			throw new ResourceNotFound("Employee", "eid", e.getEid());
		}
		
	}


}
