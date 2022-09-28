package com.samco.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.samco.model.Employee;

@Repository
public class EmployeeRepository {

	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	
	public EmployeeRepository(RedisTemplate redisTemplate) {
		this.hashOperations= redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}

	public void saveEmployee(Employee employee) {
		hashOperations.put("Employee", employee.getId(), employee);
	}
	
	public List<Employee> findAll(){
		return hashOperations.values("Employee");
	}
	
	public Employee findById(Integer id) {
		return (Employee) hashOperations.get("Employee",id);
	}
	
	public void update(Employee employee) {
		saveEmployee(employee);
	}
	
	public void delete(Integer id) {
		hashOperations.delete("Employee",id);
	}
}