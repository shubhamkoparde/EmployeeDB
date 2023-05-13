package com.example.demo.controller1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model1.Employee;
import com.example.demo.service1.EmployeeService;


@RestController
public class EmployeeController {


	@Autowired
	EmployeeService ep;
	
	
	//localhost:1234/addEmplyee
	@PostMapping("/addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		return new ResponseEntity<Employee>(ep.addEmployee(e),HttpStatus.CREATED);
	}
	
	@GetMapping("empById")
	ResponseEntity<Employee> getById(@RequestHeader Integer eid){
		return new ResponseEntity<Employee>(ep.getByEmployeeId(eid),HttpStatus.FOUND);
	}
	@GetMapping("empByJob")
	ResponseEntity<List<Employee>> getByJob(@RequestHeader String jod){
		return new ResponseEntity<List<Employee>>(ep.getByJob(jod),HttpStatus.FOUND);
	}
	@GetMapping("empBySal")
	ResponseEntity<List<Employee>> getBySal(@RequestHeader Double sal){
		return new ResponseEntity<List<Employee>>(ep.getByLessSal(sal),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateEmp")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee e){
		return new ResponseEntity<Employee>(ep.updateEmployee(e),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteEmp")
	ResponseEntity<Employee> deleteEmployee(Integer eid){
		return new ResponseEntity<Employee>(ep.deleteEmployee(eid),HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}