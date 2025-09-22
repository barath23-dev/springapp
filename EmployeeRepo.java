package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
   
}
