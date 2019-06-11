package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.hystrix.AllocationCommand;
import com.example.demo.modal.Allocation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.modal.Employee;
import com.example.demo.modal.Telephone;
import org.springframework.web.client.RestTemplate;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	RestTemplate restTemplate;
	@Override
	public Employee save(Employee employee) {
		
		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee fetchEmployee(Employee employee, HttpHeaders httpHeaders) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
		if(optionalEmployee.isPresent()) {
			Employee employee1=optionalEmployee.get();
		//RestTemplate restTemplate=new RestTemplate();
		//HttpHeaders httpHeaders=new HttpHeaders();
//			ResponseEntity<Allocation[]> responseEntity;
//
//
//
//
//		HttpEntity<String> entity=new HttpEntity<>("",httpHeaders);
//
//		responseEntity=restTemplate.exchange("http://allocation-service/emscloud/getAllocation/".
//				concat(employee.getId().toString()), HttpMethod.GET,entity,Allocation[].class);

			AllocationCommand allocationCommand=new AllocationCommand(employee1,httpHeaders,restTemplate);
			Allocation[] allocations=allocationCommand.execute();
//
			employee1.setAllocation(allocations);
			return employee1;
		}
		else {
			return null;
		}
	}
//		@HystrixCommand(fallbackMethod = "fetchEmployeeAllocationFallBack")
//	public Allocation[] fetchEmployeeAllocation(Employee employee) {
//		//RestTemplate restTemplate=new RestTemplate();
//		HttpHeaders httpHeaders=new HttpHeaders();
//
//		OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails)
//				SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//		httpHeaders.add("Authorization" ,"bearer".concat(details.getTokenValue()));
//
//		ResponseEntity<Allocation[]> responseEntity;
//
//		HttpEntity<String> entity=new HttpEntity<>("",httpHeaders);
//
//		responseEntity=restTemplate.exchange("http://allocation-service/emscloud/getAllocation/".
//				concat(employee.getId().toString()), HttpMethod.GET,entity,Allocation[].class);
//
//		return responseEntity.getBody();
//	}

	public Allocation[] fetchEmployeeAllocationFallBack(Employee employee){
		return  new Allocation[1];
	}
}