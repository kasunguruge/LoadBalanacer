package com.pasindu.ems.controller;

import com.pasindu.ems.model.Allocation;
import com.pasindu.ems.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/emscloud")
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/setAllocation", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation employee) {
        return allocationService.save(employee);
    }

    @RequestMapping(value = "/getAllocation", method = RequestMethod.GET)
    public List<Allocation> fetchAllAllocation() {
        return allocationService.fetchAllAllocation();
    }

    @RequestMapping(value = "/getAllocation/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Allocation>> fetchAllocation(@PathVariable Integer id) {
        Allocation allocation = new Allocation();
        allocation.setId(id);
        Allocation allocation1 = allocationService.fetchAllocation(allocation);
        if (allocation1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(Arrays.asList(allocation1));
        }
    }

    @RequestMapping(value = "/employee/{empid}", method = RequestMethod.GET)
    public ResponseEntity<List<Allocation>> fetchEmployee(@PathVariable Integer empid) {


        return ResponseEntity.ok(allocationService.findAllocationByEmpId(empid));
    }

}

