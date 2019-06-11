package com.example.demo.service;

import java.util.List;

import com.example.demo.modal.Employee;
import org.springframework.http.HttpHeaders;

public interface EmployeeService {

	Employee save(Employee employee);
	List<Employee> fetchAllEmployee();
	Employee fetchEmployee(Employee employee, HttpHeaders httpHeaders);



}