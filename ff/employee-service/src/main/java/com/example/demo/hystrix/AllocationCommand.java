package com.example.demo.hystrix;

import com.example.demo.modal.Allocation;
import com.example.demo.modal.Employee;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {

private Employee employee;
private HttpHeaders httpHeaders;
private RestTemplate restTemplate;

public  AllocationCommand(Employee employee,HttpHeaders httpHeaders,RestTemplate restTemplate){

    super(HystrixCommandGroupKey.Factory.asKey("default"));
    this.employee=employee;
    this.httpHeaders=httpHeaders;
    this.restTemplate=restTemplate;

}


    @Override
    protected Allocation[] run() throws Exception {
        		ResponseEntity<Allocation[]> responseEntity;

		HttpEntity<String> entity=new HttpEntity<>("",httpHeaders);

		responseEntity=restTemplate.exchange("http://allocation-service/emscloud/getAllocation/".
				concat(employee.getId().toString()), HttpMethod.GET,entity,Allocation[].class);

        return  responseEntity.getBody();
    }

    @Override
    protected Allocation[] getFallback(){
        return new Allocation[1];
    }

}
