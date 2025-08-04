package com.openclassrooms.api_with_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.api_with_spring_boot.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
    // This interface will automatically inherit CRUD operations from CrudRepository
    // Additional custom query methods can be defined here if needed
    
}
