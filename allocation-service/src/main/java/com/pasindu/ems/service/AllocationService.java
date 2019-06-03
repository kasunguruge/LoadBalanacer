package com.pasindu.ems.service;

import com.pasindu.ems.model.Allocation;

import java.util.List;
import java.util.Optional;

public interface AllocationService {
    Allocation save(Allocation allocation);

    List<Allocation> fetchAllAllocation();

    Allocation fetchAllocation(Allocation allocation);

    List<Allocation> findAllocationByEmpId(Integer empId);
}
