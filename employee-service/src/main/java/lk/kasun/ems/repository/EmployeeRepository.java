package lk.kasun.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.kasun.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
