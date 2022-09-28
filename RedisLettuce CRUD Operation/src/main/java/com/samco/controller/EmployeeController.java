package com.samco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samco.model.Employee;
import com.samco.repository.EmployeeRepository;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployees")
	public Employee SaveEmployee(@RequestBody Employee employee) {
		employeeRepository.saveEmployee(employee);
		return employee;
	}
	
	@GetMapping("/findEmployees")
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/findEmployees/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		return employeeRepository.findById(id);
	}
	
	@PutMapping("/employees")
	public void update(@RequestBody Employee emplopyee) {
		employeeRepository.update(emplopyee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		employeeRepository.delete(id);
	}
	
}
