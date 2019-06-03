package com.pasindu.ems.service;

import com.pasindu.ems.model.Allocation;
import com.pasindu.ems.repository.AlloationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {


    @Autowired
    AlloationRepository allocationRepo;


    @Override
    public Allocation save(Allocation allocation) {

        return allocationRepo.save(allocation);
    }

    @Override
    public List<Allocation> fetchAllAllocation() {

        return allocationRepo.findAll();
    }

    @Override
    public Allocation fetchAllocation(Allocation allocation) {
        Optional<Allocation> optionalAllocation = allocationRepo.findById(allocation.getId());
        if(optionalAllocation.isPresent()) {
            return optionalAllocation.get();
        }
        else {
            return null;
        }
    }

    @Override
    public List<Allocation> findAllocationByEmpId(Integer empId) {

        return allocationRepo.findByempId(empId);
    }
}
