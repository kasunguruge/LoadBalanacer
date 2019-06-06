package lk.kasun.ems.service;

import java.util.List;

import lk.kasun.ems.model.Employee;

public interface EmployeeService {

		Employee save(Employee employee);
		List<Employee> fetchAllEmployee();
		Employee fetchEmployee(Employee employee);
}
